package algo2.semana13.streams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class ReduceCollectJoiningTest {

    @Test
    public void joining() {
        String delimiter = " ";

        // Usando Collectors.joining correcto
        String s = Stream.of("Hola", "Mundo", "!!")
                .collect(Collectors.joining(delimiter));
        String esperado = "Hola Mundo !!";
        assertEquals(esperado, s);

        // Usando reduce para concatenar con delimitador
        s = Stream.of("Hola", "Mundo", "!!")
                .reduce("", (rp, e) -> rp.isEmpty() ? e : rp + delimiter + e);
        assertEquals(esperado, s);

        // Usando StringBuilder en collect para concatenar
        s = Stream.of("Hola", "Mundo", "!!")
                .collect(
                        () -> new StringBuilder(),
                        (sb, e) -> {
                            if (sb.length() > 0)
                                sb.append(delimiter);
                            sb.append(e);
                        },
                        (sb1, sb2) -> {
                            if (sb1.length() > 0)
                                sb1.append(delimiter);
                            sb1.append(sb2);
                        })
                .toString();

        assertEquals(esperado, s);

        // Usando la clase StringAcuCom personalizada
        s = Stream.of("Hola", "Mundo", "!!")
                .collect(() -> new StringAcuCom("", delimiter),
                        StringAcuCom::accu,
                        StringAcuCom::comb)
                .toString();

        assertEquals(esperado, s);
    }

    static class StringAcuCom {
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
            if (s.length() > 0) {
                s.append(delimiter);
            }
            s.append(e);
        }

        void comb(StringAcuCom otro) {
            if (otro.s.length() == 0) return;

            if (s.length() > 0) {
                s.append(delimiter);
            }
            s.append(otro.s);
        }

        @Override
        public String toString() {
            return s.toString();
        }
    }
}
