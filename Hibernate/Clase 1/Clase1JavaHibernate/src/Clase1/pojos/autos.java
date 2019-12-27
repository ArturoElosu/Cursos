package clase1.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="autos")
public class autos implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //auto_incremental
    @Column(name="au_id")
    private int Id_Auto;
    @Column(name="au_marca")
    private String Marca;
    @Column(name="au_modelo")
    private String Modelo;
    @Column(name="au_fecha_venta")
    private Date Fecha_Venta;
    @Column(name="au_precio")
    private double precio;
    @Column(name="au_concesionario")
    private int Id_Concesionario;
    

    public int getId_Auto() {
        return Id_Auto;
    }

    public void setId_Auto(int Id_Auto) {
        this.Id_Auto = Id_Auto;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public Date getFecha_Venta() {
        return Fecha_Venta;
    }

    public void setFecha_Venta(Date Fecha_Venta) {
        this.Fecha_Venta = Fecha_Venta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_Concesionario() {
        return Id_Concesionario;
    }

    public void setId_Concesionario(int Id_Concesionario) {
        this.Id_Concesionario = Id_Concesionario;
    }
}
