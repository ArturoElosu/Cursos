package com.mycompany.clase11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfesorDAO implements DAO<Profesor> {

    @Override
    public List<Profesor> findAll() {
        List<Profesor> profesores = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

            
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM profesores");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Profesor profesor = new Profesor();
                int id = rs.getInt("id_profesor");
                String nombre = rs.getString("nombre");
                double salario = rs.getDouble("salario");
                
                profesor.setId(id);
                profesor.setNombre(nombre);
                profesor.setSalario(salario);
                
                profesores.add(profesor);
            }
            
            return profesores;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profesores;
    }

    @Override
    public Profesor save(Profesor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
