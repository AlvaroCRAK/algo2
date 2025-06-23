package algo2.semana12.gui.teoria.framedialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameDemo2Evento {
	JFrame frame;
	static int cantidadFrame = 0; 
	
	FrameDemo2Evento(int x, int y){
		cantidadFrame++;
		frame = new JFrame();
		frame.setTitle("demo");
		frame.setLocation(x, y);
		frame.setSize(400, 200);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		
			@Override
			public void windowClosing(WindowEvent e) {
				int opc = JOptionPane.showConfirmDialog(frame, "Salir de la aplicacion?");
				if (opc == JOptionPane.YES_OPTION) {
					frame.dispose();
				}
			}
		});
		JButton btn = new JButton("Nuevo Frame");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameDemo2Evento(cantidadFrame*10, cantidadFrame*10); 
			}
		});
		frame.getContentPane().add(btn);
	}
	
	public static void main(String[] args) {
		new FrameDemo2Evento(0, 0);
	}
}
