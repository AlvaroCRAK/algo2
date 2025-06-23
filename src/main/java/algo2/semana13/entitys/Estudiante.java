package algo2.semana13.entitys;

public class Estudiante {
	private String codigo;
	private String nombre;
	private double promedio;
	private Escuela escuela;
	public Estudiante(String codigo, String nombre, double promedio, Escuela escuela) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.promedio = promedio;
		this.escuela = escuela;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public String toString() {
		return String.format(
				"codig=%s, nombre=%s, promedio=%f, escuela=%s", 
				codigo, nombre, promedio, escuela);
	}
	public double getPromedio() {
		return promedio;
	}
	public Escuela getEscuela() {
		return escuela;
	}
	public void setPromedio(double p) {
		if (p < 0 || p > 20)
			throw new RuntimeException("La nota esta fuera del rango");
		promedio = p;
	}

}