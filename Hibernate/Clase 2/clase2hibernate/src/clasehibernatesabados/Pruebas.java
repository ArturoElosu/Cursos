package clasehibernatesabados;

import clasehibernatesabados.tablas.Autos;
import java.util.Iterator;
import java.util.List;
//import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Pruebas {

    public static void main(String[] args) {
        
        Session sesion = SessionFactory.getSession();
        
        //BuscarAutos(sesion);
        //InsertarAutos(sesion);
        CantidadColores(sesion);
        
        sesion.close();
    }
    
    public static void CantidadColores(Session sesion){
        Query qry = sesion.createQuery("select color, count(color)" + " from Autos group by color");
        
        
        Iterator it = qry.iterate();
        while(it.hasNext()){
            Object[] row = (Object[]) it.next();
                System.out.println("Suma: " + row[0] + " - Cantidad: " + row[1]);
        }
    }
    
    public static void InsertarAutos(Session sesion){
        // Agregar varios colores a partir del String de colores
        String[] colores = "rojo,azul,amarillo,rojo,azul,verde".split(",");
        String[] marca = "peugeot,mazda,mercedes,fiat,ford,audi".split(",");
        String[] modelo = "308,tornado,1114,siena,fiesta,tt".split(",");
        String[] precio = "100000,100000,1000,1000,1000,10000".split(",");
        
        Transaction tx = sesion.beginTransaction();
        
        for (int i = 0; i < colores.length; i++) {
            Autos auto = new Autos();
            auto.setColor(colores[i]);
            auto.setConcesionario("1");
            auto.setMarca(marca[i]);
            auto.setModelo(modelo[i]);
            sesion.save(auto);
        }
        
        tx.commit();
    }
    
    public static void BuscarAutos(Session sesion){
        List resultadoAutos = sesion.createQuery("from Autos where marca='peugeot'").list();
        Iterator <Autos>it= resultadoAutos.iterator();
        
        while(it.hasNext()){
        Autos auto= it.next();
        
        System.out.println(auto.getMarca()+ ": " +auto.getModelo());
        }
    }
}
