package algo2.semana13.functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Limitaciones {
  private JButton btnAceptar = new JButton("Aceptar");
  private String titulo = "";
  
  void demo() {
	  final int finalInt = 0;
	  int finalEfectivoInt = 0;
	  int noFinalInt = 0;
	  noFinalInt = 10; // esto hace que no sea final efectivo
	  btnAceptar.addActionListener(new ActionListener() {
		  int val2 = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			titulo = "abc";
			int a = finalInt + 1;
			a = finalEfectivoInt + 1;
			//a = noFinalInt + 1; //Error de compilacion
			//El uso de this es diferente en clase anonima que en lambda
			this.val2 = 10;
			val2 = 20;
			Limitaciones.this.titulo = "abc";
		}
	  });
	  btnAceptar.addActionListener( e -> {
		  titulo = "abc";
		  int a = finalInt + 1; //variable local valor es de solo lecture
		  a = finalEfectivoInt + 1;
		  //a = noFinalInt + 1;//Error de compilacion
		  //El uso de this es diferente en clase anonima que en lambda
		  this.titulo = "abc";
		  Limitaciones.this.titulo = "abc";
	  });
  }
  
}
