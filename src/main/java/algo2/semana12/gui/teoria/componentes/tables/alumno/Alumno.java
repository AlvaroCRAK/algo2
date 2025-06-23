package algo2.semana12.gui.teoria.componentes.tables.alumno;

class Alumno{
	private String codigo;
	private String apellido;
	private String nombre;
	private float promedio;
	public Alumno(String codigo, String apellido, String nombre, float promedio) {
		this.codigo = codigo;
		this.apellido = apellido;
		this.nombre = nombre;
		this.promedio = promedio;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPromedio() {
		return promedio;
	}
	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
	public String getCodigo() {
		return codigo;
	}
	
}