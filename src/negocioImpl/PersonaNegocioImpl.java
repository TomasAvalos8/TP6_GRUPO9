package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {
	
	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		if (persona.getNombre().trim().length() > 0 && persona.getApellido().trim().length() > 0) {
	        if (!pdao.verificarDni(persona.getDni())) {
	            estado = pdao.insert(persona);
	        } else {
	            System.out.println("El DNI ya existe.");
	        }
	    }
		return estado;
	}

}
