package modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class BaseProductos {

	public ResultSet consulta(String query) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;			
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();	
			rs = stm.executeQuery(query);
			return rs;
		} catch (SQLException e) {
		}			return null;
	}	
	
	public ResultSet creacionOriginal(String query) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();			
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
		}finally {
			try {
				if (rs != null) {
					rs.close();	
				}
				if (stm != null) {
					stm.close();	
				}
				if (cn != null) {
					cn.close();	
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rs;
	}
	public void actualizacion(String query) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;		
		cn = conexion.conectar();
		try {
			stm = cn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		try {
			stm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean esProducto(int codigo) throws SQLException {
		ResultSet rs = consulta("select cantidad from bd_cyh.producto where idProducto = "  + codigo+";");
		return  rs.next();
	}
	public void insertarProducto(Producto uno) {
		String query = " insert into bd_cyh.producto (idProducto,nombre,cantidad,precio,categoria,ultima_fecha_ingreso)" + " values (" + uno.getCodigo() + ",'" + uno.getNombre() + "'," + uno.getCantidad() + "," + uno.getPrecio() + ",'" + uno.getCategoria() + "', NOW());";
		//System.out.println(query);
		actualizacion(query);
	}
	public int cantidadProducto(int codigo) {
		String queryCantidad= "select cantidad from bd_cyh.producto where idProducto = "  + codigo+";";
		ResultSet cantidadActual = consulta(queryCantidad);
		try {
			cantidadActual.next();
			return cantidadActual.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public String obtenerFechaReciente() throws SQLException {
		String queryFechaReciente= "select max(ultima_fecha_ingreso) from bd_cyh.producto ;";
		ResultSet fechareciente = consulta(queryFechaReciente);		
		return fechareciente.getString(1);
	}
	public void actualizarProducto(Producto uno) {
		int cantProdTotal= uno.getCantidad() + cantidadProducto(Integer.parseInt(uno.getCodigo()));
		String query = "update bd_cyh.producto set cantidad = "+ cantProdTotal +" , precio = "+ uno.getPrecio() +", ultima_fecha_ingreso = NOW() where idProducto ="+ uno.getCodigo() +";";
		//System.out.println(query);
		actualizacion(query);
	}
	public void actualizarCantidadProducto(int codigo, int cantidad) {
		int cantProdTotal= cantidadProducto(codigo)-cantidad ;
		String query = "update bd_cyh.producto set cantidad = "+ cantProdTotal +" where idProducto ="+ codigo +";";
		//System.out.println(query);
		actualizacion(query);
	}

	public ResultSet obtenerUltimosIngresados() {
		String queryUltimosIngresos= "select * from bd_cyh.producto where ultima_fecha_ingreso = curdate();";
		// String queryUltimosIngresos= "select * from bd_cyh.producto where ultima_fecha_ingreso = "+ obtenerFechaReciente() +";";
		ResultSet ultimosIngresos = consulta(queryUltimosIngresos);
		
		return ultimosIngresos;		
	}
	public ResultSet obtenerUltimosIngresadosPorCategoria(String categoria) {
		String queryUltimosIngresos= "select * from bd_cyh.producto where (ultima_fecha_ingreso = curdate()) and categoria = "+ categoria +" ;";
		//String queryUltimosIngresos= "select * from bd_cyh.producto where (ultima_fecha_ingreso = "+ obtenerFechaReciente() +") and categoria = "+ categoria +" ;";
		ResultSet ultimosIngresos = consulta(queryUltimosIngresos);
		return ultimosIngresos;		
	}
	public int costoTotal() {
		String queryCosto= "select sum(precio) from bd_cyh.producto;";
		ResultSet costo = consulta(queryCosto);
		try {
			return costo.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int costoTotalUltimosIngresos() {
		String queryCosto= "select sum(precio) from bd_cyh.producto where ultima_fecha_ingreso = max(ultima_fecha_ingreso);";
		ResultSet costo = consulta(queryCosto);
		try {
			return costo.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}	