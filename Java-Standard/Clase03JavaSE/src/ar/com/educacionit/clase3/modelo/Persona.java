package ar.com.educacionit.clase3.modelo;
public class Persona implements Imprimible {
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
            
//    @Override //sirve para el compilador x si la cagas pero no es obligatorio para sobreescribir
//    public String toString() {
//        return imprimirDatos(); // delega la funcion
//    }
//    
//    private String imprimirDatos() {
//        
//        return nombre + " - " + edad;
//    } // éste es el método

    @Override
    public boolean equals(Object obj) {
        String miNombre = nombre;
        if (obj instanceof Persona) {
            Persona pInterna = (Persona) obj; // casteo una persona para poder manipular el objeto como una y acceder a sus datos
            String nombre1 = pInterna.getNombre();
            return nombre1.equals(miNombre);
        } else {
            return false;
        }
    }
    
    @Override
    public String imprimir() {
        return "Imprimiendo una persona";
    }
}
