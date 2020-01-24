package clase9;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
    public static int calculoComplejo(int n1, int n2){               
        try {
            return analizarDividendo(n1)/analizarDivisor(n2);
        } catch (Exception e) {
            System.out.println("Hubo un error: " + e.getMessage());
        
            throw new BusinessException(e);        
        }            
    }
    
    public static int analizarDividendo(int n) {
        if (n > 2000) {
            throw new DividendoException();
        }
        return n;
    }
    
    public static int analizarDivisor(int n) throws DivisorException {
        if (n==0){
            throw new DivisorException();
        }
        return n;
    }
}
