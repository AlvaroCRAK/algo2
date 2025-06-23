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

import net.miginfocom.swing.MigLayout;

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
		btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modo = Modo.Nuevo;
				txtCodigo.setText("");
				txtApellido.setText("");
				txtNombre.setText("");
				txtPromedio.setText("");
			}
		});
		pnlBotones.add(btnNuevo);
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if ( modo == Modo.Editar) {
					int index = data.indexOf(alumno);
					data.remove(alumno);
					AbstractTableModel model = (AbstractTableModel)tblAlumnos.getModel();
					//ListSelectionModel sModel = tblAlumnos.getSelectionModel();
					model.fireTableRowsDeleted(index, index);
				} 
			}
		});
		pnlBotones.add(btnEliminar);
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if ( modo == Modo.Editar) {
					alumno.setApellido(txtApellido.getText());
					alumno.setNombre(txtNombre.getText());
					alumno.setPromedio(Float.parseFloat(txtPromedio.getText()));
					AbstractTableModel model = (AbstractTableModel)tblAlumnos.getModel();
					//ListSelectionModel sModel = tblAlumnos.getSelectionModel();
					model.fireTableRowsUpdated(data.indexOf(alumno), data.indexOf(alumno));
				} else if ( modo == Modo.Nuevo) {
					alumno = new Alumno(
							txtCodigo.getText(),
							txtApellido.getText(),
							txtNombre.getText(),
							Float.parseFloat(txtPromedio.getText())
							);
					data.add(alumno);
					AbstractTableModel model = (AbstractTableModel)tblAlumnos.getModel();
					model.fireTableRowsInserted(data.indexOf(alumno), data.indexOf(alumno));
				}
			}
		});
		
		pnlBotones.add(btnGuardar);
		
		f.getContentPane().add(pnlBotones, "cell 0 8 3 1,grow");

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
