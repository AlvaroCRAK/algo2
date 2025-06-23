package algo2.semana12.gui.ejercicios.calculadora;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import net.miginfocom.swing.MigLayout;

import javax.swing.JCheckBox;


public class CalculadoraMig extends JFrame{
	JLabel lblNum1;
	JTextField txtNum1;
	JTextArea taResultado;
	JLabel lblNum2;
	JTextField txtNum2;
	JList<String> lstOperador;
	JCheckBox chckbxResultadoComoNumero;
	JTextArea taLog;
	
	///*
	public CalculadoraMig() {
	    setTitle("Calculadora con MigLayout");
	    setBounds(50, 50, 600, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	 // Ahora tiene 6 filas: [0 a 5]
	    setLayout(new MigLayout(
	        "insets 20, wrap 3",
	        "[right][100][300]",
	        "[]15[]15[80!]15[20!]15[50!]")); // ← nueva fila para el log            // filas con espacios y altura fija para la lista

	    agregarComponentesMig();
	    setVisible(true);
	}

    void agregarComponentesMig() {
        lblNum1 = new JLabel("Numero 1:");
        txtNum1 = new JTextField(10);

        lblNum2 = new JLabel("Numero 2:");
        txtNum2 = new JTextField(10);

        lstOperador = createOperaList();
        JScrollPane scrollOperadores = new JScrollPane(lstOperador);

        taResultado = new JTextArea();
        taResultado.setLineWrap(true);
        taResultado.setWrapStyleWord(true);
        taResultado.setEditable(false);
        JScrollPane scrollResultado = new JScrollPane(taResultado);

        taLog = new JTextArea();
        taLog.setLineWrap(true);
        taLog.setWrapStyleWord(true);
        taLog.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(taLog);

        chckbxResultadoComoNumero = new JCheckBox("Resultado como número 1");

        add(lblNum1, "cell 0 0");
        add(txtNum1, "cell 1 0");
        add(scrollResultado, "cell 2 0 1 3, grow, height 160!");

        add(lblNum2, "cell 0 1");
        add(txtNum2, "cell 1 1");

        add(new JLabel("Operador:"), "cell 0 2");
        add(scrollOperadores, "cell 1 2, growy, height 80!");

        add(chckbxResultadoComoNumero, "cell 0 4 3 1, align center, gaptop 5");

        add(scrollLog, "cell 0 5 3 1, growx, height 50!");
        lstOperador.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    calcularYMostrar();
                }
            }
        });

    }


	//*/

	
    private void calcularYMostrar() {
        try {
            double num1 = Double.parseDouble(txtNum1.getText().trim());
            double num2 = Double.parseDouble(txtNum2.getText().trim());
            String operador = lstOperador.getSelectedValue();

            if (operador == null) {
                taResultado.setText("Seleccione un operador.");
                return;
            }

            double resultado = 0;

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

            String operacion = String.format("%.2f %s %.2f = %.2f", num1, operador, num2, resultado);
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
		new CalculadoraMig();
	}
}
