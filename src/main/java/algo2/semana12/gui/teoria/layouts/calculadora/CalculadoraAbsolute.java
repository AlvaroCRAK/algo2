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


public class CalculadoraAbsolute extends JFrame{
	public CalculadoraAbsolute(){
		setTitle("Calculadora null Layout");
		setBounds(50, 50, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		agregarComponentes();
		setVisible(true);
	}
	
	void agregarComponentes() {
		getContentPane().setLayout(null);
		getContentPane().add(num1Label());
		getContentPane().add(num1Text());
		getContentPane().add(resultText());
		
		getContentPane().add(num2Label());
		getContentPane().add(num2Text());

		getContentPane().add(operaList());
		getContentPane().add(chbxResultadoAlNum1());
	}

	protected Component num1Label() {
		JLabel c = new JLabel("Numero 1:");
		c.setBounds(50, 50, 80, 20);
		return c;
	}

	private Component num1Text() {
		JTextField c = new JTextField();
		c.setBounds(130, 50, 100, 20);
		return c;
	}

	private Component resultText() {
		JTextArea c = new JTextArea();
		JScrollPane p = new JScrollPane(c);
		p.setBounds(240, 50, 150, 160);
		return p;
	}

	private Component num2Label() {
		JLabel c = new JLabel("Numero 2:");
		c.setBounds(50, 80, 80, 20);
		return c;
	}
	private Component num2Text() {
		JTextField c = new JTextField();
		c.setBounds(130, 80, 100, 20);
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
		c.setBounds(130, 110, 100, 100);
		return c;
	}
	
	private JCheckBox chbxResultadoAlNum1() {
		JCheckBox chckbxResultadoComoNumero = new JCheckBox("Resultado como numero 1");
		chckbxResultadoComoNumero.setBounds(130, 260, 211, 23);
		return chckbxResultadoComoNumero;
	}

	public static void main(String[] args) {
		new CalculadoraAbsolute();
	}
}
