package algo2.semana09.generics;

public class Estudiante extends Persona {
	private String nombre;
	
 
	public Estudiante(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public int compareTo(Estudiante o) {
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + "]";
	}
	
	
}