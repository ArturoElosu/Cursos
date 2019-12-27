package clasehibernatesabados;

import clasehibernatesabados.tablas.Autos;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Clasehibernatesabados {

    public static void main(String[] args) {
        
        Session sesion = SessionFactory.getSession();
        /*  insertarauto("Peugeot", "307", sesion);
        insertarauto("Audi", "A8", sesion);
        insertarauto("Mercedez", "C320", sesion);*/
 /*  List<Autos> lista = buscartodos(sesion);
        
        Iterator<Autos> itautos = lista.iterator();        
        while (itautos.hasNext()) {
            Autos itemp = itautos.next();
            System.out.println("Modelo " + itemp.getMarca()
                    + " -- Modelo " + itemp.getModelo());

            //realizacion de actualizacion de concesionario
            Transaction tx = sesion.beginTransaction();
            itemp.setConcesionario("Avellaneda Cars");
            sesion.update(itemp);
            tx.commit();
        }*/
        buscarunauto("Peugeot", sesion);
        sesion.close();
    }

    public static void buscarunauto(String marca, Session sesion) {

        List<Autos> listautos
                = sesion.createQuery("FROM Autos  where marca='Peugeot'").list();
        System.out.println("Cantidad de autos devueltos " + listautos.size());

    }

    public static void insertarauto(String marca, String modelo, Session sesion) {
        Autos auto1 = new Autos();
        auto1.setMarca(marca);
        auto1.setModelo(modelo);
        Transaction tx = sesion.beginTransaction();
        sesion.save(auto1);
        tx.commit();

    }

    public static List<Autos> buscartodos(Session sesion) {
        List<Autos> listautos = sesion.createQuery("FROM Autos").list();

        return listautos;
    }

}
