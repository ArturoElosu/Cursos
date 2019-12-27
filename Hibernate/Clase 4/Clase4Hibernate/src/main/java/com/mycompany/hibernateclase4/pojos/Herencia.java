package com.mycompany.hibernateclase4.pojos;

import com.mycompany.hibernateclase4.Programa;
import com.mycompany.hibernateclase4.pojos.Vendedor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
//import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Herencia {

    public static void main(String[] args) throws ParseException {
        Session sesion = Programa.getSession();

        List clientes = sesion.createQuery("From Cliente").list();
        Iterator it = clientes.iterator();

        while (it.hasNext()) {
            Cliente tmp = (Cliente) it.next();
            System.out.println("" + tmp);
        }

        List vendedor = sesion.createQuery("From Vendedor").list();
        it = vendedor.iterator();

        while (it.hasNext()) {
            Vendedor tmp = (Vendedor) it.next();
            System.out.println("" + tmp);
        }

        /*Transaction tx = sesion.beginTransaction();

        Vendedor v1 = new Vendedor(StringToDate("21/01/2014"), "Jose", "Mendez", "Lanus", "V-84654");
        sesion.save(v1);
        Cliente c1 = new Cliente("584654650", 'P', "Elena", "Perez", "Avellaneda");
        sesion.save(c1);

        tx.commit();
        sesion.close();*/

    }

    public static Date StringToDate(String fechatransformar) throws ParseException {
        String sDate1 = fechatransformar; //"31/12/1998";
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        return date1;
    }
}
