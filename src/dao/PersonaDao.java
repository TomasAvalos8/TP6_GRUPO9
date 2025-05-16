package dao;
import java.util.List;

import entidad.Persona;

public interface PersonaDao {
	
	public boolean insert(Persona persona);
	boolean existsDni(String dni);
	
}
