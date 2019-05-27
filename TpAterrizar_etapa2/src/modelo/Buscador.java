package modelo;

import java.util.ArrayList;
//Datos de asientos = [Codigo asiento,precio asiento,clase(T-E-P),ubicacion(V-C-P),estado(R-D)]

public class Buscador {
		public ArrayList<ArrayList<String>> busqueda(String origen,String fechaSalida, String horaSalida,String destino,String fechaLlegada,String horaLlegada,String clase,String ubicacion) {
		AerolineaLanchita aerolinea = new  AerolineaLanchita();
		ArrayList<Asiento> asientosDisp = new ArrayList<Asiento>();
		ArrayList<ArrayList<String>> resultadoBusqueda = new ArrayList<ArrayList<String>>();
		resultadoBusqueda = aerolinea.asientosDisponibles(origen,fechaSalida,horaSalida,destino,fechaLlegada,horaLlegada);
		resultadoBusqueda.forEach(asiento -> asientosDisp.add(parsearAsiento(asiento)));
		asientosDisp.forEach(asiento -> actualizarPrecioTotal(asiento, aerolinea));
		return resultadoBusqueda;
	}
	
	private Asiento parsearAsiento(ArrayList<String> asiento){
		String codigoAsiento = asiento.get(0);
		Double precio = Double.parseDouble(asiento.get(1));
		ClaseAsiento clase = null;
		String ubicacion = asiento.get(3);
		String estado = asiento.get(4);
		switch (asiento.get(2)){
			case "T":
				clase = ClaseAsiento.T;
				break;
			case "E":
				clase = ClaseAsiento.E;
				break;
			case "P":
				clase = ClaseAsiento.P;
				break;
		}
		return new Asiento(codigoAsiento,precio,clase,ubicacion,estado);
	}
	
	private boolean esSuperOferta(Asiento asiento, AerolineaLanchita aerolinea) {
		return ((asiento.getClase().equals(ClaseAsiento.P) && asiento.getPrecio()<8000)||(asiento.getClase().equals(ClaseAsiento.E) && asiento.getPrecio()<4000));
	}
	
	private void actualizarPrecioTotal(Asiento asiento,AerolineaLanchita aerolinea) {
		asiento.setPrecio(asiento.getPrecio()*aerolinea.getImpuesto());
	}
}
