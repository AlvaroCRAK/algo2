package algo2.semana12.gui.teoria.componentes.tables.alumno;

import java.util.List;

import javax.swing.table.AbstractTableModel;

class AlumnoTableModel extends AbstractTableModel {
	String[] colNames = {"Codigo", "Apellido", "Nombre",  "Promedio"};
	List<Alumno> data;
	AlumnoTableModel(List<Alumno> data){
		this.data = data;
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Alumno a = data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return a.getCodigo();
		case 1:
			return a.getApellido();
		case 2:
			return a.getNombre();
		case 3:
			return a.getPromedio();
		default:
			return null;
		}
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex < 1) return false;
		else return true;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Alumno a = data.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			break;
		case 1:
			a.setApellido(aValue.toString());
			break;
		case 2:
			a.setNombre(aValue.toString());
			break;
		case 3:
			a.setPromedio((Float)aValue);
			break;
		default:
			break;
		}
	}
}