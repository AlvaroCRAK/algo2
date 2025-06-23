package algo2.semana12.gui.ejercicios.calculadora;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;


public class CalculadoraAbs extends JFrame{
	JLabel lblNum1;
	JTextField txtNum1;
	JTextArea taResultado;
	JLabel lblNum2;
	JTextField txtNum2;
	JList<String> lstOperador;
	JCheckBox chckbxResultadoComoNumero;
	
	public CalculadoraAbs(){
		setTitle("Calculadora null Layout");
		setBounds(50, 50, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		agregarComponentes();
		setVisible(true);
	}
	
	void agregarComponentes() {
		
		lblNum1 = new JLabel("Numero 1:");
		add(lblNum1);

		txtNum1 = new JTextField();
		//add(txtNum1);
		
		taResultado = new JTextArea();
		JScrollPane p = new JScrollPane(taResultado);
		//add(p);
		
		lblNum2 = new JLabel("Numero 2:");
		//add(lblNum2);

		txtNum2 = new JTextField();
		//add(txtNum2);
		
		lstOperador = createOperaList();
		//add(operador);
		
		chckbxResultadoComoNumero = new JCheckBox("Resultado como numero 1");
		//add(chckbxResultadoComoNumero);
	}

	private JList<String> createOperaList() {
		//JList<String> c = new JList<>(new String[] { "+", "-", "*", "/"});
		DefaultListModel<String> data = new DefaultListModel<>();
		data.addElement("+");
		data.addElement("-");
		data.addElement("*");
		data.addElement("/");
		JList<String> c = new JList<>(data);
		return c;
	}
	
	public static void main(String[] args) {
		new CalculadoraAbs();
	}
}
