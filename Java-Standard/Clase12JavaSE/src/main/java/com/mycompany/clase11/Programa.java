package com.mycompany.clase11;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Programa {
    public static void main(String[] args) {
        DAO<Alumno> dao1 = new AlumnoDAO();
        DAO<Profesor> dao2 = new ProfesorDAO();
        
        List<Alumno> alumnos = dao1.findAll();
        
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
        
        System.out.println("******************");
        
        List<Profesor> profesores = dao2.findAll();
        
        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
          
    }
}
