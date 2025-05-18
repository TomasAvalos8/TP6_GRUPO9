package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.VentanaEliminar;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	private VentanaEliminar ventanaEliminar;
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg) {
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		this.personasEnTabla = new ArrayList<>();
	}
	
	public void borrarPersona(ActionEvent s) {
		boolean estado = false;
		JTable tabla = this.ventanaEliminar.getTable(); 
		int[] filasSeleccionadas = tabla.getSelectedRows();
		
		if (filasSeleccionadas.length == 0) {
			this.ventanaPrincipal.mostrarMensaje("Debe seleccionar al menos una fila para eliminar");
			return;
		}
		
		for (int fila : filasSeleccionadas) {
			if (fila >= 0 && fila < personasEnTabla.size()) {
				estado = pNeg.delete(this.personasEnTabla.get(fila));
				if(estado == true) {
					String mensaje = "Persona eliminada con éxito";
					this.ventanaPrincipal.mostrarMensaje(mensaje);
				} else {
					this.ventanaPrincipal.mostrarMensaje("Error al eliminar la persona");
				}
			}
		}
		
		refrescarTabla();
		this.ventanaEliminar.llenarTabla(personasEnTabla);
	}
	
	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);
		this.ventanaPrincipal.getMenuAgregar().addActionListener(this);
		this.ventanaPrincipal.getMenuEliminar().addActionListener(this);
		
	}
	

    
	private void refrescarTabla() {
		this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		this.ventanaPrincipal.llenarTabla(this.personasEnTabla);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ventanaPrincipal.getMenuAgregar()) {
			ventanaPrincipal.mostrarVentanaAgregar();
		} else if (e.getSource() == ventanaPrincipal.getMenuEliminar()) {
			refrescarTabla();
			
			ventanaPrincipal.mostrarVentanaEliminar();
			
			this.ventanaEliminar = ventanaPrincipal.getVentanaEliminar();
			
			this.ventanaEliminar.llenarTabla(personasEnTabla);
			
			this.ventanaEliminar.getBtnBorrar().removeActionListener(this);
			this.ventanaEliminar.getBtnBorrar().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent evt) {
					borrarPersona(evt);
				}
			});
		}
	}
}