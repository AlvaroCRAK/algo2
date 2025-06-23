package algo2.semana13.streams;


import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import algo2.semana13.entitys.Estudiante;
import algo2.semana13.entitys.EstudiantesFactoryMock;

public class ReduceCollectEstudianteStatistcTest {
	
	class EstudianteStatistic {
		public int cantidadTotal;
		public double promedio;
		@Override
		public String toString() {
			return String.format("(%d,%f)", cantidadTotal, promedio);
		}
		EstudianteStatistic accu (Estudiante e) { 
			cantidadTotal += 1; 
			promedio += e.getPromedio();	
			return this; 
		};
		EstudianteStatistic combine (EstudianteStatistic other) {
			cantidadTotal += other.cantidadTotal;
			promedio += other.promedio;
			return this;
		}
	}
	
	BiFunction<EstudianteStatistic, ? super Estudiante, EstudianteStatistic> accumulator = (stat, e ) -> 
	{ stat.cantidadTotal += 1; 
	  stat.promedio += e.getPromedio();	
		return stat; 
	};
	
	BinaryOperator<EstudianteStatistic> combiner = (stat1, stat2) -> {
	stat1.cantidadTotal += stat2.cantidadTotal;
	stat1.promedio += stat2.promedio;
	return stat1;
	};
	

	private void demoReduce() {
		List<Estudiante> le = EstudiantesFactoryMock.getEstudiantes();
		
		int total = le.stream().reduce(0, (partialResult, e) -> partialResult + 1 , (p1, p2) -> p1 + p2);
		double sumaPromedio = le.stream().reduce(0.0, (partialResult, e) -> partialResult + e.getPromedio() , (p1, p2) -> p1 + p2);
		EstudianteStatistic statis = le.stream().reduce(new EstudianteStatistic(), 
				EstudianteStatistic::accu,
				EstudianteStatistic::combine
		);
		System.out.format("total=%d, sumap=%f, stat=%s", total, sumaPromedio, statis);
	}
	
	private void demoCollect() {
		List<Estudiante> le = EstudiantesFactoryMock.getEstudiantes();
		
		EstudianteStatistic statis = le.stream().collect(
				EstudianteStatistic::new, 
				EstudianteStatistic::accu,
				EstudianteStatistic::combine
		);
		System.out.format("stat=%s", statis);
	}
	public static void main(String[] args) {
		ReduceCollectEstudianteStatistcTest demo = new ReduceCollectEstudianteStatistcTest();
		demo.demoReduce();
		demo.demoCollect();
	}
}
