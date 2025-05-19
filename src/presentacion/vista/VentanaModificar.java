package presentacion.vista;

import javax.swing.*;
import entidad.Persona;
import java.awt.*;

public class VentanaModificar extends JPanel{
	private static final long serialVersionUID = 1L;

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JButton btnModificar;
	private DefaultListModel<Persona> modeloLista;
	private JList<Persona> listaPersonas;
	public VentanaModificar() {
		setLayout(null);
		
		modeloLista = new DefaultListModel<>();
		listaPersonas = new JList<>(modeloLista);
		listaPersonas.setBounds(20, 20, 327, 207);
		add(listaPersonas);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(24, 250, 101, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(135, 250, 101, 20);
		add(txtApellido);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setEditable(false);
		txtDNI.setBounds(246, 250, 101, 20);
		add(txtDNI);
		
	    btnModificar = new JButton("Modificar");
	    btnModificar.setBounds(357, 249, 89, 23);
	    add(btnModificar);
	}
	public DefaultListModel<Persona> getModeloLista() { return modeloLista; }
	public JList<Persona> getListaPersonas() { return listaPersonas; }
	public JTextField getTxtNombre() { return txtNombre; }
	public JTextField getTxtApellido() { return txtApellido; }
	public JTextField getTxtDni() { return txtDNI; }
	public JButton getBtnModificar() {
	    if (btnModificar == null) {
	        btnModificar = new JButton("Modificar");
	    }
	    return btnModificar;
	}

}
