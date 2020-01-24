package ejercicio;

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

public class Ejercicio {

    public static void main(String[] args) throws Exception {   
        // Definicion del lector
        File archivoEntrada = new File("C:\\Users\\usuario\\Desktop\\Archivos Ejercicio Clase 5\\Datos.txt");
        FileReader fr = new FileReader(archivoEntrada);            
        BufferedReader br = new BufferedReader(fr);
        
        // Leo primer linea
        String linea = br.readLine();
        
        // Hago skip de la cantidad de lineas que quiero
        int cantidadDeLineasAExcluir = 1;
        
        int index = 0;
        while (linea != null && index < cantidadDeLineasAExcluir) {
            linea = br.readLine();   
            index++;
        }
        
        // Creo una lista temporal de autos
        List<Auto> autos = new ArrayList<>();
        
        // Recorro el resto del archivo linea a linea
        while (linea != null) {
            String[] datos = linea.split(",");
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
            
            Auto auto = new Auto(marca, modelo, anio, precio);

            autos.add(auto);
            linea = br.readLine();            
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
