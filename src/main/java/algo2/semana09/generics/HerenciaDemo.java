package algo2.semana09.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HerenciaDemo {
	static void procesar(List<Persona> personas) {
	}

	static void procesar(Persona[] personas) {
	}

	public static void demoConArray() {
		Persona[] ps = { new Persona(), new Persona(), new Persona() };
		procesar(ps);
		Estudiante[] es = { new Estudiante(""), new Estudiante(""), new Estudiante("") };
		procesar(es);
	}

	private static void demoConList() {
		List<Persona> ps = List.of(new Persona(), new Persona(), new Persona());
		procesar(ps); //OK.
		List<Estudiante> es = List.of(new Estudiante(""), new Estudiante(""), new Estudiante(""));
		//procesar(es); // Error de compilacion, como resolverlo?
	}
	
	static <T extends Persona> boolean esSubLista(List<T> lista1, List<T> lista2) {
		return true;
	}

	static boolean esSubLista2(List<? extends Persona> lista1, List<? extends Persona> lista2) {
		return true;
	}

	public static void demoDiscusion1() {
		List<Persona> ps = List.of(new Persona(), new Persona(), new Persona());
		List<Estudiante> es = List.of(new Estudiante(""), new Estudiante(""), new Estudiante(""));
		esSubLista(ps, ps);
		esSubLista(es, es);
		// esSubLista(ps, es); //Error de compilacion

		esSubLista2(ps, ps);
		esSubLista2(es, es);
		esSubLista2(ps, es); // OK

	}

	<T extends Persona> void procesar(List<T> personas, T elem) {
		//personas.add(new Persona()); //Error de compilacion
		//personas.add(new Estudiante("")); //Error de compilacion....
		personas.add(elem); // Ok
		personas.add(null); // Ok
	}

	public static void agregarEstudiantes(List<? super Estudiante> lista, int cant) {
		for (int i = 1; i <= cant; i++) {
			lista.add(new Estudiante(""));
		}
	}

	private static void demoLowerBound() {
		List<Persona> ps = List.of(new Persona(), new Persona(), new Persona());
		agregarEstudiantes(ps, 5);
		List<Estudiante> es = List.of(new Estudiante(""), new Estudiante(""), new Estudiante(""));
		agregarEstudiantes(es, 5);
		List<Object> os = List.of(new Object(), new Object(), new Estudiante(""));
		agregarEstudiantes(os, 5);
	}

	public static Object getSuperEstudiantes(List<? super Estudiante> lista, int index) {
		return lista.get(index);
	}
	
	public static void demoUpperBundGet() {
		List<Estudiante> es = List.of(new Estudiante(""), new Estudiante(""), new Estudiante(""));
		System.out.println(getSuperEstudiantes(es, 1));
		List<Persona> ps = List.of(new Persona(), new Persona(), new Estudiante(""));
		System.out.println(getSuperEstudiantes(ps, 1));
	}
	
	public static void demoCollectionsCopy() {
		List<Estudiante> es = List.of(new Estudiante(""), new Estudiante(""), new Estudiante(""));
		List<Persona> ps = new ArrayList<Persona>();
		ps.add(null);
		ps.add(null);
		ps.add(null);
		Collections.copy(ps, es);
		System.out.println(ps);
		
		List<Estudiante> es2 = new ArrayList<Estudiante>();
		es2.add(null);
		es2.add(null);
		es2.add(null);
		Collections.copy(es2, es);
		System.out.println(es2);
	}
	
	public static void demoCollectionsSort() {		
		List<Estudiante> es = new ArrayList<Estudiante>();
		es.add(new Estudiante("Perez"));
		es.add(new Estudiante("Diaz"));
		es.add(new Estudiante("Guzman"));
		System.out.println(es);
		Collections.sort(es);
		System.out.println(es);
	}
	


	public static void main(String[] args) {
		demoCollectionsSort();
	}

}