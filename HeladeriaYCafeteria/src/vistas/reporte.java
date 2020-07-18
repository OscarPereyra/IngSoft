package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.BaseProductos;

import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Component;
import javax.swing.Box;

public class reporte extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private BaseProductos db = new BaseProductos();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reporte frame = new reporte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public reporte() {
		setTitle("Reporte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		contentPane.setLayout(null);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ResultSet ultimosIngresos = db.obtenerUltimosIngresados();
				DefaultTableModel modelo = new DefaultTableModel();
				table = new JTable(modelo);
				contentPane.add(table, BorderLayout.CENTER);
				modelo.addColumn("CODIGO");
		        modelo.addColumn("NOMBRE");
		        modelo.addColumn("CANTIDAD");
		        modelo.addColumn("PRECIO");
		        modelo.addColumn("CATEGORIA");
		        modelo.addColumn("FECHA DE INGRESO");
		        try {
					while(ultimosIngresos.next()){
						System.out.println(ultimosIngresos.getInt(1));
					    Object []ob=new Object[6];
					    ob[0]=(ultimosIngresos.getInt(1));
					    ob[1]=(ultimosIngresos.getString(2));
					    ob[2]=(ultimosIngresos.getString(3));
					    ob[3]=(ultimosIngresos.getString(4));
					    ob[4]=(ultimosIngresos.getString(5));
					    ob[5]=(ultimosIngresos.getString(6));
					    modelo.addRow(ob);
					    ob=null;
					 }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}         
		        try {
					ultimosIngresos.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
}
