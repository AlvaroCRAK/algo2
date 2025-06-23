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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;


public class CalculadoraForm extends JFrame{
	public CalculadoraForm(){
		setTitle("Calculadora null Layout");
		setBounds(50, 50, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		agregarComponentes();
		setVisible(true);
	}
	
	void agregarComponentes() {
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("50px"),
				ColumnSpec.decode("80px"),
				ColumnSpec.decode("100px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("150px"),},
			new RowSpec[] {
				RowSpec.decode("50px"),
				RowSpec.decode("20px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("100px"),
				RowSpec.decode("50px"),
				RowSpec.decode("23px"),}));
		getContentPane().add(num1Label(), "2, 2, fill, fill");
		getContentPane().add(num1Text(), "3, 2, fill, fill");
		getContentPane().add(resultText(), "5, 2, 1, 5, fill, fill");
		
		getContentPane().add(num2Label(), "2, 4, fill, fill");
		getContentPane().add(num2Text(), "3, 4, fill, fill");

		getContentPane().add(operaList(), "3, 6, fill, fill");
		getContentPane().add(chbxResultadoAlNum1(), "3, 8, 3, 1, left, top");
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
		new CalculadoraForm();
	}
}
