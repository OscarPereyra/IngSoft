package vistas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class reporteTableModel extends AbstractTableModel {
	ArrayList<String> Registros;
	String[] columnas = {"Codigo", "Nombre","Cantidad","Precio","Subtotal"};
	Class[] clases = {Integer.class,String.class, Integer.class, Double.class, Double.class};

	public reporteTableModel(ArrayList<String> datos) {
		this.Registros=datos;
		
	}
	@Override
	public int getColumnCount() {
		
		return 0;
	}

	@Override
	public int getRowCount() {
		
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		
		return null;
	}
	
	

}
