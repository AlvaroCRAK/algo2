package algo2.semana13.streams;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import algo2.semana13.entitys.Escuela;
import algo2.semana13.entitys.Estudiante;
import algo2.semana13.entitys.EstudiantesFactoryMock;

public class Reducing {

    List<Estudiante> estudiantes;
    EstudiantesFactoryMock EstFact;

    @Before
    public void init() {
        EstFact = new EstudiantesFactoryMock();  // Inicializar aquí
        estudiantes = EstFact.getEstudiantes();
    }   
    
    public double promedioSum(Estudiante... estudiantes) {
        double result = 0;
        for (Estudiante estudiante : estudiantes) {
            result += estudiante.getPromedio();
        } 
        return result;
    }

    public double promedioMedio(Estudiante... estudiantes) {
        double result = promedioSum(estudiantes);
        return result / estudiantes.length;
    }
    
    @Test
    public void average() {
        double prom = estudiantes
                .stream()
                .filter(e -> e.getEscuela() == Escuela.Sistemas)
                .mapToDouble(Estudiante::getPromedio)
                .average()
                .getAsDouble();

        double esperado = promedioMedio(EstFact.e1, EstFact.e3, EstFact.e5, EstFact.e7);
        assertEquals(esperado, prom, 0.0001);
        
        prom = estudiantes
                .stream()
                .filter(e -> e.getEscuela() == Escuela.Sistemas)
                .collect(Collectors.averagingDouble(Estudiante::getPromedio));
        assertEquals(esperado, prom, 0.0001);
    }

    @Test
    public void sum() {
        double sum = estudiantes
                .stream()
                .filter(e -> e.getEscuela() == Escuela.Sistemas)
                .mapToDouble(Estudiante::getPromedio)
                .sum();

        double esperado = promedioSum(EstFact.e1, EstFact.e3, EstFact.e5, EstFact.e7);
        assertEquals(esperado, sum, 0.0001);
        
        sum = estudiantes
                .stream()
                .filter(e -> e.getEscuela() == Escuela.Sistemas)
                .collect(Collectors.summarizingDouble(Estudiante::getPromedio))
                .getSum();

        assertEquals(esperado, sum, 0.0001);
    }
}
