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
import java.awt.GridLayout;


public class CalculadoraGrid extends JFrame{
	public CalculadoraGrid(){
		setTitle("Calculadora null Layout");
		setBounds(50, 50, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		agregarComponentes();
		setVisible(true);
	}
	
	void agregarComponentes() {
		getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		getContentPane().add(num1Label());
		getContentPane().add(num1Text());
		

		getContentPane().add(resultText());
		
		getContentPane().add(num2Label());
		getContentPane().add(num2Text());
		{
			JLabel label = new JLabel("");
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("");
			getContentPane().add(label);
		}
		getContentPane().add(operaList());
		{
			JLabel label = new JLabel("");
			getContentPane().add(label);
		}
		{
			JLabel label = new JLabel("");
			getContentPane().add(label);
		}
		getContentPane().add(chbxResultadoAlNum1());
		{
			JLabel label = new JLabel("");
			getContentPane().add(label);
		}
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
		new CalculadoraGrid();
	}
}
