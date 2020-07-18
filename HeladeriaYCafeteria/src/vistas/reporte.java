package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.BaseProductos;
import modelo.Producto;

import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class reporte extends JFrame {

	private JPanel contentPane;
	private BaseProductos db = new BaseProductos();
	private int montoTotal=0;
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
		JTable tableReporte = new JTable();
		tableReporte.setVisible(true);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 43, 428, 170);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tableReporte);
		
		JLabel lblReporte = new JLabel("Reporte");
		lblReporte.setBounds(175, 7, 69, 26);
		contentPane.add(lblReporte);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(104, 218, 69, 20);
		contentPane.add(lblTotal);
		
		JLabel lblTotalNum = new JLabel("");
		lblTotalNum.setBounds(151, 218, 69, 20);
		contentPane.add(lblTotalNum);
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				ResultSet ultimosIngresos = db.obtenerUltimosIngresados();
				ArrayList<ArrayList<String>> Registros= new ArrayList<ArrayList<String>>();
		        try {

					while(ultimosIngresos.next()){
						ArrayList<String> Registro= new ArrayList<String>();
						Registro.add(Integer.toString(ultimosIngresos.getInt(1)));
						Registro.add(ultimosIngresos.getString(2));
						Registro.add(Integer.toString(ultimosIngresos.getInt(3)));
						Registro.add(Double.toString(ultimosIngresos.getDouble(4)));
						Registro.add(Double.toString(ultimosIngresos.getInt(3)*ultimosIngresos.getDouble(4)));
						Registros.add(Registro);
						montoTotal+=ultimosIngresos.getInt(3)*ultimosIngresos.getDouble(4);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}         
		        try {
					ultimosIngresos.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		        reporteTableModel mod = new reporteTableModel(Registros);
				tableReporte.setModel(mod);
				tableReporte.revalidate();
		        tableReporte.repaint();
		        tableReporte.clearSelection();
		        mod.fireTableDataChanged();
		        lblTotalNum.setText(Integer.toString(montoTotal));
			}
		});
		
	}
}
