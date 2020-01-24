package ar.com.educacionit.cars.model;

public class Car {

    private String marca;

    private int anio;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public String getConcat() {
        return marca + "/" + anio;
    }

    @Override
    public String toString() {
        return "Car{" + "marca=" + marca + ", anio=" + anio + '}';
    }

}
