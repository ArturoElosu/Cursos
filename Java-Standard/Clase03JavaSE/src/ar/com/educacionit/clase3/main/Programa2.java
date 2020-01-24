package ar.com.educacionit.clase3.main;
import ar.com.educacionit.clase3.modelo.Alumno;
import ar.com.educacionit.clase3.modelo.Imprimible;
import ar.com.educacionit.clase3.modelo.Libro;
import ar.com.educacionit.clase3.modelo.Persona;
public class Programa2 {
    public static void main(String[] args) {
        /*
        Persona p1 = new Persona();
        Alumno a1 = new Alumno();
        
//        p1.setNombre("Luis");
//        a1.setNombre("Daniel");
//        
//        imprimir(p1);
//        imprimir(a1);
        
        a1.setDni("12345678");
        
        p1 = a1; // indico que p1 también hace cosas de alumno
        
        imprimir(p1);
        
        Persona p1 = new Alumno();
        Alumno a1 = new Alumno();
        
        a1.setDni("12345678");
        
        a1 = (Alumno) p1; // Casteo: le digo que p1 es un alumno
        
        imprimir(p1);
        */
        
        Persona p1 = new Alumno();
        Alumno a1 = new Alumno();
        Libro l1 = new Libro();
        
        p1.setNombre("Cosme Fulanito");
        a1.setNombre("Sancho Panza");
        l1.setNombre("Harry Potter");
        
        imprimir(p1);
        imprimir(a1);
        imprimir(l1);
    }
    
//    public static void imprimir(Persona o){ // método de forma genérica
//        System.out.println("****************************************");
//        System.out.println(o);
//        System.out.println("****************************************");
//    }
    public static void imprimir(Imprimible o){
        System.out.println("****************************************");
        System.out.println(o);
        System.out.println("****************************************");
    }
}
