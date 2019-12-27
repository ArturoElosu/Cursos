package com.mycompany.clase3hibernate.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name")
    private String nombre;
    
    @Temporal(TemporalType.DATE)
    private Date fechaLanzamiento;
    
    private LocalDate fechaFinalizacion;
    
    private double precio;
    
    @Transient //@Transient evita que aparezca la columna. Directamente no aparece en la base de datos.
    private boolean estaFeliz;

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", nombre=" + nombre + ", fechaLanzamiento=" + fechaLanzamiento + ", fechaFinalizacion=" + fechaFinalizacion + ", precio=" + precio + ", estaFeliz=" + estaFeliz + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstaFeliz() {
        return estaFeliz;
    }

    public void setEstaFeliz(boolean estaFeliz) {
        this.estaFeliz = estaFeliz;
    }
    
}
