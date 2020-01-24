/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.cars.desktop.controller;

import ar.com.educacionit.cars.model.Car;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author EducaciónIT
 */
public class CustomColum extends PropertyValueFactory<Car, String>{
    
    public CustomColum(String property) {
        super(property);
    }


    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Car, String> param) {        
        return new SimpleStringProperty(param.getValue().getMarca() + "-" + param.getValue().getAnio());
    }

    
    
}
