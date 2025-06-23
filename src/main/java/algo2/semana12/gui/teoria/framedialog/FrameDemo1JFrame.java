package algo2.semana12.gui.teoria.framedialog;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameDemo1JFrame {
	JFrame frame;
	
	FrameDemo1JFrame(){
		frame = new JFrame();
		frame.setTitle("demo");
		frame.setSize(400, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new JButton("Nuevo Frame"));
	}
	
	public static void main(String[] args) {
		new FrameDemo1JFrame();
		JOptionPane.showMessageDialog(null, "demo");
	}
}
