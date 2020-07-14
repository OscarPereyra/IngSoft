package modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class TestConexcion {
	public ResultSet update(String query) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
			
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();	

			rs = stm.executeQuery(query);
			
			System.out.println(rs.getInt(1));

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
	
	public ResultSet creacion(String query) {
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
}