/*
*
* @author Cabrera Franck, Campoverde Esteban, Apolo Juan 
*
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraRedesYMatematicas extends JFrame {
	JLabel direccionIpv4, direccionIpv6, ecuacionNum1, ecuacionNum2, ecuacionNum3;
	JTextField resultadoIpv4, resultadoIpv6, ecuacionCampo1, ecuacionCampo2, ecuacionCampo3, ecuacionCampo4;
	JTextArea resultadoEcuacion;
	JTabbedPane panelFichas;
	JPanel panelRedes, panelComplejos, panelEcuacion, panelOperacionesC;
	JLabel etiquetaComplejo1, etiquetaComplejo2,  etiquetaImaginacio, etiquetaResultado;
	JTextField complejoCampo1, campoComplejo2, campoComplejo3, campoComplejo4, campoResultado, campoResultado2;
	JComboBox<String> comboOperaciones;
	
	CalculadoraRedesYMatematicas(){
		panelFichas = new JTabbedPane();
		
		// Panel para Conversion IPv4 a IPv6
		panelRedes = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
		direccionIpv4 = new JLabel("Ingrese dirección IPv4  ");
		panelRedes.add(direccionIpv4);
		resultadoIpv4 = new JTextField(20);
		panelRedes.add(resultadoIpv4);
		panelRedes.add(new JLabel("                               "));
		direccionIpv6 = new JLabel("Dirección IPv6  ");
		panelRedes.add(direccionIpv6);
		resultadoIpv6 = new JTextField(25);
		resultadoIpv6.setEditable(false);
		panelRedes.add(resultadoIpv6);
		panelFichas.add("Conversion IPV4 a IPV6", panelRedes);
		
		// Panel para Números Complejos
		panelOperacionesC = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		etiquetaComplejo1 = new JLabel("Ingrese Número Complejo 1");
		panelOperacionesC.add(etiquetaComplejo1);
		complejoCampo1 = new JTextField(5);
		panelOperacionesC.add(complejoCampo1);
		campoComplejo2 = new JTextField(5);
		panelOperacionesC.add(campoComplejo2);
		etiquetaImaginacio = new JLabel("i");
		panelOperacionesC.add(etiquetaImaginacio);
		
		comboOperaciones = new JComboBox<>(new String[]{"elija operación", "suma", "resta", "multiplicación", "división"});
		panelOperacionesC.add(comboOperaciones);
		
		etiquetaComplejo2 = new JLabel("Ingrese Número Complejo 2");
		panelOperacionesC.add(etiquetaComplejo2);
		campoComplejo3 = new JTextField(5);
		panelOperacionesC.add(campoComplejo3);
		campoComplejo4 = new JTextField(5);
		panelOperacionesC.add(campoComplejo4);
		etiquetaImaginacio = new JLabel("i");
		panelOperacionesC.add(etiquetaImaginacio);
		
		panelOperacionesC.add(new JLabel("                                                                     "));
		etiquetaResultado = new JLabel("Resultado                                 ");
		panelOperacionesC.add(etiquetaResultado);
		campoResultado = new JTextField(5);
		campoResultado.setEditable(false);
		panelOperacionesC.add(campoResultado);
		campoResultado2 = new JTextField(5);
		campoResultado2.setEditable(false);
		panelOperacionesC.add(campoResultado2);
		panelFichas.addTab("Complejos", null, panelOperacionesC);
		
		// Panel para Ecuación Cúbica
		panelEcuacion = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
		ecuacionCampo1 = new JTextField(5);
		panelEcuacion.add(ecuacionCampo1);
		ecuacionNum1 = new JLabel("X³");
		panelEcuacion.add(ecuacionNum1);
		ecuacionCampo2 = new JTextField(5);
		panelEcuacion.add(ecuacionCampo2);
		ecuacionNum2 = new JLabel("X²");
		panelEcuacion.add(ecuacionNum2);
		ecuacionCampo3 = new JTextField(5);
		panelEcuacion.add(ecuacionCampo3);
		ecuacionNum3 = new JLabel("X");
		panelEcuacion.add(ecuacionNum3);
		ecuacionCampo4 = new JTextField(5);
		panelEcuacion.add(ecuacionCampo4);
		resultadoEcuacion = new JTextArea(10,36);
		resultadoEcuacion.setEditable(false);
		panelEcuacion.add(resultadoEcuacion);
		panelFichas.addTab("Ecuación Cubica", panelEcuacion);
		
		add(panelFichas);
		
		ManejadorResultados manejador = new ManejadorResultados();
		resultadoIpv4.addActionListener(manejador);
		ecuacionCampo4.addActionListener(manejador);
		comboOperaciones.addActionListener(manejador);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Calculadora de redes y matematicas");
		setSize(600,300);
		setResizable(false);
		setVisible(true);
	}
	
	private class ManejadorResultados implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource() == resultadoIpv4){
				convertirIPV4();
			} else if (evento.getSource() == ecuacionCampo4) {
				ecuacionCubica();
			} else if (evento.getSource() == comboOperaciones) {
				operacionesComplejas();
			}
		}
	}
	
	public void operacionesComplejas() {
		try {
			String complejo1 = complejoCampo1.getText();
			String complejo1_2 = campoComplejo2.getText();
			String complejo2 = campoComplejo3.getText();
			String complejo2_2 = campoComplejo4.getText();
			
			double real1 = Double.parseDouble(complejo1);
			double imag1 = Double.parseDouble(complejo1_2);
			double real2 = Double.parseDouble(complejo2);
			double imag2 = Double.parseDouble(complejo2_2);
			
			String operacion = (String) comboOperaciones.getSelectedItem();
			
			double resultadoReal = 0;
			double resultadoImag = 0;
			
			switch (operacion) {
				case "suma":
					resultadoReal = real1 + real2;
					resultadoImag = imag1 + imag2;
					break;
				case "resta":
					resultadoReal = real1 - real2;
					resultadoImag = imag1 - imag2;
					break;
				case "multiplicación":
					resultadoReal = real1 * real2 - imag1 * imag2;
					resultadoImag = real1 * imag2 + real2 * imag1;
					break;
				case "división":
					double denom = real2 * real2 + imag2 * imag2;
					resultadoReal = (real1 * real2 + imag1 * imag2) / denom;
					resultadoImag = (imag1 * real2 - real1 * imag2) / denom;
					break;
				default:
					campoResultado.setText("");
					campoResultado2.setText("");
					break;
			}
			
			campoResultado.setText(String.format("%.2f", resultadoReal));
			campoResultado2.setText(String.format("%.2f", resultadoImag));
		} catch (NumberFormatException exepcion) {
			JOptionPane.showMessageDialog(this, "Ingrese solo números en las posiciones", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public void convertirIPV4() {
		String ipv4 = resultadoIpv4.getText();
		if (ipv4.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese una dirección IPv4.", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String[] octetos = ipv4.split("\\.");
		if (octetos.length != 4) {
			JOptionPane.showMessageDialog(this, "Ingrese una dirección IPv4 válida.", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
			return;
		}
		StringBuilder ipv6 = new StringBuilder("::ffff:");
		try {
			for (String octeto : octetos) {
				int octetoInt = Integer.parseInt(octeto);
				if (octetoInt < 0 || octetoInt > 255) {
					JOptionPane.showMessageDialog(this, "El rango de cada octeto es de 0 y 255.", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
					return;
				}
				ipv6.append(String.format("%02x", octetoInt));
			}
		} catch (NumberFormatException excepcion) {
			JOptionPane.showMessageDialog(this, "Cada octeto debe ser un número", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
			return;
		}
		resultadoIpv6.setText(ipv6.toString());
	}
	
	public void ecuacionCubica() {
		try {
			double a = Double.parseDouble(ecuacionCampo1.getText());
			double b = Double.parseDouble(ecuacionCampo2.getText());
			double c = Double.parseDouble(ecuacionCampo3.getText());
			double d = Double.parseDouble(ecuacionCampo4.getText());
			
			double discriminante, q, r, dum1, s, t, term1, r13;
			q = (3.0 * a * c - b * b) / (9.0 * a * a);
			r = -(27.0 * a * a * d) + b * (9.0 * a * c - 2.0 * b * b);
			r /= 54.0 * a * a * a;
			discriminante = q * q * q + r * r;
			term1 = (b / (3.0 * a));
			
			StringBuilder resultBuilder = new StringBuilder();
			
			if (discriminante > 0) {
				s = r + Math.sqrt(discriminante);
				s = ((s < 0) ? -Math.pow(-s, 1.0 / 3.0) : Math.pow(s, 1.0 / 3.0));
				t = r - Math.sqrt(discriminante);
				t = ((t < 0) ? -Math.pow(-t, 1.0 / 3.0) : Math.pow(t, 1.0 / 3.0));
				resultBuilder.append(String.format("x1 = %.5f\n", -term1 + s + t));
			} else if (discriminante == 0) {
				r13 = ((r < 0) ? -Math.pow(-r, 1.0 / 3.0) : Math.pow(r, 1.0 / 3.0));
				resultBuilder.append(String.format("x1 = %.5f\nx2 = %.5f\n", -term1 + 2.0 * r13, -(r13 + term1)));
			} else {
				q = -q;
				dum1 = q * q * q;
				dum1 = Math.acos(r / Math.sqrt(dum1));
				r13 = 2.0 * Math.sqrt(q);
				resultBuilder.append(String.format("x1 = %.5f\nx2 = %.5f\nx3 = %.5f\n",
						-term1 + r13 * Math.cos(dum1 / 3.0),
						-term1 + r13 * Math.cos((dum1 + 2.0 * Math.PI) / 3.0),
						-term1 + r13 * Math.cos((dum1 + 4.0 * Math.PI) / 3.0)));
			}
			
			resultadoEcuacion.setText(resultBuilder.toString());
			
		} catch (NumberFormatException exepcion) {
			JOptionPane.showMessageDialog(this, "Ingrese coeficientes válidos para la ecuación cúbica", "Error de Ingreso", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public static void main(String[] args){
		CalculadoraRedesYMatematicas aplicacion = new CalculadoraRedesYMatematicas();
	}
}