package ar.com.educacionit.clase3.modelo;
public class Alumno extends Persona { // indico que un Alumno es una Persona (HERENCIA)
    
    private String dni; // por ende puedo agregar también el DNI

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() { // puedo redefinir el toString para que Alumno muestre lo que yo quiera y no lo definido en Persona
        String aux = super.toString(); // uso el toString de Persona
        return "Alumno{" + "dni=" + dni + '}' + aux;
    }
}
