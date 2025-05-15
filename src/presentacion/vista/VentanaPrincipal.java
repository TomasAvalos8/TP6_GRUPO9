package presentacion.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnPersonas;
	private JMenuItem menuAgregar;
	private JMenuItem menuModificar;
	private JMenuItem menuEliminar;
	private JMenuItem menuListar;

	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar= new JMenuBar();
		setJMenuBar(menuBar);
		mnPersonas= new JMenu("Persona");
		menuBar.add(mnPersonas);
		menuAgregar= new JMenuItem("Agregar");
		mnPersonas.add(menuAgregar);
		menuModificar= new JMenuItem("Modificar");
		mnPersonas.add(menuModificar);
		menuEliminar= new JMenuItem("Eliminar");
		mnPersonas.add(menuEliminar);
		menuListar= new JMenuItem("Listar");
		mnPersonas.add(menuListar);
		
	}



	public JMenu getMnPersonas() {
		return mnPersonas;
	}


	public void setMnPersonas(JMenu mnPersonas) {
		this.mnPersonas = mnPersonas;
	}


	public JMenuItem getMenuAgregar() {
		return menuAgregar;
	}


	public void setMenuAgregar(JMenuItem menuAgregar) {
		this.menuAgregar = menuAgregar;
	}


	public JMenuItem getMenuModificar() {
		return menuModificar;
	}


	public void setMenuModificar(JMenuItem menuModificar) {
		this.menuModificar = menuModificar;
	}


	public JMenuItem getMenuEliminar() {
		return menuEliminar;
	}


	public void setMenuEliminar(JMenuItem menuEliminar) {
		this.menuEliminar = menuEliminar;
	}


	public JMenuItem getMenuListar() {
		return menuListar;
	}


	public void setMenuListar(JMenuItem menuListar) {
		this.menuListar = menuListar;
	}

}
