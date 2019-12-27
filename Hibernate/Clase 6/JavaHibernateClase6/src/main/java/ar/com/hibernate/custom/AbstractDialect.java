package ar.com.hibernate.custom;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

public class AbstractDialect implements Dialect{
    
    @Override
    public Person obtener(Class<Person> clazz, Long id) {
        return null;
    }
    
    public List<Person> obtener(Class<Person> clazz){
        try {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            
            String tableName = tableAnnotation != null ? tableAnnotation.name() : clazz.getSimpleName().toLowerCase();
            
            String sql = "SELECT * FROM " + tableName;
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custom_hibernate", "root", "");
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            List<Person> personas = new ArrayList<>();
            while(rs.next()) {
                Person p = clazz.newInstance();
                
                Field[] declaredFields = clazz.getDeclaredFields();
                
                for (Field declaredField : declaredFields) {
                    
                    Column columnAnnotation = declaredField.getAnnotation(Column.class);
                    String columnName = columnAnnotation != null ? columnAnnotation.name() : declaredField.getName();
                
                    Object value = rs.getObject(columnName);
                    
                    PropertyDescriptor pd = new PropertyDescriptor(declaredField.getName(), clazz);
                    
                    Method write = pd.getWriteMethod();
                    
                    
                    write.invoke(p, value);
                }
                
                personas.add(p);
            }
            
            rs.close();
            ps.close();
            
            connection.close();
            return personas;
        } catch (Exception ex) {
            Logger.getLogger(AbstractDialect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void salvar(Person p) {
        try {
            Table tableAnnotation = p.getClass().getAnnotation(Table.class);
            
            String tableName = tableAnnotation.name();
            
            Field[] declaredFields = p.getClass().getDeclaredFields();
            
            StringJoiner sj = new StringJoiner(",");
            
            List<Field> fields = new ArrayList<>();
            for (Field declaredField : declaredFields) {
                boolean isId = declaredField.getAnnotation(Id.class) != null;
                
                if (isId != true) {
                    Column columnAnnotation = declaredField.getAnnotation(Column.class);
                    String columnName = columnAnnotation != null ? columnAnnotation.name() : declaredField.getName();
                    sj.add(columnName);
                    fields.add(declaredField);
                }
            }
            
            StringJoiner sjv = new StringJoiner(",");
            for (Field field : fields) {
                try {
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), p.getClass());
                    
                    Method readMethod = pd.getReadMethod();
                    
                    Object value = readMethod.invoke(p, new Object[0]);
                    
                    if (value instanceof String || value instanceof Date) {
                        sjv.add("'"+value.toString()+"'");
                    } else {
                        sjv.add(value.toString());
                    }
                    
                } catch (Exception ex) {
                    Logger.getLogger(OracleDialect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String insert = getInserPrefix() + tableName + " (" + sj.toString() + ") VALUES (" + sjv.toString() + ")";
            
            System.out.println(insert);
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custom_hibernate", "root", "");
            
            PreparedStatement ps = connection.prepareStatement(insert);
            
            ps.execute();
            
            ps.close();
            
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDialect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    protected String getInserPrefix() {
        return "INSERT INTO ";
    }

    
}
