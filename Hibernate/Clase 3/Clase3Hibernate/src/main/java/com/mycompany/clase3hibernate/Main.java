package com.mycompany.clase3hibernate;

import com.mycompany.clase3hibernate.model.Book;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {
        
        /* Inicializar Hibernate */
        
        ServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
        
        MetadataSources ms = new MetadataSources(sr);
        
        Metadata m = ms.buildMetadata();
        
        SessionFactory sf = m.getSessionFactoryBuilder().build();
        
        Session s = sf.openSession();
        
        // Hibernate inicializado!
        
        s.beginTransaction(); // Las Transaction funcionan para enviar un paquete de tareas a ejecutar todas juntas.
        
        for (int i = 0; i < 10; i++) {
            
            Book b = new Book();
            
            b.setNombre("Libro-" + i);
            
            s.saveOrUpdate(b);
            
        }
        
        System.out.println("Select todos los libros:");
        
        Query<Book> q = s.createQuery("SELECT b FROM Book b WHERE b.id= 1", Book.class); //Devuelve Objetos Book
        
        // Puede escribirse también así: "FROM Book WHERE id=1". Puedo también darle un apodo: "FROM Book z WHERE z.id=1".
        
        // "FROM Book" Devuelve TODOS los resultados. "SELECT b FROM Book b" TAMBIÉN!
        
        // "FROM Book z WHERE z.nombre = ?1 AND z.id = ?2" Necesita que se le pasen los parámetros 1 y 2 (serían los usuarios).
        
        // "FROM Book z WHERE z.nombre = ?1 AND z.id = :acavaid" El 2do parámetro se llama 'acavaid'. No responde a un número.
        
        /* EJEMPLO:
        q.setParameter(1, "Libro-3");
        q.setParameter("acavaid", 4);
        */
        
        /* q.getSingleResult(); <- Sirve para asegurarnos que sólo devuelve 1 resultado
        Si da más de 1 resultado, explota.
         */
        
        List<Book> books = q.list();
        
        for (Book book : books) {
            System.out.println(book);
        }
        
        /* Si no quiero que me cree objetos Book puedo hacer lo siguiente:
        
        Query<Integer> q = s.createQuery("SELECT b.id FROM Book b", Integer.class);
        
        q.setMaxResults(3); // Da los primeros 3 resultados.
        
        q.setFirstResult(3); // Hace que aparezcan los siguientes 3 resultados (4, 5 y 6).
        
        List<Integer> books = q.list();
        
        for (Integer book : books) {
            System.out.println(book);
        }
        
        */
        
        /* Si quiero pedir ID y NOMBRE:
        
        Query<Object> q = s.createQuery("SELECT b.id, b.nombre FROM Book b");
        
        List<Object> books = q.list();
        
        for (Object book : books) {
            Object[] data = (Object[]) book;
            System.out.println(data[0]);
            System.out.println(data[1]);
        }
        
        */
        
        s.getTransaction().commit();  // Si hay un error, debemos hacer un rollback. Lo ideal es utilizar los try catch.
        
        s.close();
        
        sf.close();
        
    }
    
}
