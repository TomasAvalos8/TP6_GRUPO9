package negocio;

import java.util.List;

import entidad.Persona;

public interface PersonaNegocio {
	
	public boolean insert(Persona persona);
	public boolean delete(Persona personaEliminar);
	public boolean modificar(Persona personaModificar);
	public List<Persona> readAll();
	
}
