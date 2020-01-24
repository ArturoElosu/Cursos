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

public class Programa2 {
    public static void main(String[] args) {
        DAO<Alumno> dao = new GenericDAO<>(Alumno.class);
        
        List<Alumno> alumnos = dao.findAll();
        
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }          
    }
}
