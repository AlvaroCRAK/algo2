package algo2.semana07.lista;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListaEnlazadaTest {
    ListaEnlazada<Integer> lista;

    @Before
    public void setup() {
        lista = new ListaEnlazada<>();
        lista.add(20);
        lista.add(15);
        lista.add(18);
    }

    @Test
    public void testAddE() {
        assertTrue(lista.add(5));
        assertEquals(4, lista.size());
        assertEquals("Lista(20, 15, 18, 5)", lista.toString());
    }

    @Test
    public void testAddIntE() {
        lista.add(1, 25);
        assertEquals(4, lista.size());
        assertEquals("Lista(20, 25, 15, 18)", lista.toString());
    }

    @Test
    public void testAddFirst() {
        lista.addFirst(5);
        assertEquals(4, lista.size());
        assertEquals("Lista(5, 20, 15, 18)", lista.toString());
    }

    @Test
    public void testAddLast() {
        lista.addLast(7);
        assertEquals(4, lista.size());
        assertEquals("Lista(20, 15, 18, 7)", lista.toString());
    }

    @Test
    public void testClear() {
        lista.clear();
        assertTrue(lista.isEmpty());
        assertEquals("Lista()", lista.toString());
    }

    @Test
    public void testContains() {
        assertTrue(lista.contains(15));
        assertFalse(lista.contains(100));
    }

    @Test
    public void testGet() {
        assertEquals(Integer.valueOf(15), lista.get(1));
    }

    @Test
    public void testSet() {
        Integer old = lista.set(1, 30);
        assertEquals(Integer.valueOf(15), old);
        assertEquals("Lista(20, 30, 18)", lista.toString());
    }

    @Test
    public void testIndexOf() {
        assertEquals(1, lista.indexOf(15));
        assertEquals(-1, lista.indexOf(100));
    }

    @Test
    public void testIsEmpty() {
        ListaEnlazada<Integer> lista2 = new ListaEnlazada<>();
        assertTrue(lista2.isEmpty());
    }

    @Test
    public void testRemoveInt() {
        Integer removed = lista.remove(1);
        assertEquals(Integer.valueOf(15), removed);
        assertEquals(2, lista.size());
        assertEquals("Lista(20, 18)", lista.toString());
    }

    @Test
    public void testRemoveObject() {
        lista.remove(Integer.valueOf(15));
        assertEquals("Lista(20, 18)", lista.toString());
    }

    @Test
    public void testSize() {
        ListaEnlazada<Integer> listaEmpty = new ListaEnlazada<>();
        assertEquals(0, listaEmpty.size());
    }

    @Test
    public void testToString() {
        assertEquals("Lista(20, 15, 18)", lista.toString());
    }

    @Test
    public void testtoStringConUnaListaVacia() {
        lista.clear();
        assertEquals("Lista()", lista.toString());
    }

    @Test
    public void testtoStringConUnElemento() {
        lista.clear();
        lista.add(20);
        assertEquals("Lista(20)", lista.toString());
    }

    @Test
    public void testtoStringConVariosElementos() {
        assertEquals("Lista(20, 15, 18)", lista.toString());
    }
}
