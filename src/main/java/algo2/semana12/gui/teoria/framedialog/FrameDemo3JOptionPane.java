package algo2.semana12.gui.teoria.framedialog;

import java.awt.BorderLayout;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameDemo3JOptionPane {
	private JFrame frame;
	
	FrameDemo3JOptionPane(int x, int y){
		frame = new JFrame();
		frame.setTitle("demo");
		frame.setLocation(x, y);
		frame.setSize(400, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		agregarComponente();
	}
	private void agregarComponente() {
		JButton btnAviso = new JButton("Aviso");
		btnAviso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Un mensahe de aviso", "Aviso", JOptionPane.INFORMATION_MESSAGE); 
			}
		});
		frame.getContentPane().add(btnAviso, BorderLayout.NORTH);

		JButton btnInput = new JButton("Entrada de Datos");
		btnInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dato = JOptionPane.showInputDialog(null, "Ingrese un valor:", "Ingreso", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "El valor ingresado es " + dato, "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		frame.getContentPane().add(btnInput, BorderLayout.SOUTH);

		JButton btnConfirmacion = new JButton("Confirmacion");
		btnConfirmacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int opc = JOptionPane.showConfirmDialog(null, "Seguro de salir?");
				if (opc == JOptionPane.YES_OPTION)
					JOptionPane.showMessageDialog(null, "Contesto que si.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				else if (opc == JOptionPane.NO_OPTION)
					JOptionPane.showMessageDialog(null, "Contesto que no.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				else if (opc == JOptionPane.CANCEL_OPTION)
					JOptionPane.showMessageDialog(null, "Contesto cancelar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		frame.getContentPane().add(btnConfirmacion, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new FrameDemo3JOptionPane(0, 0);
	}
}
