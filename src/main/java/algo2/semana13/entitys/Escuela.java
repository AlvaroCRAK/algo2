package algo2.semana13.entitys;

enum Escuela2{
	Sistemas("Ingenieria de Sistemas"), Software("Ingenieria de Software");
	private String nombre;
	public String getNombre() {
		return nombre;
	}

	Escuela2(String nombre){
		this.nombre = nombre;
	}
}

public enum Escuela {
	
	Sistemas("Ing. de Sistemas"), Software("Ing. de Software");
	
	private String nombre;
	Escuela(String nombre){
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public String toString(){
		return nombre;
	}
	
	/*
	@Override
	public boolean equals(Object obj) {
		Escuela otro = (Escuela)obj;
		return nombre.equals(otro.nombre);
	} */
	
	
}