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

public class CalculadoraMig extends JFrame {

    private JTextField num1Text;
    private JTextField num2Text;
    private JTextArea resultText;
    private JList<String> operaList;
    private JCheckBox chbxResultadoAlNum1;

    public CalculadoraMig() {
        setTitle("Calculadora GridBagLayout");
        setBounds(50, 50, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agregarComponentes();
        setVisible(true);
    }

    void agregarComponentes() {
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // margen entre componentes

        // Label Numero 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(num1Label(), gbc);

        // TextField Numero 1
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        num1Text = new JTextField();
        getContentPane().add(num1Text, gbc);

        // Label Numero 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(num2Label(), gbc);

        // TextField Numero 2
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        num2Text = new JTextField();
        getContentPane().add(num2Text, gbc);

        // Lista de operaciones
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = 2;
        DefaultListModel<String> data = new DefaultListModel<>();
        data.addElement("+");
        data.addElement("-");
        data.addElement("*");
        data.addElement("/");
        operaList = new JList<>(data);
        JScrollPane scroll = new JScrollPane(operaList);
        getContentPane().add(scroll, gbc);

        // Área de resultado (TextArea con scroll)
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        resultText = new JTextArea();
        JScrollPane scrollResult = new JScrollPane(resultText);
        getContentPane().add(scrollResult, gbc);

        // Checkbox Resultado como numero 1
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        chbxResultadoAlNum1 = new JCheckBox("Resultado como numero 1");
        getContentPane().add(chbxResultadoAlNum1, gbc);
    }

    protected Component num1Label() {
        return new JLabel("Numero 1:");
    }

    private Component num2Label() {
        return new JLabel("Numero 2:");
    }

    public static void main(String[] args) {
        new CalculadoraMig();
    }
}
