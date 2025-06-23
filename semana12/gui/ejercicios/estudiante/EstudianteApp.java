package algo2.semana12.gui.ejercicios.estudiante;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import net.miginfocom.swing.MigLayout;

public class EstudianteApp {
	Object[][] data;
	Object[] colNames = {"Codigo", "Apellido", "Nombre", "Promedio"};
	//Alumno alumno;
	private JFrame f = new JFrame("Mantenimiento de Alumnos");
	JLabel lblCodigo;
	JTextField txtCodigo;
	JTextArea txtSalidas;	
	JLabel lblApellido;
	JTextField txtApellido;
	JLabel lblNombre;
	JTextField txtNombre;
	JLabel lblPromedio;
	JTextField txtPromedio;
	JPanel pnlBotones;
	JButton btnNuevo;
	JButton btnEliminar;
	JButton btnGuardar;
	
	JTable tblAlumnos;
	
	EstudianteApp(){
		data = obtenerData();
		f.setBounds(50, 50, 600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		agregarComponentes(f);
		f.setVisible(true);
	}
	private Object[][] obtenerData() {
		return new Object[][]{
			{"12345678", "Perez", "Juan",  5},
			{"22345678", "Diaz", "Luis", 15},
			{"32345678", "Garcia", "Carlos", 15},
			{"42345678", "Rodriguez", "Julio", 8}
		};
	}
	private void agregarComponentes(JFrame f){
		f.getContentPane().setLayout(new MigLayout("", "[49px][250px,grow][250px]", 
				"[30px][10px][30px][10px][30px][10px][30px][10px][30px][10px][grow]"));
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setDisplayedMnemonic(KeyEvent.VK_C);
		f.getContentPane().add(lblCodigo, "cell 0 0,alignx left,aligny center");
		
		txtCodigo = new JTextField();
		
		lblCodigo.setLabelFor(txtCodigo);
		f.getContentPane().add(txtCodigo, "cell 1 0,grow");
		
		txtSalidas = new JTextArea(10, 20);
		JScrollPane sp = new JScrollPane(txtSalidas);
		f.getContentPane().add(sp, "cell 2 0 1 7,grow");
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setDisplayedMnemonic(KeyEvent.VK_A);
		f.getContentPane().add(lblApellido, "cell 0 2,grow");
		
		txtApellido = new JTextField();
		lblApellido.setLabelFor(txtApellido);
		f.getContentPane().add(txtApellido, "cell 1 2,grow");

		lblNombre= new JLabel("Nombre:");
		lblNombre.setDisplayedMnemonic(KeyEvent.VK_N);
		f.getContentPane().add(lblNombre, "cell 0 4,grow");
		
		txtNombre = new JTextField();
		lblNombre.setLabelFor(txtNombre);
		f.getContentPane().add(txtNombre, "cell 1 4,grow");

		lblPromedio = new JLabel("Promedio:");
		lblPromedio.setDisplayedMnemonic(KeyEvent.VK_P);
		f.getContentPane().add(lblPromedio, "cell 0 6,grow");
		
		txtPromedio = new JTextField();
		lblPromedio.setLabelFor(txtPromedio);
		f.getContentPane().add(txtPromedio, "cell 1 6,grow");
		
		pnlBotones = new JPanel(new FlowLayout());
		btnNuevo = new JButton("Nuevo");
		pnlBotones.add(btnNuevo);
		btnEliminar = new JButton("Eliminar");
		pnlBotones.add(btnEliminar);
		btnGuardar = new JButton("Guardar");
		pnlBotones.add(btnGuardar);
		
		//Aqui va la linea de codigo que hace que aparezca el panel con los botones.

		agregarTable(f);
	}
	private void log(String mensaje) {
		txtSalidas.append(mensaje+System.lineSeparator());
	}
	
	private void agregarTable(JFrame f){
		tblAlumnos = new JTable(data, colNames);
		tblAlumnos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				JOptionPane.showMessageDialog(null, "Por hacer");
			}
		});
		JScrollPane scrollPane = new JScrollPane(tblAlumnos);
		tblAlumnos.setFillsViewportHeight(true);
		f.getContentPane().add(scrollPane, "cell 0 10 3 1,grow");
	}

	public static void main(String[] args) {
		new EstudianteApp();
	}
}
