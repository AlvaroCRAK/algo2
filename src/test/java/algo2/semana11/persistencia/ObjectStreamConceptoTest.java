package algo2.semana11.persistencia;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class ObjectStreamConceptoTest {
    private File testFile = null;
    private Object[] data;

    @Before
    public void init() {
        data = new Object[] { "Abc", 10, 2.5 };
        try {
            testFile = File.createTempFile("abc", "txt");
        } catch (IOException e) {
            fail("No se pudo crear tempfile");
            e.printStackTrace();
        }
    }

    @Test
    public void comoUnSoloObject() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile));
            out.writeObject(data);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile));
            Object[] dataReaded = (Object[]) in.readObject();
            assertArrayEquals(data, dataReaded);
            for (Object object : dataReaded) {
                System.out.println(object);
            }
            in.close();
        } catch (FileNotFoundException e) {
            fail("Archivo no encontrado");
            e.printStackTrace();
        } catch (IOException e) {
            fail("IOException");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException");
            e.printStackTrace();
        }
    }

    @Test
    public void objectElementoPorElemento() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile));
            for (Object object : data) {
                out.writeObject(object);
            }
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile));
            for (int i = 0; i < data.length; i++) {
                Object dataReaded = (Object) in.readObject();
                assertEquals(data[i], dataReaded);
            }
            in.close();

        } catch (FileNotFoundException e) {
            fail("Archivo no encontrado");
            e.printStackTrace();
        } catch (IOException e) {
            fail("IOException");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException");
            e.printStackTrace();
        }
    }

    @Test
    public void stringYPrimitivosElementoPorElemento() throws ClassNotFoundException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile));
            out.writeUTF((String) data[0]);
            out.writeInt((Integer) data[1]);
            out.writeDouble((Double) data[2]);
            int[] numeros1 = { 1, 2, 3 };
            out.writeObject(numeros1);
            int[] numeros2 = { 4, 5 };
            out.writeObject(numeros2);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile));
            assertEquals((String) data[0], in.readUTF());
            assertEquals(((Integer) data[1]).intValue(), in.readInt());
            assertEquals(((Double) data[2]).doubleValue(), in.readDouble());
            int[] numeros3 = (int[]) in.readObject();
            assertArrayEquals(numeros1, numeros3);
            int[] numeros4 = (int[]) in.readObject();
            assertArrayEquals(numeros2, numeros4);

            for (int i : numeros4) {
                System.out.println(i);
            }

            in.close();

        } catch (FileNotFoundException e) {
            fail("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            fail("IOException");
            e.printStackTrace();
        }
    }

    @Test
    public void objetosDeUnListElementoPorElemento() throws ClassNotFoundException {
        List<Integer> lista = Arrays.asList(1, 2, 3);
        List<Integer> lista2 = new ArrayList<>();
        try (
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile));
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile));) {

            for (Integer numero : lista) {
                out.writeObject(numero);
            }
            // Cerrar el stream de salida para que se escriban los datos en disco antes de leerlos
            out.close();

            while (true) {
                try {
                    Integer o = (Integer) in.readObject();
                    lista2.add(o);
                } catch (EOFException e) {
                    break;
                }
            }

            assertEquals(lista, lista2);
        } catch (FileNotFoundException e) {
            fail("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            fail("IOException");
            e.printStackTrace();
        }
    }

    @Test
    public void siSeGrabaComoUnSoloObjetoTendriaQueLeerIgual() throws ClassNotFoundException {
        List<Integer> lista = Arrays.asList(1, 2, 3);
        List<Integer> lista2 = new ArrayList<>();
        try (
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile));
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile));) {

            out.writeObject(lista);
            out.close();

            lista2 = (List<Integer>) in.readObject();

            assertEquals(lista, lista2);
        } catch (FileNotFoundException e) {
            fail("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            fail("IOException");
            e.printStackTrace();
        }
    }

}
