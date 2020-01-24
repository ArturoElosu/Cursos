package com.educaionit.clase2.presentacion;
import com.educaionit.clase2.modelo.Usuario;
import java.util.Scanner;
public class Presentador {
        
        public Usuario leerDatos() {
            System.out.println("Por favor ingrese sus nombre: ");
            Scanner s = new Scanner(System.in);
            String nombre = s.nextLine();
            
            System.out.println("Por favor ingrese un numero: ");
            int numero1 = s.nextInt();
            
            System.out.println("Por favor ingrese un numero: ");
            int numero2 = s.nextInt();
            
            Usuario u = new Usuario();
            
            u.setNombre(nombre);
            u.setNumero1(numero1);
            u.setNumero2(numero2);
            
            return u;
        }
    
    
}
