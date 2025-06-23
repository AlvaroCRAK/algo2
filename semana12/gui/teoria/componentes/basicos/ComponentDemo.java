package algo2.semana12.gui.teoria.componentes.basicos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ComponentDemo {
	private JFrame f = new JFrame("Demo");
	JTextField txtSalida;
	JTextArea txtSalidas;
	
	ComponentDemo(){
		f.setBounds(50, 50, 600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		agregarComponentes(f);
		f.setVisible(true);
	}
	private void agregarComponentes(JFrame f){
		f.setLayout(new FlowLayout());
		
		JLabel lblSalida = new JLabel("Output");
		lblSalida.setDisplayedMnemonic(KeyEvent.VK_O);
		f.add(lblSalida);
		
		txtSalida = new JTextField(20);
		txtSalida.setToolTipText("Muestra el ultimo evento");
		lblSalida.setLabelFor(txtSalida);
		f.add(txtSalida);
		
		txtSalidas = new JTextArea(10, 20);
		JScrollPane sp = new JScrollPane(txtSalidas);
		f.add(sp);
		
		agregarRadioButtons(f);
		agregarComboBox(f);
		agregarList(f);
		agregarTable(f);
		agregarMenu(f);
		
	}
	private void agregarMenu(JFrame f) {
		JMenuBar menubar = new JMenuBar();
		f.setJMenuBar(menubar);
		menubar.add(createFileMenu());
	}
	
	private JMenu createFileMenu() {
		JMenu menu = new JMenu("Archivo");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.add(createAbrirMenuItem());
		menu.add(createGuardarMenuItem());
		return menu;
	}
	
	private JMenuItem createGuardarMenuItem() {
		JMenuItem item = new JMenuItem("Guardar");
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int opc = fc.showSaveDialog(ComponentDemo.this.f);
				if (opc == JFileChooser.APPROVE_OPTION) {
					log (
							"Guardando archivo:" + fc.getSelectedFile().getName() + 
							" en directorio: " + fc.getCurrentDirectory()
						);
				}
			}
		});
		return item;
	}
	private JMenuItem createAbrirMenuItem() {
		JMenuItem item = new JMenuItem("Abrir");
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int opc = fc.showOpenDialog(ComponentDemo.this.f);
				if (opc == JFileChooser.APPROVE_OPTION) {
					log (
							"Abriendo archivo:" + fc.getSelectedFile().getName() + 
							" en directorio: " + fc.getCurrentDirectory()
						);
				}
			}
		});
		return item;
	}
	private void log(String mensaje) {
		txtSalida.setText(mensaje);
		txtSalidas.append(mensaje+System.lineSeparator());
	}
	
	private void agregarRadioButtons(JFrame f){
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Nivel"));
		
		ButtonGroup bg = new ButtonGroup();
		 
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				log(((JRadioButton)e.getSource()).getText());
			}
		};
		
		String[] botones = {"Inicial", "Medio", "Avanzado"};
		boolean[] estado = {true, false, false};

		for (int i=0; i< botones.length;i++) {
			JRadioButton rb = new JRadioButton(botones[i], estado[i]);
			rb.addActionListener(al);
			bg.add(rb);
			panel.add(rb);
		}
		//JRadioButton rbInicio = new JRadioButton("Inicial", true);
		f.add(panel);
	}
	
	private void agregarComboBox(JFrame f){
		String[] lista = {"Java", "Kotlin", "Rust"};
		JComboBox<String> combo = new JComboBox<>(lista);
		combo.addItem("Go");
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				log("Indice:" + 
						((JComboBox<String>)e.getSource()).getSelectedIndex() +
						" Item:" + 
						((JComboBox<String>)e.getSource()).getSelectedItem()
						);
			}
		});

		f.add(combo);
	}

	private void agregarList(JFrame f){
		
		DefaultListModel<String> data = new DefaultListModel<>();
		//String[] data = {"Java", "Kotlin", "Rust", "Go"};
		JList<String> list = new JList<>(data);
		data.addElement("Java");
		data.addElement("Kotlin");
		data.addElement("Rust");
		data.addElement("Go");
		//data2.removeElement("Rust");
		
		list.setBorder(BorderFactory.createMatteBorder(
				1, 1, 2, 2, Color.BLACK));
		list.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				log("keyPressed: " + e.getKeyCode());
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					log("**eliminando: " + list.getSelectedValuesList());
					for (String elem : list.getSelectedValuesList()) {
						data.removeElement(elem);	
					}
				}
			}
		});
		list.addListSelectionListener(new ListSelectionListener() {
			private String getStr(int[] data) {
				String result = "";
				for (int d : data) {
					result += d + ",";
				}
				return "(" + result + ")";
				
			}
			@Override
			public void valueChanged(ListSelectionEvent e) {
				log(
						"index: " + getStr(((JList)e.getSource()).getSelectedIndices()) +
						"values:" + ((JList)e.getSource()).getSelectedValuesList()
				);		
			}
		
		});

		f.add(list);
	}
	private void agregarTable(JFrame f){
		String[] colNames = {"Codigo", "Apellido", "Nombre", "Promedio"};
		Object[][] data = {
				 { "12345678", "Perez", "Juan", 5 },
				 { "22345678", "Diaz", "Luis",  15},
				 { "32345678", "Garcia", "Carlos", 12 }
				};
		JTable table = new JTable(data, colNames);
		ListSelectionModel lsm = table.getSelectionModel();
		lsm.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lsm.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String selectedIndexes = "";
				for (int i = e.getFirstIndex(); i <= e.getLastIndex(); i++) {
					if (lsm.isSelectedIndex(i))
					selectedIndexes += " " + i;
				}
				log("Seleccionados:" + selectedIndexes);
			}
		});
		table.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				int row = e.getFirstRow();
				int col = e.getColumn();
				TableModel model = (TableModel)e.getSource();
				Object value = model.getValueAt(row, col);
				
				log(
						String.format("(row, col)=(%d,%d) valor=%s data[%d,%d]=%s",
								row, col, value, row, col, data[row][col]
								)
					);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		f.getContentPane().add(scrollPane);
	}
	
	public static void main(String[] args) {
		new ComponentDemo();
	}
}
