package algo2.semana13.streams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import algo2.semana13.entitys.Escuela;
import algo2.semana13.entitys.Estudiante;

public class ReduceCollectSimpleTest {
    final Escuela sist = Escuela.Sistemas;
    final Escuela soft = Escuela.Software;
    final Estudiante e1 = new Estudiante("12345678", "Angel Ungenio", 8, sist);
    final Estudiante e2 = new Estudiante("22345678", "Beto Dosantos", 9, soft);
    final Estudiante e3 = new Estudiante("32345678", "Carlos Trelles", 10, sist);
    final Estudiante e4 = new Estudiante("42345678", "David Cuadros", 11, soft);
    final Estudiante e5 = new Estudiante("52345678", "Efain Quinto", 12, sist);
    final Estudiante e6 = new Estudiante("62345678", "Felipe Sexto", 16, soft);
    final Estudiante e7 = new Estudiante("72345678", "Guzman Septimo", 18, sist);

    List<Estudiante> estudiantes;

    @Before
    public void init() {
        estudiantes = Arrays.asList(
                e1, e2, e3, e4, e5, e6, e7
        );
    }

    @Test
    public void simpleReduce() {
        double sum = estudiantes.stream()
                .filter(e -> e.getEscuela() == sist)
                .mapToDouble(e -> e.getPromedio())
                .reduce(0, (a, b) -> a + b);

        long cant = estudiantes.stream()
                .filter(e -> e.getEscuela() == sist)
                .count();

        double prom = sum / cant;

        double expected = promedioMedio(e1, e3, e5, e7);
        assertEquals(expected, prom, 0.0001);
    }

    @Test
    public void contar() {
        int cantidad = (int) estudiantes.stream()
                .count();
        assertEquals(7, cantidad);

        cantidad = (int) estudiantes.stream()
                .reduce(0, (rp, e) -> rp + 1, (rp1, rp2) -> rp1 + rp2);
        assertEquals(7, cantidad);

        cantidad = (int) estudiantes.stream()
                .collect(() -> new MutableNum<Integer>(0, Integer.class),
                        (rp, e) -> rp.inc(),
                        (rp1, rp2) -> rp1.inc(rp2.getValue()))
                .getValue();
        assertEquals(7, cantidad);
    }

    private double promedioSum(Estudiante... estudiantes) {
        double result = 0;
        for (Estudiante estudiante : estudiantes) {
            result += estudiante.getPromedio();
        }
        return result;
    }

    private double promedioMedio(Estudiante... estudiantes) {
        double result = promedioSum(estudiantes);
        return result / estudiantes.length;
    }

    @Test
    public void sum() {
        double sum = estudiantes.stream()
                .mapToDouble(e -> e.getPromedio())
                .sum();
        double esperado = promedioSum(estudiantes.toArray(new Estudiante[0]));
        assertEquals(esperado, sum, 0.0001);

        sum = estudiantes.stream()
                .collect(Collectors.summingDouble(e -> e.getPromedio()));
        assertEquals(esperado, sum, 0.0001);

        sum = estudiantes.stream()
                .mapToDouble(e -> e.getPromedio())
                .reduce(0.0, (rp, p) -> rp + p);
        assertEquals(esperado, sum, 0.0001);

        sum = estudiantes.stream()
                .mapToDouble(e -> e.getPromedio())
                .collect(() -> new MutableNum<Double>(0.0, Double.class),
                        (rp, p) -> rp.inc(p),
                        (rp1, rp2) -> rp1.inc(rp2.getValue()))
                .getValue();
        assertEquals(esperado, sum, 0.0001);
    }

    @Test
    public void losWrapperNoSonMutable() {
        Integer i1 = 10;
        Integer i2 = i1;
        i1 += 1;
        assertFalse(i1 == i2);
    }

    class MutableNum<T extends Number> {
        private T n;
        Class<T> klass;

        MutableNum(T n, Class<T> klass) {
            this.n = n;
            this.klass = klass;
        }

        T getValue() {
            return n;
        }

        void setValue(T newVal) {
            n = newVal;
        }

        void inc() {
            inc((T) Integer.valueOf(1));
        }

        void inc(T cant) {
            if (klass == Double.class) {
                Double r = n.doubleValue() + (double) cant;
                n = (T) r;
            } else if (klass == Long.class) {
                Long r = n.longValue() + (long) cant;
                n = (T) r;
            } else {
                Integer r = n.intValue() + (int) cant;
                n = (T) r;
            }
        }
    }

    @Test
    public void contarCondicional() {
        int cantidad = (int) estudiantes.stream()
                .filter(e -> e.getEscuela() == sist)
                .mapToDouble(e -> e.getPromedio())
                .reduce(0.0, (rp, prom) -> {
                    if (prom > 10.5)
                        rp += 1;
                    return rp;
                });
        double expected = 2;
        assertEquals(expected, cantidad, 0.0001);

        int sum = estudiantes.stream()
                .filter(e -> e.getEscuela() == sist)
                .mapToDouble(e -> e.getPromedio())
                .collect(() -> new MutableNum<Integer>(0, Integer.class),
                        (rp, prom) -> {
                            if (prom > 10.5)
                                rp.inc();
                        },
                        (rp1, rp2) -> rp1.inc(rp2.getValue()))
                .getValue();
        expected = 2;
        assertEquals(expected, sum);
    }
}
