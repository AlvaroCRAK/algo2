package algo2.semana09.generics;

public class Cat extends Animal implements Comparable<Cat> {
	private String nombre;
	
 
	public Cat(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	protected void hacerSonido() {
		System.out.println("miao miao");
	}
	
	@Override
	public int compareTo(Cat o) {
		return this.nombre.compareTo(o.nombre);
	}
}