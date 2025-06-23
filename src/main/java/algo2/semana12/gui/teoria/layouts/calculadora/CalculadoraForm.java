package algo2.semana12.gui.teoria.layouts.calculadora;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CalculadoraForm extends JFrame {

    private JTextField num1Text;
    private JTextField num2Text;
    private JTextArea resultText;
    private JList<String> operaList;
    private JCheckBox chbxResultadoAlNum1;

    public CalculadoraForm() {
        setTitle("Calculadora con GridBagLayout");
        setBounds(50, 50, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agregarComponentes();
        setVisible(true);
    }

    void agregarComponentes() {
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Margen general para todos los componentes
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;

        // Label Numero 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        getContentPane().add(new JLabel("Numero 1:"), gbc);

        // TextField Numero 1
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        num1Text = new JTextField();
        getContentPane().add(num1Text, gbc);

        // Label Numero 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        getContentPane().add(new JLabel("Numero 2:"), gbc);

        // TextField Numero 2
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        num2Text = new JTextField();
        getContentPane().add(num2Text, gbc);

        // Lista de operaciones
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        DefaultListModel<String> data = new DefaultListModel<>();
        data.addElement("+");
        data.addElement("-");
        data.addElement("*");
        data.addElement("/");
        operaList = new JList<>(data);
        JScrollPane scrollOperaciones = new JScrollPane(operaList);
        getContentPane().add(scrollOperaciones, gbc);

        // Resultado (JTextArea dentro de JScrollPane)
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        resultText = new JTextArea();
        JScrollPane scrollResultado = new JScrollPane(resultText);
        getContentPane().add(scrollResultado, gbc);

        // Checkbox resultado como numero 1
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        chbxResultadoAlNum1 = new JCheckBox("Resultado como numero 1");
        getContentPane().add(chbxResultadoAlNum1, gbc);
    }

    public static void main(String[] args) {
        new CalculadoraForm();
    }
}
