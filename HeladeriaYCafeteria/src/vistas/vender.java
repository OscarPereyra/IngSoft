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
			public void keyPressed(KeyEvent arg0) {
				try {
					Double d=Double.parseDouble(textCantidad.getText());
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
				venderProducto(Integer.parseInt(TextCodigo.getText()),Integer.parseInt(textCantidad.getText()));
			}
		});
		btnVender.setBounds(140, 145, 115, 29);
		frame.getContentPane().add(btnVender);
				
		
	}

	private void venderProducto (int codigo,int cantidad) {
		String query = "update producto set cantidad = " + cantidad + " where idProducto=" + codigo + ";";  
		System.out.println(query);
		con.prueba(query);
	}
}
