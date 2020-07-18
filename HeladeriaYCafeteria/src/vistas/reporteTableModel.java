package vistas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class reporteTableModel extends AbstractTableModel {
	ArrayList<ArrayList<String>> Registros;
	String[] columnas = {"Codigo", "Nombre","Cantidad","Precio","Subtotal"};
	Class[] clases = {Integer.class,String.class, Integer.class, Double.class, Double.class};

	public reporteTableModel(ArrayList<ArrayList<String>> datos) {
		this.Registros=datos;		
	}
	@Override
	public int getColumnCount() {
		return clases.length;
	}

	@Override
	public int getRowCount() {
		return Registros.size();
		}

	@Override
	public Object getValueAt(int row, int column) {
		ArrayList<String> registro = getRowAt(row);
        switch (column) {
            case 0:
                return registro.get(0);
            case 1:
                return registro.get(1);
            case 2:
                return registro.get(2);
            case 3:
                return registro.get(3);
            case 4:
                return registro.get(4);
            default:
                return "";
        }
	}
	
	public ArrayList<String> getRowAt(int posicion) {
        try {
        	return Registros.get(posicion);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
	public String getColumnName(int columna) {
		return columnas[columna];
	}
}
