import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexcion {
	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
			
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM producto");
			while (rs.next()) {
				
				int idProducto = rs.getInt(1);
				String nombre = rs.getString(2);
				int cantidad = rs.getInt(3);
				double precio = rs.getDouble(4);
				String categoria = rs.getString(5);
				System.out.println(idProducto  + " - " + nombre + " - " + cantidad + " - " + precio +" - "+categoria );
			}
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
	}
}
