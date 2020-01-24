package com.educaionit.clase2.presentacion;
import com.educaionit.clase2.modelo.Usuario;
public class Clase2 {
    public static void main(String[] args) {
        Presentador p = new Presentador();
        
        Usuario usuarioLeido = p.leerDatos();
        
        System.out.println(usuarioLeido.getNombre());
        System.out.println(calcular(usuarioLeido.getNumero1(), usuarioLeido.getNumero2()));
        
        
    }
    
    public static int calcular(int a, int n) {
        return a + (n * 3);     
    }
        
    
}
