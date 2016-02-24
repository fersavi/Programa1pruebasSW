package com.udea.edu.app;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Mean_Deviation extends JFrame {
	private JTable table;
	private final Action action = new SwingAction();
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mean_Deviation frame = new Mean_Deviation();
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
	public Mean_Deviation() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 373);
		
		JLabel test = new JLabel("Test");
		
		JLabel lblNewLabel = new JLabel("Expected Value");
		
		JLabel lblNewLabel_1 = new JLabel("Actual Value");
		
		
		//Boton Seleccionar
		JButton btnNewButton = new JButton("Seleccionar archivo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser archivoSeleccion;
			
			    archivoSeleccion = new JFileChooser(); 
			    archivoSeleccion.setCurrentDirectory(new java.io.File("."));
			    archivoSeleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    archivoSeleccion.setAcceptAllFileFilterUsed(false);
	  
			    if (archivoSeleccion.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
			       String nombreArchivo = archivoSeleccion.getSelectedFile().getAbsolutePath();
		
			       Calculadora cal = new Calculadora();
			       try {
					cal.leerArchivo(nombreArchivo);
					Double media= cal.calcularMedia();
					Double desviacion= cal.calcularDesviacion();
					table_1.setValueAt(archivoSeleccion.getSelectedFile().getName(), 1, 0);
					table_1.setValueAt(media, 1, 1);
					table_1.setValueAt(desviacion, 1, 2);
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			       
			      }
			    else {
			      System.out.println("No Se seleccionó archivo ");
			      }
				
				
			}
		});
		
		
		btnNewButton.setAction(action);
		// Boton para archivos de prueba
				JButton btnCalcularArchivosPrueba = new JButton("Calcular Archivos Prueba");
				btnCalcularArchivosPrueba.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Calculadora calculadora = new Calculadora();
						Double media;
						Double desviacion;
						
						try {
							calculadora.leerArchivo("src/resource/EstimateProxySize.txt");
							media= calculadora.calcularMedia();
							desviacion= calculadora.calcularDesviacion();
							table.setValueAt(media, 1, 3);
							table.setValueAt(desviacion, 1, 4);
							
							calculadora.leerArchivo("src/resource/DevelopmentHours.txt");
							media= calculadora.calcularMedia();
							desviacion= calculadora.calcularDesviacion();
							table.setValueAt(media, 2, 3);
							table.setValueAt(desviacion, 2, 4);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
		
				
	
		//Tabla archivo Test
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null,  "Mean","Std Dev",  "Mean","Std Dev"},
					{"Table 1: Column 1", "550.6", "572.03", null, null},
					{"Table 1: Column 2", "60.32", "62.26", null, null},
				},
				new String[] {
					"Test", "Expected Value STD", "Expected Value Mean", "Actual Value Dev", "Actual Value Mean"
				}
			));	
			
				
				
		//tabla de seleccion
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null,  "Mean","Std Dev"},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_1.setToolTipText("");
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	
		
		
		JLabel label = new JLabel("Test");
		JLabel label_2 = new JLabel("Actual Value");
		JSeparator separator = new JSeparator();
		JLabel lblNewLabel_2 = new JLabel("Calcule aqui seleccionando el archivo");
	
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(test, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(75)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(76))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(68)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(198, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(190))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(112)
					.addComponent(label)
					.addGap(144)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(181, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addContainerGap(309, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(181, Short.MAX_VALUE)
					.addComponent(btnCalcularArchivosPrueba)
					.addGap(177))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(test, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(btnCalcularArchivosPrueba)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(25))
		);
		getContentPane().setLayout(groupLayout);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Seleccionar Archivo");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
