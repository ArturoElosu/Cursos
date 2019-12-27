package Clase1;

import clase1.pojos.autos;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Clase1JavaHibernate {

    public static void main(String[] args) {
        Session sesion = SessionFactory.getSession();
        
        //guardar un auto en la base de datos
        autos a1 = new autos();
        a1.setFecha_Venta(new Date());
        a1.setMarca("Peugeot");
        a1.setModelo("308");
        a1.setPrecio(300000);
        a1.setId_Concesionario(1);
        
        Transaction tx = sesion.beginTransaction();
        sesion.save(a1);
        tx.commit();
        
    }
    
}
