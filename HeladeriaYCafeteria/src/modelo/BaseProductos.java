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
			//System.out.println(rs.getInt(1));
			return rs;
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
		return null;	
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
		ResultSet rs = con.consulta("select cantidad from producto where idProducto = "  + codigo+";");		
		return  rs.next();
	}
	public void insertarProducto(Producto uno) {
		String query = " insert into producto (idProducto,nombre,cantidad,precio,categoria)" + " values (" + uno.getCodigo() + ",'" + uno.getNombre() + "'," + uno.getCantidad() + "," + uno.getPrecio() + ",'" + uno.getCategoria() + "');";
		//System.out.println(query);
		con.actualizacion(query);
	}
	public void actualizarProducto(Producto uno) {
		String query = "update producto set cantidad = "+ uno.getCantidad() +" , precio = "+ uno.getPrecio() +" where idProducto ="+ uno.getCodigo() +";";
		//System.out.println(query);
		con.actualizacion(query);
	}
	public void actualizarCantidadProducto(int codigo, int cantidad) {
		String query = "update producto set cantidad = "+ cantidad +" where idProducto ="+ codigo +";";
		//System.out.println(query);
		con.actualizacion(query);
	}
	public int cantidadProducto(int codigo) {
		String queryCantidad= "select cantidad from producto where idProducto = "  + codigo+";";
		ResultSet cantidadActual = con.consulta(queryCantidad);
		try {
			return cantidadActual.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
}	