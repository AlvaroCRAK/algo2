package algo2.semana13.entitys;

import java.util.Arrays;
import java.util.List;

public class EstudiantesFactoryMock {
	static final Escuela sist = Escuela.Sistemas; //new Escuela("Sistemas");
	static final Escuela soft = Escuela.Software; // new Escuela("Software");
	public static final Estudiante e1 = new Estudiante("12345678", "Angel Ungenio", 8, sist);
	public static final Estudiante e2 = new Estudiante("22345678", "Beto Dosantos", 9, soft);
	public static final Estudiante e3 = new Estudiante("32345678", "Carlos Trelles", 10, sist);
	public static final Estudiante e4 = new Estudiante("42345678", "Daniel Cuadros", 11, soft);
	public static final Estudiante e5 = new Estudiante("52345678", "Erick Quinto", 12, sist);
	public static final Estudiante e6 = new Estudiante("62345678", "Franco Sexto", 16, soft);
	public static final Estudiante e7 = new Estudiante("72345678", "Gino Septimo", 18, sist);

	List<Estudiante> estudiantes;
	public static List<Estudiante> getEstudiantes () {
		return Arrays.asList(
				e1, e2, e3, e4, e5, e6, e7
				);
	}	

}
