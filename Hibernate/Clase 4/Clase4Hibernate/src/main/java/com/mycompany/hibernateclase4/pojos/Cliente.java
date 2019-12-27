package com.mycompany.hibernateclase4.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
@DiscriminatorValue("C")
public class Cliente extends Personas implements Serializable {
    
    @Column(name = "pe_cl_nro")
    private String numero;
    
    @Column(name = "pe_cl_tipo")
    private char tipo;
    
    public Cliente (){
        
    }

    public Cliente(String numero, char tipo, String nombre, String apellido, String direccion) {
        super(nombre, apellido, direccion);
        this.numero = numero;
        this.tipo = tipo;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
}
