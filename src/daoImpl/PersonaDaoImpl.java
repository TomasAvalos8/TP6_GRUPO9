package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {
	private static final String insert = "INSERT INTO personas (Dni, Nombre, Apellido) VALUES (?, ?, ?)";
	private static final String sqlExistsDni = "SELECT COUNT(*) FROM personas WHERE Dni = ?";
	
	public boolean insert(Persona persona) {
	    PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    boolean isInsertExitoso = false;
	    try {	    	
	        statement = conexion.prepareStatement(insert);
	        statement.setString(1, persona.getDni());
	        statement.setString(2, persona.getNombre());
	        statement.setString(3, persona.getApellido());

	        if (statement.executeUpdate() > 0) {
	            conexion.commit();
	            isInsertExitoso = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            conexion.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }
	    return isInsertExitoso;
	}
	
	public boolean verificarDni(String dni) {
        Connection conexion = Conexion.getConexion().getSQLConexion();
        try (PreparedStatement statement = conexion.prepareStatement(sqlExistsDni)) {
            statement.setString(1, dni);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
}
