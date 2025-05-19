package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;

import entidad.Persona;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.util.List;

public class VentanaEliminar extends JPanel {
    private static final long serialVersionUID = 1L;
    private JList<Persona> listaPersonas;
    private DefaultListModel<Persona> modeloLista;
    private JButton btnBorrar;
    
    public VentanaEliminar() {
        setLayout(null);
        
        
        modeloLista = new DefaultListModel<>();
        
       
        listaPersonas = new JList<>(modeloLista);
        
        
        listaPersonas.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        
        JScrollPane scrollPane = new JScrollPane(listaPersonas);
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
    

    public void llenarLista(List<Persona> personas) {
        modeloLista.clear();
        
        for (Persona p : personas) {
            modeloLista.addElement(p);
        }
    }
    

    public JList<Persona> getListaPersonas() {
        return listaPersonas;
    }
    

    public DefaultListModel<Persona> getModeloLista() {
        return modeloLista;
    }
    

    public JButton getBtnBorrar() {
        return btnBorrar;
    }
}