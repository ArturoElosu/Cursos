package com.mycompany.clase11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoDAO implements DAO<Alumno> {

    @Override
    public List<Alumno> findAll() {
        List<Alumno> alumnos = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM alumnos");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                int id = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre");

                alumno.setId(id);
                alumno.setNombre(nombre);

                alumnos.add(alumno);
            }

            return alumnos;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }

    @Override
    public Alumno save(Alumno entity) {
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO alumnos (nombre) VALUES (?)");
            ps.setString(1, entity.getNombre());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }

}
