package algo2.semana13.functions;

import java.util.List;
import algo2.semana13.entitys.Escuela;
import algo2.semana13.entitys.Estudiante;
import algo2.semana13.entitys.EstudiantesFactoryMock;

public class Demo1FIPredicate {
	
	void procesarEstudianteDeSistemas(List<Estudiante> le) {
		for (Estudiante e : le) {
			if (e.getEscuela().equals(Escuela.Sistemas)) {
				System.out.println(e);
			}
		}
	}
	
	void procesarEstudianteConPromedioAprobado(List<Estudiante> le) {
		for (Estudiante e : le) {
			if (e.getPromedio() > 10.5 ) {
				System.out.println(e);
			}
		}
	}
	
	void procesarEstudianteCuyoNombreComienzaConA(List<Estudiante> le) {
		for (Estudiante e : le) {
			if (e.getNombre().startsWith("A")) {
				System.out.println(e);
			}
		}
	}

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
		procesarEstudianteQueCumple(le, new Condicion() {
			@Override
			public boolean test(Estudiante e) {
				return e.getEscuela().equals(Escuela.Sistemas);
			}
		});
		
		procesarEstudianteQueCumple(le, new Condicion() {
			@Override
			public boolean test(Estudiante e) {
				return e.getPromedio() > 10.5;
			}
		});
		
		procesarEstudianteQueCumple(le, new Condicion() {
			@Override
			public boolean test(Estudiante e) {
				return e.getNombre().startsWith("A");
			}
		});
	}
	
	
	public static void main(String[] args) {
		Demo1FIPredicate demo = new Demo1FIPredicate();
		demo.demo();
	}
}
