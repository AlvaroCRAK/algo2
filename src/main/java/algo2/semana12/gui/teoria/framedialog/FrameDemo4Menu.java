package algo2.semana12.gui.teoria.framedialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FrameDemo4Menu {
	private JFrame frame;
	
	FrameDemo4Menu(int x, int y){
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
	}
	
	public static void main(String[] args) {
		new FrameDemo4Menu(0, 0);
	}
}
