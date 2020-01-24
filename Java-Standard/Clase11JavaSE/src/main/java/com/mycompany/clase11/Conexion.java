package com.mycompany.clase11;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase11", "root", "");
            
            DatabaseMetaData metaData = conn.getMetaData();
            
            Statement statement = conn.createStatement();
            
            Scanner s  = new Scanner(System.in);
            
            System.out.println("Ingrese su nombre");
            
            String nombre = s.nextLine();
            
            String query = "INSERT INTO alumnos (nombre) VALUES ('%NOMBRE%')";
            
            query = query.replace("%NOMBRE%", nombre);
            
            statement.execute(query);
            
            System.out.println(query);
            
            System.out.println("A quien quiere buscar");
            
            String busqueda = s.nextLine();
            
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM alumnos WHERE nombre = ?");
            
            prepareStatement.setString(1, busqueda);
            
            ResultSet rs = prepareStatement.executeQuery();
            
            while(rs.next()) {
                String alumnoNombre = rs.getString(2);
                System.out.println(alumnoNombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
