package Clase4;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class Programa {
    public static void main(String[] args) {
        // Leer comando por consola
        
        // En base al String entrante crear Objeto Commando
        
        // Almacenar Comando en Array
        Comando c = new CrearArchivo();
        Comando l = new ListarArchivos();
        
        List<Comando> lista = new LinkedList<>();
        /*
        Uso LIST para generalizar.
        Uso LINKEDLIST porque, en este caso me permite usar menos recursos que un ArrayList
        porque cuando se agregan comandos no duplica el uso de memoria.
        */
        lista.add(c);
        lista.add(l);
        
        Iterator<Comando> iterator = /*lista.iterator();*/ devolverIterator(lista);
        
        // El iterator indica cómo se recorre una lista.
        
        while(iterator.hasNext()) {
            Comando c1 = iterator.next();
            c1.ejecutar();
        }
    }

    private static Iterator<Comando> devolverIterator(List<Comando> lista) {
        return new MiIterador(lista);
        // return lista.iterator(); es el default
    }
}
