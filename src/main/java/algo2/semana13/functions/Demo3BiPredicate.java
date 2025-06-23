package algo2.semana13.functions;

import java.util.List;

import algo2.semana13.entitys.Escuela;
import algo2.semana13.entitys.Estudiante;
import algo2.semana13.entitys.EstudiantesFactoryMock;

public class Demo3BiPredicate {
	
	void procesarEstudiantePorEscuela(List<Estudiante> le, Escuela escuela) {
		for (Estudiante e : le) {
			if (e.getEscuela().equals(escuela)) {
				System.out.println(e);
			}
		}
	}
	
	void procesarEstudianteConPromedioMayorA(List<Estudiante> le, double promedio) {
		for (Estudiante e : le) {
			if (e.getPromedio() > promedio ) {
				System.out.println(e);
			}
		}
	}
	
	void procesarEstudianteCuyoNombreCoincide(List<Estudiante> le, String nombreRegexp) {
		for (Estudiante e : le) {
			if (e.getNombre().matches(nombreRegexp)) {
				System.out.println(e);
			}
		}
	}
	
	interface Condicion {
		boolean test(Estudiante e, Object valor);
	}
	
	void procesarEstudianteQueCumple(List<Estudiante> le, Condicion con, Object valor) {
		for (Estudiante e : le) {
			if (con.test(e, valor)) {
				System.out.println(e);
			}
		}
	}

	private void demo() {
		List<Estudiante> le = EstudiantesFactoryMock.getEstudiantes();
		procesarEstudianteQueCumple(le, new Condicion() {
			@Override
			public boolean test(Estudiante e, Object escuela) {
				return e.getEscuela().equals(escuela);
			}
		}, Escuela.Sistemas);
		
		procesarEstudianteQueCumple(le, 
				(e, promedio) -> e.getPromedio() > (Double)promedio,
				10.5
		);
		
		procesarEstudianteQueCumple(le, 
				(e, nombreRegExp) -> e.getNombre().matches((String)nombreRegExp),
				".*Un.*"
		);
	}
		
	
	public static void main(String[] args) {
		Demo3BiPredicate demo = new Demo3BiPredicate();
		demo.demo();
	}

}
