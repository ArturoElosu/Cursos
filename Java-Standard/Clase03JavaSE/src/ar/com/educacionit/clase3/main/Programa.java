package ar.com.educacionit.clase3.main;
import ar.com.educacionit.clase3.modelo.Persona;
public class Programa {
    public static void main(String[] args) {
//        1 - Crear un paquete llamado ar.com.educacionit.clase3.main
//        2 - Crear un paquete llamado ar.com.educacionit.clase3.modelo
//        3 - Crear una clase llamada Persona que este en el paquete "ar.com.educacionit.clase3.modelo"
//        4 - En la clase Persona agregar un atributo de tipo String llamado nombre
//        5 - Construir getters/setters para el atributo nombre
//        6 - Crear una clase llamada Programa en el paquete "ar.com.educacionit.clase.main"
//        7 - En el metodo main de la clase Programa crear un objeto de persona
//        8 - Asignarle un nombre que ustedes deseen
//        9 - Imprimir nombre de la instancia por consola
        
        System.out.println("Inicio del programa.");
        
        System.out.println("1era parte:");
        
        Persona p1 = new Persona();
        
        p1.setNombre("Cosme Fulanito");
        
        // en caso de no tener el nombre el valor por default es null.
        // Ocacionalmente puede solucionarse con un if(nombre!=null)
        
        // NullPointerException es cuando se le pide el valor a algo pero no tiene ninguno (null)
        
        p1.setEdad(99);
        
        //String nombre = p1.getNombre();
        
        //System.out.println(nombre.charAt(2));
        
        // el charAt(2) hace que se imprima el caracter de la posición 2 nombre, en este caso la S
        
        System.out.println(p1); // es la versión corta de p1.toString()
        
        /* Es igual a decir:
        String mensaje = p1 == null ? "null" : p1.toString();
        System.out.println(mensaje);

        Ésto es un IF TERNARIO. p1 == null es la condición. En caso que sea TRUE, devuelve "null".
        En caso que sea FALSE, devuelve p1.toString()
        */
        
        //System.out.println(p1.imprimirDatos()); // <-- puedo usarlo o utilizar el toString()
        
        // puedo hacerlo con p1.getNombre() y p1.getEdad() pero de esta forma se usa el método
        
        //-------------------------------------------------------------------
        
        System.out.println("2da parte:");
        
        // lado izq: qué puedo hacer || lado derecho: cómo puedo hacerlo
        Persona p2 = new Persona();
        Persona p3 = new Persona();
        
        p2.setNombre("Cosme Fulanito"); // los objetos no son iguales porque tienen distinto espacio en memoria
        p3.setNombre("Cosme Fulanito");
        
        if (p2.equals(p3)) {
            System.out.println("Objetos son iguales."); // para que funcione hay que redefinir .equals
        }
        
        System.out.println("Fin del programa.");
    }
}
