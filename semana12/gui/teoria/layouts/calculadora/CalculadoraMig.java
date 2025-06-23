package algo2.semana12.gui.teoria.layouts.calculadora;

import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import net.miginfocom.swing.MigLayout;


public class CalculadoraMig extends JFrame{
	public CalculadoraMig(){
		setTitle("Calculadora Mig Layout");
		setBounds(50, 50, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		agregarComponentes();		
	}
	
	void agregarComponentes() {
		getContentPane().setLayout(new MigLayout("", "[80px][100px][10px][150px]", "[20px][10px][20px][10px][100px][30px]"));
		getContentPane().add(num1Label(), "cell 0 0,grow");
		getContentPane().add(num1Text(), "cell 1 0,grow");
		getContentPane().add(resultText(), "cell 3 0 1 5,grow");
		
		getContentPane().add(num2Label(), "cell 0 2,grow");
		getContentPane().add(num2Text(), "cell 1 2,grow");
		
		getContentPane().add(operaList(), "cell 1 4,grow");
		getContentPane().add(chbxResultadoAlNum1(), "cell 1 5 3 1,alignx left,aligny top");
	}

	protected Component num1Label() {
		JLabel c = new JLabel("Numero 1:");
		return c;
	}

	private Component num1Text() {
		JTextField c = new JTextField();
		return c;
	}
	
	private Component resultText() {
		JTextArea c = new JTextArea();
		JScrollPane p = new JScrollPane(c);
		return p;
	}

	private Component num2Label() {
		JLabel c = new JLabel("Numero 2:");
		return c;
	}
	private Component num2Text() {
		JTextField c = new JTextField();
		return c;
	}
	private Component operaList() {
		//JList<String> c = new JList<>(new String[] { "+", "-", "*", "/"});
		DefaultListModel<String> data = new DefaultListModel<>();
		data.addElement("+");
		data.addElement("-");
		data.addElement("*");
		data.addElement("/");
		JList<String> c = new JList<>(data);
		return c;
	}
	private JCheckBox chbxResultadoAlNum1() {
		JCheckBox chckbxResultadoComoNumero = new JCheckBox("Resultado como numero 1");
		return chckbxResultadoComoNumero;
	}


	public static void main(String[] args) {
		new CalculadoraMig();
	}
}
