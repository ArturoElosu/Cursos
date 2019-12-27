/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasehibernatesabados;

import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactory {

    public static Session getSession() throws HibernateException {
        Configuration config = new Configuration();
// Registra los mappers en la configuracion

        registerMappers(config);

// Establece las propiedades de configuracion
        config.setProperties(getHibernateProperties());

// Guarda la fabrica de sesiones
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());

    //   SessionFactory  factory = (SessionFactory) config.buildSessionFactory(builder.build());

// Retorna una sesion de trabajo
      //  return factory.openSession();
      return config.buildSessionFactory(builder.build()).openSession();

    }

    private static Properties getHibernateProperties() {

        Properties props = new Properties();

        props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        props.put("hibernate.connection.url", "jdbc:mysql://localhost/hibernate?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        props.put("hibernate.connection.username", "root");
        props.put("hibernate.connection.password", "");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        return props;

    }

    private static void registerMappers(Configuration config) throws MappingException {

        config.addAnnotatedClass(clasehibernatesabados.tablas.Autos.class);
        config.addAnnotatedClass(clasehibernatesabados.tablas.Concesionario.class);
        
        /* VERIFICAR SI SE PUEDE INCLUIR UN PACKAGE EN VEZ DE CLASE POR CLASE*/
        
    }

}
