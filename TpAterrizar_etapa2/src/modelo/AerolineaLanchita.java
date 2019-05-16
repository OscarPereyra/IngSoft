package modelo;

//import java.lang.reflect.Array;
import java.util.ArrayList;

public interface AerolineaLanchita {
	public double porcentajeImpuestos = 0.15;
	public ArrayList<String> asientosDisponibles(String origen,String fechaSalida,String horaSalida,String destino,String fechaLlegada,String horaLlegada);
	public void comprar(String codigoAsiento);
}