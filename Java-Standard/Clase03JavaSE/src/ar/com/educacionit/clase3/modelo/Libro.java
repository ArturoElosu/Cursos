package ar.com.educacionit.clase3.modelo;
public class Libro implements Imprimible {
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String imprimir() {
        return "";
    }
}
