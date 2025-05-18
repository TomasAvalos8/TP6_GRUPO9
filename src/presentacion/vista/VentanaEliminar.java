package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.util.List;

public class VentanaEliminar extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
    private DefaultTableModel modeloTabla;
    private JButton btnBorrar;
    
    public VentanaEliminar() {
        setLayout(null);
        
  
        modeloTabla = new DefaultTableModel(
            new Object[]{"DNI", "Nombre ", "Apellido"}, 0) {
 
				private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        table = new JTable(modeloTabla);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION); 
        
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(66, 62, 300, 183);
        add(scrollPane);
        
        JLabel lblEliminar = new JLabel("Eliminar Usuario");
        lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblEliminar.setBounds(66, 21, 215, 40);
        add(lblEliminar);
        
        btnBorrar = new JButton("Eliminar");
        btnBorrar.setBounds(88, 247, 262, 39);
        add(btnBorrar);
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
    
    public JTable getTable() {
        return table;
    }
    
    public JButton getBtnBorrar() {
        return btnBorrar;
    }
}