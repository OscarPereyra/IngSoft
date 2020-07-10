package vistas;

import java.awt.EventQueue;

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
import javax.swing.JTextField;

public class ventana {

	private JFrame frmHeladeriaYConfiteria;
	private JTextField textCodigo;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		textCantidad.setBounds(276, 36, 32, 26);
		frmHeladeriaYConfiteria.getContentPane().add(textCantidad);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 75, 69, 20);
		frmHeladeriaYConfiteria.getContentPane().add(lblPrecio);
		
		JFormattedTextField textPrecio = new JFormattedTextField();
		textPrecio.setBounds(79, 75, 63, 20);
		frmHeladeriaYConfiteria.getContentPane().add(textPrecio);
		
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
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				registrar(textNombre.getText(),textPrecio.getText(),textCantidad.getValue().toString(),comboCategoria.getSelectedItem().toString());
			}
		});
		btnRegistrar.setBounds(146, 203, 115, 29);
		frmHeladeriaYConfiteria.getContentPane().add(btnRegistrar);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(79, 111, 86, 20);
		frmHeladeriaYConfiteria.getContentPane().add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 114, 46, 14);
		frmHeladeriaYConfiteria.getContentPane().add(lblCodigo);
	}
	
	private void registrar (String nombre,String precio,String cantidad,String categoria) {
		System.out.println(nombre + precio + cantidad + categoria);
	}
}
