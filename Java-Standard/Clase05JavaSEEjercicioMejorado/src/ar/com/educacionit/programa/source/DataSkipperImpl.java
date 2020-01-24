package ar.com.educacionit.programa.source;

import java.util.ArrayList;
import java.util.List;

public class DataSkipperImpl implements DataSkipper{

    private int cantidadDeLineasAExcluir;

    public DataSkipperImpl(int cantidadDeLineasAExcluir) {
        this.cantidadDeLineasAExcluir = cantidadDeLineasAExcluir;
    }
    
    @Override
    public List<String> filter(List<String> data) {
        List<String> dataFiltrada = new ArrayList<>();
        
        int index = 0;
        for (String elem : data) {
            if (index >= cantidadDeLineasAExcluir) {
                dataFiltrada.add(elem);
            }
            index++;
        }
        
        return dataFiltrada;
    }
    
}
