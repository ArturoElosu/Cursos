package Clase4;
import java.util.Iterator;
import java.util.List;
public class MiIterador implements Iterator<Comando> {
    
    private final List<Comando> lista;
    private int index;
    
    public MiIterador(List<Comando> lista) {
        this.lista = lista;
        this.index = lista.size() - 1;
    }
    
    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Comando next() {
        Comando c = lista.get(index);
        index = index - 1;
        return c;
    }
    
}
