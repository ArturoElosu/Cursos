package com.mycompany.clase11;

@NombreTabla(nombre = "profesores")
public class Profesor {
    
    private int id;
    
    private String nombre;
    
    private double salario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Profesor{" + "id=" + id + ", nombre=" + nombre + ", salario=" + salario + '}';
    }
    
    
}
