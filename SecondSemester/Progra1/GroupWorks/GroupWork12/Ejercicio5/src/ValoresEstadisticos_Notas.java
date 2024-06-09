/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ValoresEstadisticos_Notas extends JFrame {
	JTextField campoCantidadNotas;
	JButton botonObtener;
	// Tabla notas
	DefaultTableModel modeloNotas = new DefaultTableModel();
	Object notas[];
	JTable tablaNotas = new JTable(modeloNotas);
	// Tabla estadisticas
	Object[] nombreColumnasEstadistica = {
		"Rango",
		"ni",
		"fi",
		"pi",
		"Ni",
		"Fi",
		"Pi"
	};
	DefaultTableModel modeloEstadisticas = new DefaultTableModel(nombreColumnasEstadistica, 5);
	JTable tablaEstadisticas = new JTable(modeloEstadisticas);
	JScrollPane scrollTablaNotas, scrollTablaEstadisticas;


	ValoresEstadisticos_Notas(){
		
		// Ingreso de la cantidad de notas a registrar
		JPanel panelIngreso = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
		JLabel etiquetaIngreso = new JLabel("Ingrese cantidad de notas");
		campoCantidadNotas = new JTextField(3);
		panelIngreso.add(etiquetaIngreso);
		panelIngreso.add(campoCantidadNotas);

		// Boton de obtener estadisticas
		botonObtener = new JButton("Obtener estadisticas");
		panelIngreso.add(botonObtener);

		add(panelIngreso, BorderLayout.NORTH);

		// Tablas
		scrollTablaNotas = new JScrollPane(tablaNotas, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tablaNotas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollTablaNotas.setPreferredSize(new Dimension(78, 10)); // Evita que la tabla sea de mayor ancho con lineas exteriores que chocan con los componentes
		scrollTablaEstadisticas = new JScrollPane(tablaEstadisticas);
		// Esconder las tablas hasta que se ingresen notas
		scrollTablaNotas.setVisible(false);
		scrollTablaEstadisticas.setVisible(false);
		add(scrollTablaNotas, BorderLayout.WEST);
		add(scrollTablaEstadisticas, BorderLayout.EAST);


		// Manejadores
		ManejadorIngreso manejador = new ManejadorIngreso();
		campoCantidadNotas.addActionListener(manejador);
		botonObtener.addActionListener(manejador);

		// Definir el rango de notas
		modeloEstadisticas.setValueAt("0-5", 0, 0);
		modeloEstadisticas.setValueAt("5-10", 1, 0);
		modeloEstadisticas.setValueAt("10-14", 2, 0);
		modeloEstadisticas.setValueAt("14-17", 3, 0);
		modeloEstadisticas.setValueAt("17-20", 4, 0);

		setTitle("Estadisticas de frecuencia de calificaciones");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(600, 400);
	}

	private class ManejadorIngreso implements ActionListener{
		DecimalFormat formato = new DecimalFormat("0.000");
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource() == campoCantidadNotas){
				try{
					int numeroNotas = Integer.parseInt(campoCantidadNotas.getText());
					crearTabla(numeroNotas);	
				}
				catch(NumberFormatException excepcion){
					JOptionPane.showMessageDialog(null, "Ingrese una cantidad de notas numerica", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
					restablecerCampoIngreso();
				}
				catch(Exception excepcion){
					JOptionPane.showMessageDialog(null, "Ingrese una cantidad de notas mayor a 0", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
					restablecerCampoIngreso();
				}
			}
			else if(evento.getSource() == botonObtener){
				try{
					scrollTablaEstadisticas.setVisible(true);
					revalidate();
					double notas[] = generarArregloNotas(modeloNotas.getRowCount());
					llenarTabla(notas);
				}
				catch(NumberFormatException excepcion){
					JOptionPane.showMessageDialog(null, "Los valores de las notas deben ser numericos", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception exepcion){
					JOptionPane.showMessageDialog(null, exepcion.getMessage(), "Error de ingreso", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		void crearTabla(int numeroNotas) throws Exception {
			if(numeroNotas <= 0){
				throw new Exception();
			}
			else {
				modeloNotas.addColumn("Notas");
				modeloNotas.setColumnCount(1);
				modeloNotas.setRowCount(numeroNotas);
				notas = new Object[numeroNotas];
				scrollTablaNotas.setVisible(true);
				// Revalidate dice al manejador de esquemas que recalcule el esquema, para mostrar o eliminar nuevos componentes
				revalidate();
			}
		}

		void restablecerCampoIngreso(){
			campoCantidadNotas.setText("");
			campoCantidadNotas.requestFocus();
		}

		double[] generarArregloNotas(int cantidadNotas) throws Exception{
			double[] arreglo = new double[cantidadNotas];
			for(int i = 0; i < cantidadNotas; i++){
				if(modeloNotas.getValueAt(i, 0) == null){
					throw new Exception("Las celdas no deben estar vacias, dar enter al escribir el valor de la celda");
				}

				double numero =  Double.parseDouble((String) modeloNotas.getValueAt(i, 0));
				if(numero < 0 || numero >= 20){
					throw new Exception("En la casilla " + (i + 1) + " ingrese un numero entre 0 y 19");
				}
				arreglo[i] = numero;
			}
			return arreglo;
		}

		int[] generarArregloFrecuencia(double[] notas){
			int frecuencia[] = new int[5];
			for(double nota : notas){
				if(nota >= 0 && nota < 5){
					frecuencia[0]++;
				}
				else if(nota >= 5 && nota < 10){
					frecuencia[1]++;
				}
				else if(nota >= 10 && nota < 14){
					frecuencia[2]++;
				}
				else if(nota >= 14 && nota < 17){
					frecuencia[3]++;
				}
				else if(nota >= 17 && nota < 20){
					frecuencia[4]++;
				}
			}

			return frecuencia;
		}

		void llenarTabla(double[] notas){
			int[] frecuencia = generarArregloFrecuencia(notas);
			llenarFrecuenciaAbsoluta(frecuencia);
			llenarFrecuenciaRelativa(frecuencia);
			llenarFrecuenciaPorcentual(frecuencia);
			llenarFrecAbsolutaAcumulada(frecuencia);
			llenarFrecRelativaAcumulada(frecuencia);
			llenarFrecPorcentualAcumulada(frecuencia);
		}

		void llenarFrecuenciaAbsoluta(int[] frecuencias){
			for(int i = 0; i < frecuencias.length; i++){
				modeloEstadisticas.setValueAt(frecuencias[i], i, 1);
			}
		}

		void llenarFrecuenciaRelativa(int[] frecuencias){
			for(int i = 0; i < frecuencias.length; i++){
				// Frecuencia absoluta / numero total de individuos
				double frecuenciaRelativa = frecuencias[i] / (double) notas.length;
				modeloEstadisticas.setValueAt(formato.format(frecuenciaRelativa), i, 2);
			}
		}

		void llenarFrecuenciaPorcentual(int[] frecuencias){
			for(int i = 0; i < frecuencias.length; i++){
				// Frecuencia relativa / numero total de individuos
				double frecuenciaRelativa = (double)frecuencias[i] / modeloNotas.getRowCount();
				double frecuenciaPorcentual = frecuenciaRelativa * 100;
				modeloEstadisticas.setValueAt(formato.format(frecuenciaPorcentual), i, 3);
			}
		}

		void llenarFrecAbsolutaAcumulada(int[] frecuencia){
			int frecuenciaAcumulada = 0;
			for(int i = 0; i < frecuencia.length; i++){
				frecuenciaAcumulada += frecuencia[i];
				modeloEstadisticas.setValueAt(frecuenciaAcumulada, i, 4);
			}
		}

		void llenarFrecRelativaAcumulada(int[] frecuencias){
			double frecuenciaAcumulada = 0.0;
			for(int i = 0; i < frecuencias.length; i++){
				double frecuenciaRelativa = (double)frecuencias[i] / modeloNotas.getRowCount();
				frecuenciaAcumulada += frecuenciaRelativa;
				modeloEstadisticas.setValueAt(formato.format(frecuenciaAcumulada), i, 5);
			}
		}

		void llenarFrecPorcentualAcumulada(int[] frecuencias){
			double frecuenciaAcumulada = 0.0;
			for(int i = 0; i < frecuencias.length; i++){
				double frecuenciaRelativa = (double)frecuencias[i] / modeloNotas.getRowCount();
				double frecuenciaPorcentual = frecuenciaRelativa * 100;
				frecuenciaAcumulada += frecuenciaPorcentual;
				modeloEstadisticas.setValueAt(formato.format(frecuenciaAcumulada), i, 6);
			}
		}
	}

    public static void main(String[] args) {
		ValoresEstadisticos_Notas ventana = new ValoresEstadisticos_Notas();
    }
}
