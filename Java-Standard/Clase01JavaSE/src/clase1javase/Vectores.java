package clase1javase;

import java.util.Arrays;

public class Vectores {
    public static void main(String[] args) {
        int[] numeros = new int[10];
//        boolean[] verdad = new boolean[10];
//        
//        System.out.println(Arrays.toString(numeros));
//        System.out.println(Arrays.toString(verdad));
        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100);
        }
        
        System.out.println(Arrays.toString(numeros));
        
        long sumatoria = 0;
        for (int i = 0; i < numeros.length; i++) {
            sumatoria += numeros[i];
        }
        
        System.out.println("El total es: " + sumatoria);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
