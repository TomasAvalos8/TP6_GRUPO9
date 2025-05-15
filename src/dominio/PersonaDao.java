package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import entidad.Persona;

public class PersonaDao {
	
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	// Cambia la contraseña por la que tengas configurada en tu base de datos
	private String password = "password";
	private String dbName = "bdPersonas";
	
	public PersonaDao() {
		
	}

	
	public int agregarPersona(Persona persona) {
		String query = "INSERT INTO Personas (nombre, apellido, dni) VALUES ('" + persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getDni() + "')";
		
		Connection connection = null;
		int filas = 0;
		
		try {
			connection = DriverManager.getConnection(host + dbName, user, password);
			Statement statement = connection.createStatement();
			filas = statement.executeUpdate(query);
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return filas;
	}
}
