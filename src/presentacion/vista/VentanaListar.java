package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

public class VentanaListar extends JPanel {

	private static final long serialVersionUID = 1L;
    private JTable tablaPersonas;
    private DefaultTableModel modeloTabla;
	public VentanaListar() {
		setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
        JLabel lblTitulo = new JLabel("Listado de Personas");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);
        
        modeloTabla = new DefaultTableModel(
                new Object[]{"DNI", "Nombre", "Apellido"}, 0) {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            

            tablaPersonas = new JTable(modeloTabla);
            

            tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(100); 
            tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(150); 
            tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(150); 
            

            JScrollPane scrollPane = new JScrollPane(tablaPersonas);
            add(scrollPane, BorderLayout.CENTER);
		
	}
    public void llenarTabla(List<Persona> personas) {
        modeloTabla.setRowCount(0);
        
        for (Persona p : personas) {
            Object[] fila = {
                p.getDni(),
                p.getNombre(),
                p.getApellido()
            };
            modeloTabla.addRow(fila);
        }
    }
    
    public JTable getTablaPersonas() {
        return tablaPersonas;
    }

}