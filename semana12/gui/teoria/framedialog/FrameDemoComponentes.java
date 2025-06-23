package algo2.semana12.gui.teoria.framedialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class FrameDemoComponentes {
	private JFrame frame;
	
	FrameDemoComponentes(int x, int y){
		frame = new JFrame();
		frame.setTitle("demo...");
		frame.setLocation(x, y);
		frame.setSize(400, 200);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(crearMenuBar());
		agregarComponente();
		frame.setVisible(true);
	}

	private JMenuBar crearMenuBar() {
		JMenuBar menubar = new JMenuBar();
		menubar.add(createFileMenu());
		menubar.add(createHelpMenu());
		return menubar;
	}
	
	private JMenu createFileMenu() {
		JMenu m = new JMenu("Archivo");
		m.setMnemonic('A');
		m.add(new JMenuItem("Guardar"));
		
		JMenu exportar = new JMenu("Exportar");
		exportar.add(new JMenuItem("pdf"));
		exportar.add("txt");
		m.add(exportar);
		
		m.addSeparator();
		
		JMenuItem salirItem = new JMenuItem("Salir");
		salirItem.setMnemonic('S');
		salirItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		m.add(salirItem);
		return m;
	}
	
	private JMenu createHelpMenu() {
		JMenu m = new JMenu("Ayuda");
		m.setMnemonic('y');
		m.add(new JMenuItem("Contenido"));
		m.add(new JMenuItem("Acercar de..."));
		return m;
	}
	
	private void agregarComponente() {
		frame.setLayout(null);
		JLabel lblNum1 = new JLabel("Numero 1:");
		frame.getContentPane().add(lblNum1);
		lblNum1.setBounds(50, 50, 100, 20);
		
		JTextField txtNum1 = new JTextField();
		frame.add(txtNum1);
		txtNum1.setBounds(150, 50, 100, 20);

		JLabel lblNum2 = new JLabel("Numero 2:");
		frame.add(lblNum2);
		lblNum2.setBounds(50, 80, 100, 20);
		
		JTextField txtNum2 = new JTextField();
		frame.add(txtNum2);
		txtNum2.setBounds(150, 80, 100, 20);
		
		JLabel lblResult = new JLabel("Resultado:");
		frame.add(lblResult);
		lblResult.setBounds(50, 110, 100, 20);
		
		JTextField txtResult = new JTextField();
		frame.add(txtResult);
		txtResult.setBounds(150, 110, 100, 20);
		
		JButton btnCalcular = new JButton("Calcular");
		frame.add(btnCalcular);
		btnCalcular.setBounds(100, 140, 100, 20);

	}
	
	public static void main(String[] args) {
		new FrameDemoComponentes(0, 0);
	}
}
