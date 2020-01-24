package ar.com.educacionit.cars.service;

import ar.com.educacionit.cars.model.Car;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarService {
    
    
    public List<Car> importCars()  {        
        List<Car> cars = new ArrayList<>();
        
        try (FileReader r = new FileReader("datos.txt"); BufferedReader br = new BufferedReader(r)){
            
            String line = br.readLine();
            while (line != null) {
                Car car = new Car();
                
                String[] data = line.split(",");
                car.setMarca(data[0]);
                car.setAnio(Integer.valueOf(data[1]));
                
                cars.add(car);
                line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cars;
    }
    
}
