package algo2.semana12.gui.ejercicios.calculadora;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


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
    JTextArea taLog;

	
	///*
	public CalculadoraAbs() {
	    setTitle("Calculadora null Layout");
	    setBounds(50, 50, 600, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
	    setLayout(null); // Importante para usar setBounds
	    agregarComponentesNull();
	    setVisible(true);
	}

    void agregarComponentesNull() {
        // Fila 0
        lblNum1 = new JLabel("Numero 1:");
        lblNum1.setBounds(20, 20, 80, 25);
        add(lblNum1);

        txtNum1 = new JTextField();
        txtNum1.setBounds(110, 20, 100, 25);
        add(txtNum1);

        taResultado = new JTextArea();
        taResultado.setLineWrap(true);
        taResultado.setWrapStyleWord(true);
        taResultado.setEditable(false);
        JScrollPane scrollResultado = new JScrollPane(taResultado);
        scrollResultado.setBounds(230, 20, 300, 160); // Ocupa filas 0-2
        add(scrollResultado);

        // Fila 1
        lblNum2 = new JLabel("Numero 2:");
        lblNum2.setBounds(20, 55, 80, 25);
        add(lblNum2);

        txtNum2 = new JTextField();
        txtNum2.setBounds(110, 55, 100, 25);
        add(txtNum2);

        // Fila 2
        JLabel lblOperador = new JLabel("Operador:");
        lblOperador.setBounds(20, 90, 80, 25);
        add(lblOperador);

        lstOperador = createOperaList();
        JScrollPane scrollOperador = new JScrollPane(lstOperador);
        scrollOperador.setBounds(110, 90, 100, 80); // altura = 80!
        add(scrollOperador);

        // Fila 4
        chckbxResultadoComoNumero = new JCheckBox("Resultado como número 1");
        chckbxResultadoComoNumero.setBounds(150, 190, 250, 25); // centrado más o menos
        add(chckbxResultadoComoNumero);

        // Fila 5 (taLog)
        taLog = new JTextArea();
        taLog.setLineWrap(true);
        taLog.setWrapStyleWord(true);
        taLog.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(taLog);
        scrollLog.setBounds(20, 225, 540, 120); // abarca las 3 columnas
        add(scrollLog);
        
        lstOperador.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    calcularYMostrar();
                }
            }
        });
    }
	//*/

	/*
	   public CalculadoraAbs() {
	        setTitle("Calculadora con FlowLayout");
	        setBounds(50, 50, 600, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new FlowLayout());
	        agregarComponentesFlow();
	        setVisible(true);
	    }

	    void agregarComponentesFlow() {
	        lblNum1 = new JLabel("Numero 1:");
	        add(lblNum1);

	        txtNum1 = new JTextField();
	        txtNum1.setPreferredSize(new Dimension(100, 25)); // tamaño razonable
	        add(txtNum1);

	        lblNum2 = new JLabel("Numero 2:");
	        add(lblNum2);

	        txtNum2 = new JTextField();
	        txtNum2.setPreferredSize(new Dimension(100, 25)); // tamaño razonable
	        add(txtNum2);

	        lstOperador = createOperaList();
	        lstOperador.setPreferredSize(new Dimension(50, 80)); // tamaño razonable para la lista
	        add(lstOperador);

	        taResultado = new JTextArea();
	        taResultado.setPreferredSize(new Dimension(400, 150)); // tamaño para el área de texto
	        add(taResultado);

	        chckbxResultadoComoNumero = new JCheckBox("Resultado como numero 1");
	        add(chckbxResultadoComoNumero);
	    }
	    //*/

    private void calcularYMostrar() {
        try {
            double num1 = Double.parseDouble(txtNum1.getText().trim());
            double num2 = Double.parseDouble(txtNum2.getText().trim());
            String operador = lstOperador.getSelectedValue();
            double resultado = 0;
            String operacion = "";

            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        taResultado.setText("Error: división por cero");
                        return;
                    }
                    resultado = num1 / num2;
                    break;
                default:
                    taResultado.setText("Operador inválido");
                    return;
            }

            operacion = String.format("%.2f %s %.2f = %.2f", num1, operador, num2, resultado);
            taResultado.setText(operacion);
            taLog.append(operacion + "\n");

            if (chckbxResultadoComoNumero.isSelected()) {
                txtNum1.setText(String.valueOf(resultado));
            }

        } catch (NumberFormatException ex) {
            taResultado.setText("Error: ingrese números válidos");
        }
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
