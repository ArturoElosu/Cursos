package clase9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivos {
    
    public static void main(String[] args) {        
        
        File file = new File("../Clase9/datos");
        
        try (FileWriter fw = new FileWriter(file)) {
            
            System.out.println(System.getProperty("java.version"));
            System.out.println(System.getProperty("user.dir"));
            
            System.out.println(file.exists());
            System.out.println(file.isFile());
            System.out.println(file.isDirectory());
            
            
            
            String lineSeparator = System.lineSeparator();
            fw.write("Hola Mundo 1" + lineSeparator);
            fw.write("Hola Mundo 3" + lineSeparator);
            fw.write("Hola Mundo 5" + lineSeparator);
            fw.write("Hola Mundo 7" + lineSeparator);
            fw.write("Hola Mundo 9" + lineSeparator);
            
            
            
            System.out.println("Fin del programa");
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
