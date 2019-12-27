package ar.com.hibernate.custom;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        Dialect dao = new MySQLDialect();
        
        Person p = new Person();
        
        p.setNombre("Cosme");
        p.setEdad(78);
        
        dao.salvar(p);
        
        List<Person> personasDesdeLaBase = dao.obtener(Person.class);
        
        for (Person pa : personasDesdeLaBase) {
            System.out.println(pa);
        }
    }
}
