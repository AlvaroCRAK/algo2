package algo2.semana13.functions;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import algo2.semana13.entitys.Escuela;
import algo2.semana13.entitys.Estudiante;
import algo2.semana13.entitys.EstudiantesFactoryMock;

public class Demo6APIFI {
	
	void procesarEstudianteQueCumple(List<Estudiante> le, Predicate<Estudiante> con) {
		for (Estudiante e : le) {
			if (con.test(e)) {
				System.out.println(e);
			}
		}
	}

	private void demoConPredicate() {
		List<Estudiante> le = EstudiantesFactoryMock.getEstudiantes();
		procesarEstudianteQueCumple(le,
				e-> e.getEscuela().equals(Escuela.Sistemas)
		);
		
		procesarEstudianteQueCumple(le,
				e -> e.getPromedio() > 10.5
		);
		
		procesarEstudianteQueCumple(le, 
				e-> e.getNombre().startsWith("A")
		);
	}

	void procesarEstudianteQueCumple(List<Estudiante> le, BiPredicate<Estudiante, Object> 
			con, Object valor) {
		for (Estudiante e : le) {
			if (con.test(e, valor)) {
				System.out.println(e);
			}
		}
	}
	
	private void demoConBiPredicate() {
		List<Estudiante> le = EstudiantesFactoryMock.getEstudiantes();
		procesarEstudianteQueCumple(le, 
				(e, escuela) ->  e.getEscuela().equals(escuela),
				Escuela.Sistemas);
		
		procesarEstudianteQueCumple(le, 
				(e, promedio) -> e.getPromedio() > (Double) promedio,
				10.5);
		
		procesarEstudianteQueCumple(le, 
				(e, nombreRegExp) ->  e.getNombre().matches((String)nombreRegExp),
				".*Un.*");
	}
	
	void procesarEstudianteQueCumple(List<Estudiante> le, 
			BiPredicate<Estudiante, Object>	con, 
			Object valor, 
			Consumer<Estudiante> accion 
		) {
		for (Estudiante e : le) {
			if (con.test(e, valor)) {
				accion.accept(e);
			}
		}
	}

	private void demoConConsumer() {
		List<Estudiante> le = EstudiantesFactoryMock.getEstudiantes();
		procesarEstudianteQueCumple(le, 
				(e, escuela) ->  e.getEscuela().equals(escuela),
				Escuela.Sistemas, 
				System.out::println
		);
	}
	

	void procesarEstudianteQueCumple(List<Estudiante> le, 
			BiPredicate<Estudiante, Object>	con, 
			Object valor, 
			BiConsumer<Estudiante,Double> accion, 
			Double dato) {
		for (Estudiante e : le) {
			if (con.test(e, valor)) {
				accion.accept(e, dato);
			}
		}
	}
	
	private void demoConBiConsumer() {
		List<Estudiante> le = EstudiantesFactoryMock.getEstudiantes();
		procesarEstudianteQueCumple(le, 
				(e, escuela) ->  e.getEscuela().equals(escuela),
				Escuela.Sistemas, 
				(e, nota) -> e.setPromedio(0),
				2.0
		);
	}

	
	public static void main(String[] args) {
		Demo6APIFI demo = new Demo6APIFI();
		demo.demoConPredicate();
		demo.demoConBiPredicate();
	}
}
