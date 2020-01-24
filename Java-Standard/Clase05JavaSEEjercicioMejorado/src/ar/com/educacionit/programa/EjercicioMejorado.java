package ar.com.educacionit.programa;

import ar.com.educacionit.programa.modelo.Auto;
import ar.com.educacionit.programa.source.AutoFactory;
import ar.com.educacionit.programa.source.AutoFactoryImpl;
import ar.com.educacionit.programa.source.AutoSourceProvider;
import ar.com.educacionit.programa.source.DataSkipper;
import ar.com.educacionit.programa.source.DataSkipperImpl;
import ar.com.educacionit.programa.source.FileProviderImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjercicioMejorado {

    public static void main(String[] args) throws Exception {        
        AutoSourceProvider provider = new FileProviderImpl("C:\\Users\\usuario\\Desktop\\Archivos Ejercicio Clase 5\\Datos.txt");
        AutoFactory factory = new AutoFactoryImpl();
        DataSkipper ds = new DataSkipperImpl(1);
        
        List<String> dataOriginal = provider.read();
        List<String> dataSinHeader = ds.filter(dataOriginal);
        
        // Creo una lista temporal de autos
        List<Auto> autos = new ArrayList<>();

        for (String linea : dataSinHeader) {
            autos.add(factory.build(linea));
        }

        // Filtrado
        List<Auto> autosLuegoDelFiltro = new ArrayList<>();

        for (int i = 0; i < autos.size(); i++) {
            Auto auto = autos.get(i);
            if (auto.getAnio() > 2000) {
                autosLuegoDelFiltro.add(auto);
            }
        }

        // Genero archivo salida
        FileWriter fw = new FileWriter("salida.txt");

        // Escribo encabezado
        fw.write("Marca, Modelo, Año, Precio Original, Precio Final\n");

        for (int i = 0; i < autosLuegoDelFiltro.size(); i++) {
            Auto auto = autosLuegoDelFiltro.get(i);

            fw.write(auto.getMarca());
            fw.write(",");

            fw.write(auto.getModelo());
            fw.write(",");

            fw.write(String.valueOf(auto.getAnio()));
            fw.write(",");

            fw.write(String.valueOf(auto.getPrecio()));
            fw.write(",");

            fw.write(String.valueOf(auto.getPrecio() * 1.25));
            fw.write("\n");
        }

        fw.close();
    }

}
