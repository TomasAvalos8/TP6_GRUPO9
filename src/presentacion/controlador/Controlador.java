package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.PersonaNegocio;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener{

	private VentanaPrincipal ventanaPrincipal;
	private PersonaNegocio pNeg;
	
	public Controlador(VentanaPrincipal vista,PersonaNegocio pNeg) {
		this.ventanaPrincipal=vista;
		this.pNeg=pNeg;
		
	}
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
