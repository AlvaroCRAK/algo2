package algo2.semana13.functions;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import algo2.semana13.entitys.Escuela;
import algo2.semana13.entitys.Estudiante;
import algo2.semana13.entitys.EstudiantesFactoryMock;

public class Demo2Lambda {
	
	interface Condicion {
		boolean test(Estudiante e);
	}
	
	void procesarEstudianteQueCumple(List<Estudiante> le, Condicion con) {
		for (Estudiante e : le) {
			if (con.test(e)) {
				System.out.println(e);
			}
		}
	}

	private void demo() {
		List<Estudiante> le = EstudiantesFactoryMock.getEstudiantes();
		procesarEstudianteQueCumple(le,
				e -> e.getEscuela().equals(Escuela.Sistemas)
		);
		
		procesarEstudianteQueCumple(le, 
				e -> e.getPromedio() > 10.5
		);
		
		procesarEstudianteQueCumple(le, 
				e -> e.getNombre().startsWith("A")
		);
	}
	
	private void demo2() {
		JButton b = new JButton();
		b.addActionListener(
					e -> {JOptionPane.showMessageDialog(null, "...");}
				);
	}
	
	
	public static void main(String[] args) {
		Demo2Lambda demo = new Demo2Lambda();
		demo.demo();
	}
}
