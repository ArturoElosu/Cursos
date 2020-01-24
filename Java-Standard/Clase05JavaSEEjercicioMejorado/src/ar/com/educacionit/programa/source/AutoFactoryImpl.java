package ar.com.educacionit.programa.source;

import ar.com.educacionit.programa.modelo.Auto;

public class AutoFactoryImpl implements AutoFactory {

    @Override
    public Auto build(String data) {
        String[] datos = data.split(",");
        String concesionaria = datos[0];
        String marca = null;
        String modelo = null;
        if (concesionaria.equals("A")) {
            marca = datos[1];
            modelo = datos[2];
        } else {
            modelo = datos[1];
            marca = datos[2];
        }
        Integer anio = Integer.valueOf(datos[3]);
        Double precio = Double.valueOf(datos[4]);

        return new Auto(marca, modelo, anio, precio);
    }

}
