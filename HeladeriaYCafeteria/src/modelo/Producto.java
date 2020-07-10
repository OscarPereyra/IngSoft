package modelo;

public class Producto {
	String codigo;
	String nombre;
	String categoria;
	Double precio;
	Integer cantidad;
	
	
	public Producto(String codigo, String nombre, String categoria, Double precio, Integer cantidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.cantidad = cantidad;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
