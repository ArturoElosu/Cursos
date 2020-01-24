package com.mycompany.clase11;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericDAO<T> implements DAO<T> {

    private final Class<T> clazz;

    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<T> findAll() {
        List<T> datos = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

            String tableName = clazz.getSimpleName().toLowerCase();
            NombreTabla annotation = clazz.getAnnotation(NombreTabla.class);
            if (annotation != null) {
                tableName = annotation.nombre();
            }
            
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + tableName);

            ResultSet rs = ps.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            List<String> columnas = new ArrayList<>();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                columnas.add(columnName);
            }

            while (rs.next()) {
                T dato = clazz.newInstance();

                for (String columna : columnas) {
                    PropertyDescriptor pd = null;

                    if (columna.startsWith("id")) {
                        pd = new PropertyDescriptor("id", clazz);
                    } else {
                        pd = new PropertyDescriptor(columna, clazz);
                    }

                    Method setter = pd.getWriteMethod();

                    Object valorDesdeLaDB = rs.getObject(columna);
                    if (valorDesdeLaDB instanceof BigDecimal) {
                        valorDesdeLaDB = ((BigDecimal) valorDesdeLaDB).doubleValue();
                    }
                    setter.invoke(dato, valorDesdeLaDB);
                }

                datos.add(dato);
            }

            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datos;
    }

    @Override
    public T save(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
