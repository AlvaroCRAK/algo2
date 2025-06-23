package algo2.semana12.gui.teoria.framedialog;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameDemo5Dialogo {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDemo5Dialogo window = new FrameDemo5Dialogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameDemo5Dialogo() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnarchivo = new JMenu("Archivo");
		menuBar.add(mnarchivo);

		JMenuItem mntmItem_1 = new JMenuItem("item1");
		mntmItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción para item1
			}
		});
		mnarchivo.add(mntmItem_1);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog ayuda = new JDialog(frame, "FrameDemo5", true);
				Container contentPane = new JPanel();
				contentPane.add(new JLabel("FrameDemo 5 version 1.0"));
				JButton aceptar = new JButton("Aceptar");
				aceptar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ayuda.dispose();
					}
				});
				contentPane.add(aceptar);
				ayuda.setContentPane(contentPane);
				ayuda.setSize(200, 100);
				ayuda.setLocationRelativeTo(frame);
				ayuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);

		// Crear los JTextFields
		textField = new JTextField();
		textField_1 = new JTextField();
		textField_2 = new JTextField();
		textField_3 = new JTextField();
		textField_3.setColumns(10);

		// Configurar layout GridBagLayout
		frame.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(5, 5, 5, 5); // margen entre componentes
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;

		// Primera fila, primer campo
		gbc.gridx = 0;
		gbc.gridy = 0;
		frame.getContentPane().add(textField, gbc);

		// Primera fila, segundo campo
		gbc.gridx = 1;
		gbc.gridy = 0;
		frame.getContentPane().add(textField_2, gbc);

		// Segunda fila, primer campo
		gbc.gridx = 0;
		gbc.gridy = 1;
		frame.getContentPane().add(textField_1, gbc);

		// Segunda fila, segundo campo
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0;  // para que el tamaño sea preferido, no se expanda
		frame.getContentPane().add(textField_3, gbc);

		// Tercera fila, campo que ocupa 3 columnas
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.weightx = 1.0;
		JTextField textFieldExtra = new JTextField();
		frame.getContentPane().add(textFieldExtra, gbc);
	}

}
