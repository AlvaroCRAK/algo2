package algo2.semana11.persistencia;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class EsSerializable implements Serializable{
}
class Data implements Serializable{
	private String seraSerializado;
	private transient String noSeraSerializado1;
	private transient int noSeraSerializado2=2;
	private EsSerializable seraSerializado2 = new EsSerializable();
	
	public String getNoSeraSerializado1() {
		return noSeraSerializado1;
	}

	public int getNoSeraSerializado2() {
		return noSeraSerializado2;
	}
	public EsSerializable getSeraSerializado2() {
		return seraSerializado2;
	}

	public Data(String seraSerializado, String noSeraSerializado) {
		this.seraSerializado = seraSerializado;
		this.noSeraSerializado1 = noSeraSerializado;
		this.noSeraSerializado2 = 10;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		Data otro = (Data)obj;
		return seraSerializado.equals(otro.seraSerializado);
	}
}