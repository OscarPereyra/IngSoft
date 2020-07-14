package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import modelo.Producto;
import modelo.TestConexcion;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Color;

public class vender {

	private JFrame frame;
	private TestConexcion con = new TestConexcion();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vender window = new vender();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vender() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Venta de producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(126, 16, 225, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(30, 61, 69, 20);
		frame.getContentPane().add(lblCodigo);
		
		JFormattedTextField TextCodigo = new JFormattedTextField();
		TextCodigo.setBounds(96, 58, 59, 26);
		frame.getContentPane().add(TextCodigo);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(199, 61, 69, 20);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblErrorCantidad = new JLabel("");
		lblErrorCantidad.setForeground(Color.RED);
		lblErrorCantidad.setBounds(96, 97, 145, 20);
		frame.getContentPane().add(lblErrorCantidad);
		
		
		JFormattedTextField textCantidad = new JFormattedTextField();
		textCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					Integer i=Integer.parseInt(textCantidad.getText());
					lblErrorCantidad.setText("");
				}
				catch (NumberFormatException e1) {
					lblErrorCantidad.setText("Formato invalido");
				}
			}
		});
		textCantidad.setBounds(275, 58, 76, 26);
		frame.getContentPane().add(textCantidad);
		
		JButton btnVender = new JButton("Vender");
		btnVender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					venderProducto(Integer.parseInt(TextCodigo.getText()),Integer.parseInt(textCantidad.getText()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
					lblErrorCantidad.setText("Formato Invalido");
				} catch (SQLException e) {
					lblErrorCantidad.setText("Stock insuficiente");
					e.printStackTrace();
				}
			}
		});
		btnVender.setBounds(140, 145, 115, 29);
		frame.getContentPane().add(btnVender);
				
		
	}

	private void venderProducto (int codigo,int cantidad) throws SQLException {
		String queryCantActual = "select cantidad from bd_cyh.producto where idProducto = "  + codigo+";";
		ResultSet cantidadActual = con.update(queryCantActual);
		int resultCant = cantidadActual.getInt(1) - cantidad;
		if (resultCant >= cantidad){
			con.update("update bd_cyh.producto set cantidad = " + resultCant + " where idProducto=" + codigo + ";"); 
		}else {
			System.out.println("No hay stock suficiente");
		}
		String queryUpdateCant = "update bd_cyh.producto set cantidad = " + cantidad + " where idProducto=" + codigo + ";";  
		System.out.println(queryUpdateCant);
		con.creacion(queryUpdateCant);
	}
}
