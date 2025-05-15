package presentacion.vista;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.PersonaDao;
import entidad.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaAgregar extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DefaultListModel<Persona> dlModel;
	
	public VentanaAgregar() {
		PersonaDao usuarioDao = new PersonaDao();
	
		
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(201, 40, 142, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 81, 142, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(201, 124, 142, 20);
		add(textField_2);
		
		Label label = new Label("Nombre");
		label.setBounds(116, 40, 62, 22);
		add(label);
		
		Label label_1 = new Label("DNI");
		label_1.setBounds(116, 124, 62, 22);
		add(label_1);
		
		Label label_1_1 = new Label("Apellido");
		label_1_1.setBounds(116, 81, 62, 22);
		add(label_1_1);
		
		Button button = new Button("Aceptar");
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPersona();
			}
		});
		button.setBounds(171, 181, 102, 22);
		add(button);
	}
	
	public void setDefaultListModel(DefaultListModel<Persona> listModelRecibido)
	{
		this.dlModel = listModelRecibido;
	}
	
	
	public void agregarPersona()
	{
		PersonaDao usuarioDao = new PersonaDao();
		Persona persona = new Persona();
		
		
		
		if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty())
		{
			
			JOptionPane.showMessageDialog(this, "No se pueden dejar campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
			return;
			
		}
		
			persona.setNombre(textField.getText());
			persona.setApellido(textField_1.getText());
			persona.setDni(Integer.parseInt(textField_2.getText()));
			
			
			int filas = usuarioDao.agregarPersona(persona);
			
			if(filas > 0)
			{

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
			
			else
			{
				System.out.println("Error al agregar la persona");
			}
			
		
		
	

		
	}
}
