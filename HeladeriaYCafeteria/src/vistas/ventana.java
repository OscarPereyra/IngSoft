package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class ventana {

	private JFrame frmHeladeriaYConfiteria;

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
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 39, 69, 20);
		frmHeladeriaYConfiteria.getContentPane().add(lblNewLabel_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setBounds(79, 41, 109, 20);
		frmHeladeriaYConfiteria.getContentPane().add(formattedTextField);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setBounds(203, 39, 69, 20);
		frmHeladeriaYConfiteria.getContentPane().add(lblNewLabel_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(276, 36, 32, 26);
		frmHeladeriaYConfiteria.getContentPane().add(spinner);
		
		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(10, 75, 69, 20);
		frmHeladeriaYConfiteria.getContentPane().add(lblNewLabel_3);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(79, 75, 63, 20);
		frmHeladeriaYConfiteria.getContentPane().add(formattedTextField_1);
		
		JLabel lblNewLabel_4 = new JLabel("Categoria:");
		lblNewLabel_4.setBounds(10, 111, 82, 20);
		frmHeladeriaYConfiteria.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(145, 169, 115, 29);
		frmHeladeriaYConfiteria.getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.activeCaption);
		comboBox.setMaximumRowCount(2);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Heladeria", "Cafeteria"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(89, 111, 99, 26);
		frmHeladeriaYConfiteria.getContentPane().add(comboBox);
	}
}
