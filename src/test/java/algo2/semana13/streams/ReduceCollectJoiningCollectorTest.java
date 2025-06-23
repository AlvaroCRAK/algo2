package algo2.semana13.streams;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class ReduceCollectJoiningCollectorTest {
    static class StringAcuCom implements Collector<String, StringAcuCom, StringAcuCom> {
        private StringBuilder s;
        private String delimiter;

        StringAcuCom(String inicial, String delimiter) {
            s = new StringBuilder(inicial);
            this.delimiter = delimiter;
        }

        StringAcuCom() {
            this("", "");
        }

        void accu(String e) {
            if (s.length() < 1)
                s.append(e);
            else
                s.append(delimiter).append(e);
        }

        StringAcuCom comb(StringAcuCom otro) {
            if (s.length() < 1)
                s.append(otro.s);
            else
                s.append(delimiter).append(otro.s);
            return this;
        }

        @Override
        public String toString() {
            return s.toString();
        }

        @Override
        public Supplier<StringAcuCom> supplier() {
            // Devuelve un nuevo acumulador vacío (muy importante)
            return () -> new StringAcuCom("", delimiter);
        }

        @Override
        public BiConsumer<StringAcuCom, String> accumulator() {
            return StringAcuCom::accu;
        }

        @Override
        public BinaryOperator<StringAcuCom> combiner() {
            return StringAcuCom::comb;
        }

        @Override
        public Function<StringAcuCom, StringAcuCom> finisher() {
            return (a1) -> a1;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
        }
    }

    public static void main(String[] args) {
        String delimiter = " ";
        String s = Stream.of("Hola", "Mundo", "!!")
                .collect(new StringAcuCom("", delimiter))
                .toString();

        String esperado = "Hola Mundo !!";
        if (!esperado.equals(s)) {
            System.err.println("Error: esperado '" + esperado + "' pero fue '" + s + "'");
        } else {
            System.out.println("Test 1 pasó correctamente!");
        }

        s = Stream.of("Hola", "Mundo", "!!")
                .collect(new StringAcuCom())
                .toString();

        esperado = "HolaMundo!!";
        if (!esperado.equals(s)) {
            System.err.println("Error: esperado '" + esperado + "' pero fue '" + s + "'");
        } else {
            System.out.println("Test 2 pasó correctamente!");
        }
    }
}
