package algo2.semana09.generics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenericDemo {
	public static <T> boolean contiene(T[] anArray, T elem) {
		for (T e : anArray)
			if (e.equals(elem))
				return true;
		return false;
	}

	private static void demoContiene() {
		Integer[] enteros = { 2, 4, 6, 8, 10 };
		System.out.println(contiene(enteros, 10));
		System.out.println(contiene(enteros, 5));

		String[] cadenas = { "Java", "Python", "Rust", "Go" };
		System.out.println(contiene(cadenas, "Rust"));
		System.out.println(contiene(cadenas, "F#"));
	}

	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
		int count = 0;
		for (T e : anArray)
			if (e.compareTo(elem) > 0)
				++count;
		return count;
	}
	
	private static void demoCountGreaterThan() {
		Integer[] enteros = { 2, 4, 6, 8, 10 };
		System.out.println(countGreaterThan(enteros, 6));

		String[] cadenas = { "Java", "Python", "Rust", "Go" };
		System.out.println(countGreaterThan(cadenas, "Java"));
	
		Cat[] cs = { new Cat("miaomi1"), new Cat("miaomi2"), new Cat("miaomi3") };
		System.out.println(countGreaterThan(cs, new Cat("miaomi2")));
		
		
	}
	
	public static void sortDemo() {
		List<Integer> lista1 = List.of(30, 20, 10);
		List<Integer> lista2 = new ArrayList<Integer>(lista1);
		
		Collections.sort(lista2);
		System.out.println(lista2);
		List<Persona> ps = new ArrayList<>();
		ps.add(new Persona("DNI", "32345678", LocalDate.of(2008, 4, 4)));
		ps.add(new Persona("DNI", "67211512", LocalDate.of(2007, 6, 12)));
		ps.add(new Persona("AAA", "97832452", LocalDate.of(2005, 9, 29)));
		ps.add(new Persona("DNI", "23456423", LocalDate.of(2000, 11, 30)));
		
		Collections.sort(ps);
		System.out.println(ps);
		
		List<Persona> ps2 = new ArrayList<>();
		ps2.add(new Persona("DNI", "32345678", LocalDate.of(2008, 4, 4)));
		ps2.add(new Persona("DNI", "67211512", LocalDate.of(2007, 6, 12)));
		ps2.add(new Persona("AAA", "97832452", LocalDate.of(2005, 9, 29)));
		ps2.add(new Persona("DNI", "23456423", LocalDate.of(2000, 11, 30)));
		
		Collections.sort(ps2, new PersonaNacimientoDesendienteComparator());
		System.out.println(ps2);
		Collections.sort(ps2, new PersonaNacimientoAsendienteComparator());
		System.out.println(ps2);
	}



	public static void main(String[] args) {
		demoContiene();
		demoCountGreaterThan();
		sortDemo();

	}


}
class PersonaDocComparator implements Comparator<Persona> {
	@Override
	public int compare(Persona o1, Persona o2) {
		int result = o1.getDocTipom().compareTo(o2.getDocTipom());
		if (result == 0) { 
			return o1.getDocNum().compareTo(o2.getDocNum());
		} else {
			return result;
		}
	}
}
class PersonaNacimientoAsendienteComparator implements Comparator<Persona> {
	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());

	}
}
class PersonaNacimientoDesendienteComparator implements Comparator<Persona> {
	@Override
	public int compare(Persona o1, Persona o2) {
		return o2.getFechaNacimiento().compareTo(o1.getFechaNacimiento());
	}
}