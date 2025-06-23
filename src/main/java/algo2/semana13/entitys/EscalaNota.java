package algo2.semana13.entitys;

public enum EscalaNota{
	MuyBaja, Baja, Regular, Alta, MuyAlta;
	public static EscalaNota evaluar(double nota){
		if (nota < 9)
			return MuyBaja;
		else if (nota < 10.5)
			return Baja;
		else if (nota < 13)
			return Regular;
		else if (nota < 16)
			return Alta;
		return MuyAlta;
	}
}