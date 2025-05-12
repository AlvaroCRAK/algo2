package algo2.semana07.lista;

public interface Lista<E> {
	boolean add(E e);
	void add(int index, E element); //Al ultimo
	void addFirst(E e);
	void addLast(E e);
	void clear();
	boolean contains(Object o);
	boolean equals(Object o); //Al ultimo
	E get(int index);
	E set(int index, E element);
	int indexOf(Object o);
	boolean isEmpty();
	E remove(int index);
	boolean remove(Object o);
	int size();
}