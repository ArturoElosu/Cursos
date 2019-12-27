package com.mycompany.hibernateclase4.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
@DiscriminatorValue("V")
public class Vendedor extends Personas implements Serializable{
    
    @Column(name = "pe_ve_legajo")
    private String legajo;
    
    @Column(name = "pe_ve_fecha_ingreso")
    private Date fecha_ingreso;
    
    public Vendedor(){
        
    }

    public Vendedor(String legajo, Date fechaIngreso, String nombre, String apellido, String direccion) {
        super(nombre, apellido, direccion);
        this.legajo = legajo;
        this.fecha_ingreso = fechaIngreso;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public Date getFechaIngreso() {
        return fecha_ingreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fecha_ingreso = fechaIngreso;
    }
}
