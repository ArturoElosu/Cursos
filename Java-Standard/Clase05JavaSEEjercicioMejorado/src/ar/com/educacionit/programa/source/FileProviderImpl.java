package ar.com.educacionit.programa.source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.readAllLines;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileProviderImpl implements AutoSourceProvider{

    private String path;
    
    public FileProviderImpl(String path) {
        this.path = path;
    }

    
    @Override
    public List<String> read() {
        List<String> datos = new ArrayList<>();
        try {
            File archivoEntrada = new File(path);
            datos = Files.readAllLines(archivoEntrada.toPath());
        } catch (IOException ex) {
            Logger.getLogger(FileProviderImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
}
