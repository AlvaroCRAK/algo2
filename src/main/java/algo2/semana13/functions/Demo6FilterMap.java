package algo2.semana13.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import algo2.semana13.entitys.Estudiante;
import algo2.semana13.entitys.EstudiantesFactoryMock;


public class Demo6FilterMap {
	
	List<Estudiante> filtrarEstudiante(List<Estudiante> le, Predicate<Estudiante> con) {
		List<Estudiante> result = new ArrayList<>();
		for (Estudiante e : le) {
			if (con.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
	
	<T,R>List<R> mapList(List<T> le, Function<T, R> mapper) {
		List<R> result = new ArrayList<>();
		for (T t : le) {
			R r = mapper.apply(t);
			result.add(r);
		}
		return result;
	}

	private void demoFilter() {
		List<Estudiante> le = EstudiantesFactoryMock.getEstudiantes();
		
		List<Estudiante> lista = filtrarEstudiante(le, new Predicate<Estudiante>() {
			@Override
			public boolean test(Estudiante e) {
				return e.getPromedio() > 10.5;			
			}
		});
		System.out.println(lista);
		
		
		filtrarEstudiante(le, e-> e.getPromedio() > 10.5).forEach(
				System.out::println
		);
		le.stream().filter(e -> e.getPromedio() > 10.5).forEach(
				System.out::println
		);
	}
	
	private void demoMap() {
		List<Estudiante> le = EstudiantesFactoryMock.getEstudiantes();
		
		mapList(le, e -> e.getNombre().toUpperCase())
			.forEach(System.out::println);
		
		le.stream()
			.map(e -> e.getNombre().toUpperCase())
			.forEach(System.out::println);
	}

	public static void main(String[] args) {
		Demo6FilterMap demo = new Demo6FilterMap();
		demo.demoFilter();
		demo.demoMap();
	}
}
