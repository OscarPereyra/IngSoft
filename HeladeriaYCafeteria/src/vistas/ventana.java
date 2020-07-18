package vistas;

import java.awt.EventQueue;
import modelo.Producto;
import modelo.BaseProductos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventana {

	private JFrame frmHeladeriaYConfiteria;
	private JTextField textCodigo;
	private BaseProductos db = new BaseProductos();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana window = new ventana();
					window.frmHeladeriaYConfiteria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ventana() {
		initialize();
	}

	private void initialize() {
		frmHeladeriaYConfiteria = new JFrame();
		frmHeladeriaYConfiteria.setTitle("Heladeria y confiteria");
		frmHeladeriaYConfiteria.setBounds(100, 100, 450, 300);
		frmHeladeriaYConfiteria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHeladeriaYConfiteria.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingreso de productos");
		lblNewLabel.setBounds(0, 0, 428, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmHeladeriaYConfiteria.getContentPane().add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 39, 69, 20);
		frmHeladeriaYConfiteria.getContentPane().add(lblNombre);
		
		JFormattedTextField textNombre = new JFormattedTextField();
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setBounds(79, 41, 109, 20);
		frmHeladeriaYConfiteria.getContentPane().add(textNombre);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(203, 39, 69, 20);
		frmHeladeriaYConfiteria.getContentPane().add(lblCantidad);
		
		JSpinner textCantidad = new JSpinner();
		textCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		textCantidad.setBounds(276, 36, 115, 26);
		frmHeladeriaYConfiteria.getContentPane().add(textCantidad);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 75, 69, 20);
		frmHeladeriaYConfiteria.getContentPane().add(lblPrecio);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(10, 155, 82, 20);
		frmHeladeriaYConfiteria.getContentPane().add(lblCategoria);
		
		JComboBox comboCategoria = new JComboBox();
		comboCategoria.setBackground(SystemColor.activeCaption);
		comboCategoria.setMaximumRowCount(2);
		comboCategoria.setModel(new DefaultComboBoxModel(new String[] {"Heladeria", "Cafeteria"}));
		comboCategoria.setSelectedIndex(1);
		comboCategoria.setBounds(79, 152, 99, 26);
		frmHeladeriaYConfiteria.getContentPane().add(comboCategoria);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(79, 111, 109, 20);
		frmHeladeriaYConfiteria.getContentPane().add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 114, 46, 14);
		frmHeladeriaYConfiteria.getContentPane().add(lblCodigo);
		
		JLabel lblErrorPrecio = new JLabel("");
		lblErrorPrecio.setForeground(Color.RED);
		lblErrorPrecio.setBounds(203, 78, 151, 14);
		frmHeladeriaYConfiteria.getContentPane().add(lblErrorPrecio);
		
		JTextField textPrecio = new JTextField();
		textPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					Double d=Double.parseDouble(textPrecio.getText());
					lblErrorPrecio.setText("");
				}
				catch (NumberFormatException e1) {
					lblErrorPrecio.setText("Formato invalido");
				}
			}
		});
		textPrecio.setBounds(79, 75, 109, 20);
		frmHeladeriaYConfiteria.getContentPane().add(textPrecio);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
						if(db.esProducto(Integer.parseInt(textCodigo.getText())))
					{
						actualizarInformacion(Double.parseDouble(textPrecio.getText()),textCodigo.getText(),Integer.parseInt(textCantidad.getValue().toString()));
					}else{
						registrarNuevoProducto(textNombre.getText(),textPrecio.getText(),textCodigo.getText(),textCantidad.getValue().toString(),comboCategoria.getSelectedItem().toString());
					}
						
				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnRegistrar.setBounds(48, 203, 129, 29);
		frmHeladeriaYConfiteria.getContentPane().add(btnRegistrar);
		
		JButton btnGenerarReporte = new JButton("Generar reporte");
		btnGenerarReporte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reporte ventanaReporte = new reporte();
				ventanaReporte.setVisible(true);
			}
		});
		btnGenerarReporte.setBounds(240, 203, 151, 29);
		frmHeladeriaYConfiteria.getContentPane().add(btnGenerarReporte);
	}
	
	protected void actualizarInformacion(Double precio,String codigo,int cantidad) {
		Producto uno = new Producto(codigo," "," ",precio,cantidad);
		db.actualizarProducto(uno);
	}

	private void registrarNuevoProducto (String nombre,String precio,String codigo,String cantidad,String categoria) {
		Producto uno = new Producto(codigo,nombre,categoria,Double.parseDouble(precio),Integer.parseInt(cantidad));
		db.insertarProducto(uno);
	}
}
