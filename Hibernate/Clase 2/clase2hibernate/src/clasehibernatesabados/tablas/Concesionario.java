package clasehibernatesabados.tablas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="concesionario")
public class Concesionario implements Serializable {

    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_cons")
    private Long id;
    @Column(name="nombre")    
    private String nombre;
    @Column(name="direccion")    
    private String direccion;
    
    public Concesionario(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
