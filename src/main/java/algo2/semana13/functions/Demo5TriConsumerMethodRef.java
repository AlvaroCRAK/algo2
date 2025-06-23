package algo2.semana13.functions;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import algo2.semana13.entitys.Escuela;
import algo2.semana13.entitys.Estudiante;
import algo2.semana13.entitys.EstudiantesFactoryMock;

class Estudiante2 extends Estudiante{
	public Estudiante2(String codigo, String nombre, double promedio, Escuela escuela) {
		super(codigo, nombre, promedio, escuela);
	}
	
	Estudiante2(Estudiante e) {
		this(e.getCodigo(), e.getNombre(), e.getPromedio(), e.getEscuela());
	}
	
	void hacerAlgo3(Double d1, Double d2) {
		  setPromedio(getPromedio() + d1 - d2);
	}
}

class EstudianteUtil {
  static void hacerAlgo1(Estudiante2 e, Double d1, Double d2) {
	  e.setPromedio(e.getPromedio() + d1 - d2);
  }
  void hacerAlgo2(Estudiante2 e, Double d1, Double d2) {
	  e.setPromedio(e.getPromedio() + d1 - d2);
  }
}


public class Demo5TriConsumerMethodRef {
	
	interface Accion<T, U, V>{ 
		void accept(T t, U u, V v);
	}
	
	void procesarEstudianteQueCumple(List<Estudiante2> le, BiPredicate<Estudiante, Object> 
			con, Object valor, Accion<Estudiante2, Double, Double> accion, Double dato1, Double dato2) {
		for (Estudiante2 e : le) {
			if (con.test(e, valor)) {
				accion.accept(e, dato1, dato2);
			}
		}
	}
	
	
	private void demo() {
		List<Estudiante2> le = 
				EstudiantesFactoryMock.getEstudiantes()
				.stream().map(e -> new Estudiante2(e))
				.collect(Collectors.toList());
		
		procesarEstudianteQueCumple(le, 
				(e, escuela) -> e.getEscuela().equals(escuela),
				Escuela.Sistemas, 
				(e, d1, d2) -> { EstudianteUtil.hacerAlgo1(e, d1, d2);},
				3.0, 2.0
			);
		
		procesarEstudianteQueCumple(le, 
				(e, escuela) -> e.getEscuela().equals(escuela),
				Escuela.Sistemas, 
				EstudianteUtil::hacerAlgo1,
				3.0, 2.0
			);

		EstudianteUtil eu = new EstudianteUtil();
		//Estudiante2 e2 = new Estudiante2("12345678", "Juan Perez", 18.0, Escuela.Software);
		procesarEstudianteQueCumple(le, 
				(e, escuela) -> e.getEscuela().equals(escuela),
				Escuela.Sistemas, 
				(e, d1, d2) -> { eu.hacerAlgo2(e, d1, d2);},
				3.0, 2.0
			);
		procesarEstudianteQueCumple(le, 
				(e, escuela) -> e.getEscuela().equals(escuela),
				Escuela.Sistemas, 
				eu::hacerAlgo2,
				3.0, 2.0
			);

		procesarEstudianteQueCumple(le, 
				(e, escuela) -> e.getEscuela().equals(escuela),
				Escuela.Sistemas, 
				(e, d1, d2) -> { e.hacerAlgo3(d1, d2);},
				3.0, 2.0
			);
		
		procesarEstudianteQueCumple(le, 
				(e, escuela) -> e.getEscuela().equals(escuela),
				Escuela.Sistemas, 
				Estudiante2::hacerAlgo3,
				3.0, 2.0
			);
		
		List<Estudiante2> le1 = 
				EstudiantesFactoryMock.getEstudiantes()
				.stream().map(e -> new Estudiante2(e))
				.collect(Collectors.toList());

		List<Estudiante2> le2 = 
				EstudiantesFactoryMock.getEstudiantes()
				.stream().map(Estudiante2::new)
				.collect(Collectors.toList());
		
	}
	
	public static void main(String[] args) {
		Demo5TriConsumerMethodRef demo = new Demo5TriConsumerMethodRef();
		demo.demo();
	}
}
