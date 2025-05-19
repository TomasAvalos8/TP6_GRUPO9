package dao;
import java.util.List;

import entidad.Persona;

public interface PersonaDao {
	
	public boolean insert(Persona persona);
	boolean verificarDni(String dni);
	public boolean delete(Persona personaEliminar);
	public boolean actualizar(Persona personaModificar);
	public List<Persona> readAll();
}
