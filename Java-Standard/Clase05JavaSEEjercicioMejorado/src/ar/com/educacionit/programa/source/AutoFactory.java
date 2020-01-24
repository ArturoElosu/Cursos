package ar.com.educacionit.programa.source;

import ar.com.educacionit.programa.modelo.Auto;

public interface AutoFactory {
    
    public Auto build(String data);
}
