package algo2.semana09.generics;

import java.time.LocalDate;

public class Persona implements Comparable<Persona> {
	String docTipom; 
	String docNum;
	private LocalDate fechaNacimiento;
	Persona(){
		
	}
	Persona(String docTipom, String docNum, LocalDate fechaNacimiento){
		this.docNum = docNum;
		this.docTipom = docTipom;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDocTipom() {
		return docTipom;
	}
	public void setDocTipom(String docTipom) {
		this.docTipom = docTipom;
	}
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	
	@Override
	public String toString() {
		return "(" + docTipom + ", " + getDocNum() + ", " + getFechaNacimiento() + ")";
	}
    @Override
    public int compareTo(Persona o) {
        // Primero comparamos por docTipom
        int result = o.docTipom.compareTo(this.getDocTipom());
        
        // Si docTipom es igual, comparamos por docNum
        if (result == 0) {
            return o.docNum.compareTo(this.getDocNum());
        } else {
            return result;
        }
    }
	public int compareTo(Estudiante o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}