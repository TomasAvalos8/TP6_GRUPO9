package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import java.util.List;
import java.awt.BorderLayout;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnPersonas;
	private JMenuItem menuAgregar;
	private JMenuItem menuModificar;
	private JMenuItem menuEliminar;
	private JMenuItem menuListar;
	private JPanel contentPane;
	private VentanaEliminar ventanaEliminar;
	
	private JTable tablaPersonas;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Dni","Nombre y apellido"};
	private static DefaultListModel<Persona> dlModel;
	
	public VentanaPrincipal() {
		modelPersonas = new DefaultTableModel(nombreColumnas, 0) {
			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tablaPersonas = new JTable(modelPersonas);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        
        JPanel panelInicio = new JPanel();
        panelInicio.setLayout(new BorderLayout());
        contentPane.add(panelInicio, BorderLayout.CENTER);
        setContentPane(contentPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 378);
		
		menuBar= new JMenuBar();
		setJMenuBar(menuBar);
		mnPersonas= new JMenu("Persona");
		menuBar.add(mnPersonas);
		
		menuAgregar = new JMenuItem("Agregar");
		mnPersonas.add(menuAgregar);
		menuModificar = new JMenuItem("Modificar");
		mnPersonas.add(menuModificar);
		menuEliminar = new JMenuItem("Eliminar");
		mnPersonas.add(menuEliminar);
		menuListar = new JMenuItem("Listar");
		mnPersonas.add(menuListar);
		

		dlModel = new DefaultListModel<>();
	}

	public void mostrarVentanaAgregar() {
		contentPane.removeAll();
		VentanaAgregar panel = new VentanaAgregar();
		panel.setDefaultListModel(dlModel);
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
	}
	
    public void mostrarVentanaEliminar() {
        contentPane.removeAll();
        this.ventanaEliminar = new VentanaEliminar();
        contentPane.add(ventanaEliminar, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
    }
    
	public void llenarTabla(List<Persona> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : personasEnTabla)
		{
			String dni = p.getDni();
			String nombre = p.getNombre() + " " + p.getApellido();
			Object[] fila = {dni, nombre};
			this.getModelPersonas().addRow(fila);
		}
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
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

	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}	
	
    public VentanaEliminar getVentanaEliminar() {
        return ventanaEliminar;
    }
}