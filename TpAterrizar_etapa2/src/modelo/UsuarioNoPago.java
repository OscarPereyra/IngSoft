package modelo;

public class UsuarioNoPago extends Usuario {
	private String nombre;
	private String apellido;
	private int DNI;
	public UsuarioNoPago() {
		
	}
	@Override
	public boolean esVip() {
		return false;
	}
	@Override
	public boolean esPago() {
		return false;
	}
	@Override
	public void comprar(Double monto) {
	}
}
