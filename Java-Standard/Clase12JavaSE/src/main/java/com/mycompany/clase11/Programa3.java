package com.mycompany.clase11;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Programa3 {
    public static void main(String[] args) {
        DAO<Alumno> dao = new AlumnoDAO();
        
        Alumno a = new Alumno();
        
        Random r = new Random();
        a.setNombre("Cosme-" + r.nextInt(98128978));
        
        dao.save(a);
        
    }
}
