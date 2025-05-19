package algo2.semana09.generics;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LimitacionesDemo {
	private void usingPrimitive() {
		// Map<int, String> mapa = new HashMap<>(); //Error de compilacion
		Map<Integer, String> mapa = new HashMap<>();
		System.err.println(mapa);
	}

	<E> void add(List<E> list) {
		//E elem = new E(); // Error de compilacion
		//list.add(elem);
	}
	<E> void add(List<E> list, Class<E> cls) {
		E elem= null;
		try {
			elem = cls.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Ok, or cls.getDeclaredConstructor().newInstance()
		list.add(elem);
	}
	private void addDemo() {
		ArrayList<String> lista = new ArrayList<>();
		add(lista, String.class);	
		add(lista, String.class);
		add(lista, String.class);
		System.out.println(lista);
	}
	
	class MobileDevice<T> {
		//private static T os; //No funciona
		private T os;  //Ok
	}
	public void print(Set<String> strSet) { }
	public void print(List<Integer> intSet) { } //Error, no es overload, debido a erasure.
	
	
	public static void main(String[] args) {
		LimitacionesDemo lim = new LimitacionesDemo();
		lim.addDemo();
		lim.usingPrimitive();
	}
}
