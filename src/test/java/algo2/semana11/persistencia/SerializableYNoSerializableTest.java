package algo2.semana11.persistencia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

public class SerializableYNoSerializableTest {
    private File testFile = null;
    private final Data d1 = new Data("111", "AAA");

    @Before
    public void init() {
        try {
            testFile = File.createTempFile("abc", "txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void unSoloData() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile));
            out.writeObject(d1);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile));
            Data d = (Data) in.readObject();
            assertEquals(d1, d);
            assertNull(d.getNoSeraSerializado1());
            assertEquals(0, d.getNoSeraSerializado2());
            assertNotNull(d.getSeraSerializado2());

            in.close();
        } catch (FileNotFoundException e) {
            fail("Fallo con archivo");
            e.printStackTrace();
        } catch (IOException e) {
            fail("Fallo con archivo");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            fail("Fallo con casting");
            e.printStackTrace();
        }
    }
}
