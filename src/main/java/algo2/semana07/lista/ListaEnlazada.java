package algo2.semana07.lista;

public class ListaEnlazada<E> implements Lista<E> {
    class Nodo {
        E elemento;
        Nodo siguiente;

        Nodo(E elemento, Nodo siguiente) {
            this.elemento = elemento;
            this.siguiente = siguiente;
        }
    }

    public Nodo inicio;
    public Nodo fin;
    public int cantidadElemento;

    @Override
    public boolean add(E e) {
        Nodo nodo = new Nodo(e, null);
        if (inicio == null) {
            inicio = fin = nodo;
        } else {
            fin.siguiente = nodo;
            fin = nodo;
        }
        cantidadElemento++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > cantidadElemento) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + cantidadElemento);
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == cantidadElemento) {
            addLast(element);
            return;
        }
        Nodo prev = inicio;
        for (int i = 1; i < index; i++) {
            prev = prev.siguiente;
        }
        Nodo nodo = new Nodo(element, prev.siguiente);
        prev.siguiente = nodo;
        cantidadElemento++;
    }

    @Override
    public void addFirst(E e) {
        Nodo nodo = new Nodo(e, null);
        if (inicio == null) {
            inicio = fin = nodo;
        } else {
            nodo.siguiente = inicio;
            inicio = nodo;
        }
        cantidadElemento++;
    }

    @Override
    public void addLast(E e) {
        add(e);
    }

    @Override
    public void clear() {
        inicio = fin = null;
        cantidadElemento = 0;
    }

    @Override
    public boolean contains(Object o) {
        Nodo actual = inicio;
        while (actual != null) {
            if (o == null ? actual.elemento == null : o.equals(actual.elemento)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= cantidadElemento) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + cantidadElemento);
        }
        Nodo actual = inicio;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        return actual.elemento;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= cantidadElemento) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + cantidadElemento);
        }
        Nodo actual = inicio;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        E old = actual.elemento;
        actual.elemento = element;
        return old;
    }

    @Override
    public int indexOf(Object o) {
        Nodo actual = inicio;
        int index = 0;
        while (actual != null) {
            if (o == null ? actual.elemento == null : o.equals(actual.elemento)) {
                return index;
            }
            actual = actual.siguiente;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return cantidadElemento == 0;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= cantidadElemento) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + cantidadElemento);
        }
        E removed;
        if (index == 0) {
            removed = inicio.elemento;
            inicio = inicio.siguiente;
            if (inicio == null) {
                fin = null;
            }
        } else {
            Nodo prev = inicio;
            for (int i = 1; i < index; i++) {
                prev = prev.siguiente;
            }
            Nodo target = prev.siguiente;
            removed = target.elemento;
            prev.siguiente = target.siguiente;
            if (target == fin) {
                fin = prev;
            }
        }
        cantidadElemento--;
        return removed;
    }

    @Override
    public boolean remove(Object o) {
        Nodo prev = null;
        Nodo actual = inicio;
        while (actual != null) {
            if (o == null ? actual.elemento == null : o.equals(actual.elemento)) {
                if (prev == null) {
                    inicio = actual.siguiente;
                } else {
                    prev.siguiente = actual.siguiente;
                }
                if (actual == fin) {
                    fin = prev;
                }
                cantidadElemento--;
                return true;
            }
            prev = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public int size() {
        return cantidadElemento;
    }

    @Override
    public String toString() {
        String s = "Lista(";
        Nodo actual = inicio;
        for (int i = 0; i < cantidadElemento - 1; i++) {
            s += actual.elemento + ", ";
            actual = actual.siguiente;
        }
        if (actual != null) {
            s += actual.elemento;
        }
        s += ")";
        return s;
    }

    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.add(20);
        lista.add(15);
        lista.add(18);
        lista.addFirst(10);
        System.out.println(lista.toString());
    }
}