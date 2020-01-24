/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.cars.desktop.controller;

import ar.com.educacionit.cars.model.Car;
import ar.com.educacionit.cars.service.CarService;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author EducaciónIT
 */
public class VentanaPrincipalController implements Initializable {
    
    @FXML
    private TableView<Car> table;
    
    private CarService carService = new CarService();
    
    @FXML
    private void importCars(ActionEvent event) {
        List<Car> cars = carService.importCars();
        
        table.getColumns().add(new TableColumn<>("Concatenacion"));
        
        TableColumn<Car, ?> columnMarca = table.getColumns().get(0);
        
        columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        
        TableColumn<Car, ?> columnAnio = table.getColumns().get(1);
        
        columnAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        
        TableColumn<Car, ?> columnConcatenacion = table.getColumns().get(2);
        
        
        
        
        
        
        
        for (Car car : cars) {           
            table.getItems().add(car);
        }     
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }        
}
