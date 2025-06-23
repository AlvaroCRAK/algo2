package algo2.semana12.gui.teoria.componentes.tables.alumno;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

//import net.miginfocom.swing.MigLayout;

public class AlumnoTableDemo {
	Modo modo;
	List<Alumno> data;
	Alumno alumno;
	private JFrame f = new JFrame("Alumno Table Demo");
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
	
	AlumnoTableDemo(){
		data = obtenerData();
		f.setBounds(50, 50, 600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		agregarComponentes(f);
		f.setVisible(true);
	}
	private List<Alumno> obtenerData() {
		List<Alumno> data = new ArrayList<>();
		data.add(new Alumno("12345678", "Perez", "Juan",  5));
		data.add(new Alumno("22345678", "Diaz", "Luis", 15));
		data.add(new Alumno("32345678", "Garcia", "Carlos", 15));
		data.add(new Alumno("42345678", "Rodriguez", "Julio", 8));
		return data;
	}
	private void agregarComponentes(JFrame f) {
	    f.getContentPane().setLayout(new java.awt.GridBagLayout());
	    java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
	    gbc.insets = new java.awt.Insets(5, 5, 5, 5);
	    gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

	    lblCodigo = new JLabel("Codigo:");
	    lblCodigo.setDisplayedMnemonic(KeyEvent.VK_C);
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weightx = 0;
	    f.getContentPane().add(lblCodigo, gbc);

	    txtCodigo = new JTextField();
	    lblCodigo.setLabelFor(txtCodigo);
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.weightx = 1.0;
	    f.getContentPane().add(txtCodigo, gbc);

	    txtSalidas = new JTextArea(10, 20);
	    JScrollPane sp = new JScrollPane(txtSalidas);
	    gbc.gridx = 2;
	    gbc.gridy = 0;
	    gbc.gridheight = 7;
	    gbc.weightx = 1.0;
	    gbc.weighty = 1.0;
	    gbc.fill = java.awt.GridBagConstraints.BOTH;
	    f.getContentPane().add(sp, gbc);

	    gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
	    gbc.gridheight = 1;
	    gbc.weighty = 0;

	    lblApellido = new JLabel("Apellido:");
	    lblApellido.setDisplayedMnemonic(KeyEvent.VK_A);
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.weightx = 0;
	    f.getContentPane().add(lblApellido, gbc);

	    txtApellido = new JTextField();
	    lblApellido.setLabelFor(txtApellido);
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gbc.weightx = 1.0;
	    f.getContentPane().add(txtApellido, gbc);

	    lblNombre = new JLabel("Nombre:");
	    lblNombre.setDisplayedMnemonic(KeyEvent.VK_N);
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.weightx = 0;
	    f.getContentPane().add(lblNombre, gbc);

	    txtNombre = new JTextField();
	    lblNombre.setLabelFor(txtNombre);
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    gbc.weightx = 1.0;
	    f.getContentPane().add(txtNombre, gbc);

	    lblPromedio = new JLabel("Promedio:");
	    lblPromedio.setDisplayedMnemonic(KeyEvent.VK_P);
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    gbc.weightx = 0;
	    f.getContentPane().add(lblPromedio, gbc);

	    txtPromedio = new JTextField();
	    lblPromedio.setLabelFor(txtPromedio);
	    gbc.gridx = 1;
	    gbc.gridy = 6;
	    gbc.weightx = 1.0;
	    f.getContentPane().add(txtPromedio, gbc);

	    pnlBotones = new JPanel(new FlowLayout());
	    btnNuevo = new JButton("Nuevo");
	    pnlBotones.add(btnNuevo);
	    btnEliminar = new JButton("Eliminar");
	    pnlBotones.add(btnEliminar);
	    btnGuardar = new JButton("Guardar");
	    pnlBotones.add(btnGuardar);

	    gbc.gridx = 0;
	    gbc.gridy = 8;
	    gbc.gridwidth = 3;
	    gbc.weightx = 0;
	    gbc.fill = java.awt.GridBagConstraints.NONE;
	    f.getContentPane().add(pnlBotones, gbc);

	    agregarTable(f);
	}

	private void log(String mensaje) {
		txtSalidas.append(mensaje+System.lineSeparator());
	}
	
	private void agregarTable(JFrame f){
		AlumnoTableModel model = new AlumnoTableModel(data);
		tblAlumnos = new JTable(model);
		tblAlumnos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int findex = e.getFirstIndex();
				int lindex = e.getLastIndex();
				int index;
				ListSelectionModel model = (ListSelectionModel)e.getSource();
				if (model.isSelectedIndex(findex))
					index = findex;
				else 
					index = lindex;
				alumno = data.get(index);
				txtCodigo.setText(alumno.getCodigo());
				txtApellido.setText(alumno.getApellido());
				txtNombre.setText(alumno.getNombre());
				txtPromedio.setText(String.valueOf(alumno.getPromedio()));
				modo = Modo.Editar;
			}
		});
		JScrollPane scrollPane = new JScrollPane(tblAlumnos);
		tblAlumnos.setFillsViewportHeight(true);
		f.getContentPane().add(scrollPane, "cell 0 10 3 1,grow");
	}

	public static void main(String[] args) {
		new AlumnoTableDemo();
	}
}
