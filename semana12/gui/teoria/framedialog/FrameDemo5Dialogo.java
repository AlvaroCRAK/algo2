package algo2.semana12.gui.teoria.framedialog;

import java.awt.Container;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FrameDemo5Dialogo {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public FrameDemo5Dialogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
				ayuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		
		textField = new JTextField();
		
		textField_2 = new JTextField();
		
		textField_1 = new JTextField();
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		frame.getContentPane().setLayout(new MigLayout("", "[90px][124px][90px]", "[19px][19px]"));
		frame.getContentPane().add(textField, "cell 0 0,growx,aligny top");
		frame.getContentPane().add(textField_2, "cell 1 0,growx,aligny top");
		frame.getContentPane().add(textField_1, "cell 0 1,growx,aligny top");
		frame.getContentPane().add(textField_3, "cell 1 1,alignx left,aligny top");
		frame.getContentPane().add(new JTextField(), "cell 0 2 3 1,growx, alignx left,aligny top");
		
	}

}
