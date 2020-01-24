package ar.com.educacionit.cars.desktop.controller;

import ar.com.educacionit.cars.model.Car;
import ar.com.educacionit.cars.service.CarService;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class VentanaPrincipalController implements Initializable {

    @FXML
    private TableView<Car> table;

    private CarService carService = new CarService();

    @FXML
    private void importCars(ActionEvent event) {
        List<Car> cars = carService.importCars();

        table.getColumns().add(new TableColumn<>("Concatenacion1"));

        table.getColumns().add(new TableColumn<>("Concatenacion2"));

        TableColumn<Car, ?> columnMarca = table.getColumns().get(0);

        columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        TableColumn<Car, ?> columnAnio = table.getColumns().get(1);

        columnAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));

        TableColumn<Car, ?> columnConcatenacion1 = table.getColumns().get(2);

        columnConcatenacion1.setCellValueFactory(new PropertyValueFactory<>("concat"));

        TableColumn<Car, String> columnConcatenacion2 = (TableColumn<Car, String>) table.getColumns().get(3);

        columnConcatenacion2.setCellValueFactory((p) -> {
            ObservableValue<String> r = new SimpleStringProperty(p.getValue().getMarca() + "#" + p.getValue().getAnio());
            return r;
        });

        for (Car car : cars) {
            table.getItems().add(car);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
