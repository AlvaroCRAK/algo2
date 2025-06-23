package algo2.semana13.functions;

import java.util.List;
import java.util.function.BiPredicate;

import algo2.semana13.entitys.Escuela;
import algo2.semana13.entitys.Estudiante;
import algo2.semana13.entitys.EstudiantesFactoryMock;

public class Demo4Consumer {
	
	interface Accion<T> {
		void accept(T t);
	}
	
	void procesarEstudianteQueCumple(List<Estudiante> le, BiPredicate<Estudiante, Object> 
			con, Object valor, Accion<Estudiante> accion) {
		for (Estudiante e : le) {
			if (con.test(e, valor)) {
				accion.accept(e);
			}
		}
	}
	
	void imprime(Estudiante e) {
		
	}
	
	private void demo() {
		List<Estudiante> le = EstudiantesFactoryMock.getEstudiantes();
		
		Accion<Estudiante> estudianteImpresor = new Accion<Estudiante>() {
			@Override
			public void accept(Estudiante e) {
				System.out.println(e);
			}
		};
		
		Accion<Estudiante> estudianteResumidoImpresor = 
				e -> System.out.format("%s: %f%n", e.getNombre(), e.getPromedio());
		
		Accion<Estudiante> estudianteGuardadorEnArchivo = 
				e -> System.out.format("Guardado: %s%n", e.getNombre());

		Accion<Estudiante> accion = estudianteGuardadorEnArchivo;
		
		
		procesarEstudianteQueCumple(le, 
				(e, escuela) -> e.getEscuela().equals(escuela),
				Escuela.Sistemas, 
				accion
			);
		
		procesarEstudianteQueCumple(le, 
				(e, promedio) -> e.getPromedio() > (Double)promedio,
				10.5,
				accion);
		
		procesarEstudianteQueCumple(le, 
				(e, nombreRegExp) -> e.getNombre().matches((String)nombreRegExp),
				".*Un.*", 
				accion);
	}
	
	public static void main(String[] args) {
		Demo4Consumer demo = new Demo4Consumer();
		demo.demo();
	}
}
