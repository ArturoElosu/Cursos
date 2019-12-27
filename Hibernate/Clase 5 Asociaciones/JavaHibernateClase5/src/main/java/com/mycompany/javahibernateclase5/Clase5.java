package com.mycompany.javahibernateclase5;

import com.mycompany.javahibernateclase5.model.Alumno;
import com.mycompany.javahibernateclase5.model.Direccion;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Clase5 {

    public static void main(String[] args) throws NumberFormatException {
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();

        StandardServiceRegistry sr = sb.configure().build();

        MetadataSources ms = new MetadataSources(sr);
        Metadata metadata = ms.getMetadataBuilder().build();
        SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();

        SessionFactory sf = sessionFactoryBuilder.build();

        Session s = sf.openSession();

        s.beginTransaction();

        Alumno a = new Alumno();

        Scanner sc1 = new Scanner(System.in);

        System.out.println("Ingrese el nombre del alumno: ");

        String nombre = sc1.nextLine();

        a.setNombre(nombre);

        Direccion d = new Direccion();

        Scanner sc2 = new Scanner(System.in);

        System.out.println("Ingrese la calle: ");

        String calle = sc2.nextLine();

        d.setCalle(calle);

        Scanner sc3 = new Scanner(System.in);

        System.out.println("Ingrese la altura: ");

        String numero = sc3.nextLine();
        
        Integer numInt = Integer.valueOf(numero);

        d.setNumero(numInt);
        
        a.setDireccion(d);
        
//        s.saveOrUpdate(d); Como hice un Cascade no necesito indicar ésta línea de código.
        
//        d.setAlumno(a); Éste sirve para dar BI direccionalidad en la DB.
        
        s.saveOrUpdate(a);

        s.getTransaction().commit();

    }

}
