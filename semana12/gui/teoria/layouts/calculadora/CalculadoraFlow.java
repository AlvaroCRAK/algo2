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
import java.awt.FlowLayout;


public class CalculadoraFlow extends JFrame{
	public CalculadoraFlow(){
		setTitle("Calculadora Flow Layout - Nonsence");
		setBounds(50, 50, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		agregarComponentes();
		setVisible(true);
	}
	
	void agregarComponentes() {
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(num1Label());
		getContentPane().add(num1Text());
		getContentPane().add(resultText());
		JLabel fill = new JLabel("                                                      ");
		getContentPane().add(fill);
		getContentPane().add(num2Label());
		getContentPane().add(num2Text());
		fill = new JLabel("                                                                                     ");
		getContentPane().add(fill);
		getContentPane().add(fill);
		getContentPane().add(operaList());
		getContentPane().add(fill);
		getContentPane().add(fill);
		getContentPane().add(chbxResultadoAlNum1());
	}

	private JCheckBox chbxResultadoAlNum1() {
		JCheckBox chckbxResultadoComoNumero = new JCheckBox("Resultado como numero 1");
		return chckbxResultadoComoNumero;
	}

	protected Component num1Label() {
		JLabel c = new JLabel("Numero 1:");
		return c;
	}

	private Component num1Text() {
		JTextField c = new JTextField();
		c.setColumns(8);
		return c;
	}
	private Component num2Label() {
		JLabel c = new JLabel("Numero 2:");
		return c;
	}
	private Component num2Text() {
		JTextField c = new JTextField();
		c.setColumns(8);
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

	private Component resultText() {
		JTextArea c = new JTextArea();
		c.setRows(10);
		c.setColumns(10);
		JScrollPane p = new JScrollPane(c);
		return p;
	}

	public static void main(String[] args) {
		new CalculadoraFlow();
	}
}
