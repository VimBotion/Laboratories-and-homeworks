 /**
  *
  * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
  */
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class elementosTriangulo extends JFrame {
	int contadorLados, contadorAngulos;
	JMenuBar barraMenu;
	JMenu menuOperaciones, menuAyuda;
	JMenuItem opcionCalcular, opcionRestablecer, opcionSalir, opcionAcercaDe;
	JCheckBox botonLadoA, botonLadoB, botonLadoC, botonAnguloA, botonAnguloB, botonAnguloC;
	JTextField campoLadoA, campoLadoB, campoLadoC, campoAnguloA, campoAnguloB, campoAnguloC, campoPerimetro, campoArea;
	JLabel espacios, etiquetaPerimetro, etiquetaArea;
	
	elementosTriangulo() {
		// Alineacion a la izquierda con espacio de 20 entre los elementos
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		
		// Menu
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		menuOperaciones = new JMenu("Operaciones");
		menuOperaciones.setMnemonic('O');
		barraMenu.add(menuOperaciones);
		
		menuAyuda = new JMenu("Ayuda");
		menuAyuda.setMnemonic('A');
		barraMenu.add(menuAyuda);
		
		// Items para el menu operaciones
		opcionCalcular = new JMenuItem("Calcular");
		opcionCalcular.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		menuOperaciones.add(opcionCalcular);
		
		opcionRestablecer = new JMenuItem("Restablecer");
		opcionRestablecer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
		menuOperaciones.add(opcionRestablecer);
		
		opcionSalir = new JMenuItem("Salir");
		opcionSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		menuOperaciones.add(opcionSalir);
		
		// Items para el menu ayuda
		opcionAcercaDe = new JMenuItem("Acerca De");
		opcionAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
		menuAyuda.add(opcionAcercaDe);
		
		botonLadoA = new JCheckBox("Lado a");
		add(botonLadoA);
		
		campoLadoA = new JTextField(7);
		campoLadoA.setEditable(false);
		add(campoLadoA);
		
		botonAnguloA = new JCheckBox("Angulo alfa       ");
		add(botonAnguloA);
		
		campoAnguloA = new JTextField(7);
		campoAnguloA.setEditable(false);
		add(campoAnguloA);
		
		botonLadoB = new JCheckBox("Lado b");
		add(botonLadoB);
		
		campoLadoB = new JTextField(7);
		campoLadoB.setEditable(false);
		add(campoLadoB);
		
		botonAnguloB = new JCheckBox("Angulo beta      ");
		add(botonAnguloB);
		
		campoAnguloB = new JTextField(7);
		campoAnguloB.setEditable(false);
		add(campoAnguloB);
		
		botonLadoC = new JCheckBox("Lado c");
		add(botonLadoC);
		
		campoLadoC = new JTextField(7);
		campoLadoC.setEditable(false);
		add(campoLadoC);
		
		botonAnguloC = new JCheckBox("Angulo gamma");
		add(botonAnguloC);
		
		campoAnguloC = new JTextField(7);
		campoAnguloC.setEditable(false);
		add(campoAnguloC);
		
		etiquetaPerimetro = new JLabel("Perimetro  ");
		add(etiquetaPerimetro);
		
		campoPerimetro = new JTextField(7);
		campoPerimetro.setEditable(false);
		add(campoPerimetro);
		
		etiquetaArea = new JLabel("Area                            ");
		add(etiquetaArea);
		
		campoArea = new JTextField(7);
		campoArea.setEditable(false);
		add(campoArea);
		
		// Manejador de eventos de CheckBox
		ManejadorBoton manejadorItem = new ManejadorBoton();
		botonLadoA.addItemListener(manejadorItem);
		botonLadoB.addItemListener(manejadorItem);
		botonLadoC.addItemListener(manejadorItem);
		botonAnguloA.addItemListener(manejadorItem);
		botonAnguloB.addItemListener(manejadorItem);
		botonAnguloC.addItemListener(manejadorItem);
		
		// Manejador de eventos de MenuItems
		ManejadorMenu manejadorMenu = new ManejadorMenu();
		opcionCalcular.addActionListener(manejadorMenu);
		opcionRestablecer.addActionListener(manejadorMenu);
		opcionSalir.addActionListener(manejadorMenu);
		opcionAcercaDe.addActionListener(manejadorMenu);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Elementos de un triangulo");
		setSize(490, 250);
		setResizable(false);
		setVisible(true);
	}
	
	private class ManejadorBoton implements ItemListener {
		public void itemStateChanged(ItemEvent evento) {
			// Si el estado del boton esta seleccionado = true
			if (evento.getSource() == botonLadoA) {
				campoLadoA.setEditable(botonLadoA.isSelected());
				// Si el estado del boton esta seleccionado, sumar 1
				contadorLados += botonLadoA.isSelected() ? 1 : -1;
			} else if (evento.getSource() == botonLadoB) {
				campoLadoB.setEditable(botonLadoB.isSelected());
				contadorLados += botonLadoB.isSelected() ? 1 : -1;
			} else if (evento.getSource() == botonLadoC) {
				campoLadoC.setEditable(botonLadoC.isSelected());
				contadorLados += botonLadoC.isSelected() ? 1 : -1;
			} else if (evento.getSource() == botonAnguloA) {
				campoAnguloA.setEditable(botonAnguloA.isSelected());
				contadorAngulos += botonAnguloA.isSelected() ? 1 : -1;
			} else if (evento.getSource() == botonAnguloB) {
				campoAnguloB.setEditable(botonAnguloB.isSelected());
				contadorAngulos += botonAnguloB.isSelected() ? 1 : -1;
			} else if (evento.getSource() == botonAnguloC) {
				campoAnguloC.setEditable(botonAnguloC.isSelected());
				contadorAngulos += botonAnguloC.isSelected() ? 1 : -1;
			}
			
			validarSeleccion();
		}
		
		public void validarSeleccion(){
			// Si el usuario ingresa 2 o 3 lados e intenta ingresar un angulo
			if(contadorLados >= 2 && contadorAngulos > 0){
				JOptionPane.showMessageDialog(elementosTriangulo.this, "Ingrese 3 lados o un lado y dos ángulos", "Error de ingreso",
						JOptionPane.ERROR_MESSAGE);
				// SI el usuario ingresa 3 angulos o dos angulos e intenta ingresar mas de un lado
			} else if ((contadorLados > 1 && contadorAngulos == 2) || contadorAngulos == 3){
				JOptionPane.showMessageDialog(elementosTriangulo.this, "Ingrese 3 lados o un lado y dos ángulos", "Error de ingreso",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private class ManejadorMenu implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			double ladoA = 0, ladoB = 0, ladoC = 0, anguloA = 0, anguloB = 0, anguloC = 0;
			double perimetro, area;
			
			DecimalFormat format = new DecimalFormat("#,###.##");
			
			if (evento.getSource() == opcionCalcular) {
				if (!(contadorLados == 3 || (contadorLados == 1 && contadorAngulos == 2))) {
					JOptionPane.showMessageDialog(elementosTriangulo.this, "Ingrese 3 lados o un lado y dos ángulos", "Error de ingreso",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (botonLadoA.isSelected()) {
					if (!esNumericoPositivo(campoLadoA.getText())) {
						mostrarError("El lado A debe ser un número positivo");
						return;
					}
					ladoA = Double.parseDouble(campoLadoA.getText());
				}
				if (botonLadoB.isSelected()) {
					if (!esNumericoPositivo(campoLadoB.getText())) {
						mostrarError("El lado B debe ser un número positivo");
						return;
					}
					ladoB = Double.parseDouble(campoLadoB.getText());
				}
				if (botonLadoC.isSelected()) {
					if (!esNumericoPositivo(campoLadoC.getText())) {
						mostrarError("El lado C debe ser un número positivo");
						return;
					}
					ladoC = Double.parseDouble(campoLadoC.getText());
				}
				if (botonAnguloA.isSelected()) {
					if (!esAnguloValido(campoAnguloA.getText())) {
						mostrarError("El ángulo A debe ser un número positivo entre 0 y 180");
						return;
					}
					anguloA = Double.parseDouble(campoAnguloA.getText());
				}
				if (botonAnguloB.isSelected()) {
					if (!esAnguloValido(campoAnguloB.getText())) {
						mostrarError("El ángulo B debe ser un número positivo entre 0 y 180");
						return;
					}
					anguloB = Double.parseDouble(campoAnguloB.getText());
				}
				if (botonAnguloC.isSelected()) {
					if (!esAnguloValido(campoAnguloC.getText())) {
						mostrarError("El ángulo C debe ser un número positivo entre 0 y 180");
						return;
					}
					anguloC = Double.parseDouble(campoAnguloC.getText());
				}
				
				if (contadorLados == 3) {
					// En un triangulo, la suma entre dos lados tiene que ser diferente al otro lado
					if((ladoA + ladoB) == ladoC || (ladoA + ladoC) == ladoB || (ladoB + ladoC) == ladoA){
						JOptionPane.showMessageDialog(elementosTriangulo.this, "La suma entre dos lados tiene que ser diferente al otro lado", "Error de ingreso"
								, JOptionPane.ERROR_MESSAGE);
						return;
					}
					// Calculo de perimetro y area
					campoPerimetro.setText(format.format(perimetro(ladoA, ladoB, ladoC)));
					campoArea.setText(format.format(area(ladoA, ladoB, ladoC)));
					// Calculo de angulos
					anguloA = calcularAngulo(ladoB, ladoC, ladoA);
					anguloB = calcularAngulo(ladoA, ladoC, ladoB);
					anguloC = calcularAngulo(ladoA, ladoB, ladoC);
					campoAnguloA.setText(format.format(Math.toDegrees(anguloA)));
					campoAnguloB.setText(format.format(Math.toDegrees(anguloB)));
					campoAnguloC.setText(format.format(Math.toDegrees(anguloC)));
				} else if (contadorLados == 1 && contadorAngulos == 2) {
					// Ley de Senos
					if (botonAnguloA.isSelected() && botonAnguloB.isSelected() && botonLadoA.isSelected()) {
						anguloC = 180 - (anguloA + anguloB);
						ladoB = ladoA * Math.sin(Math.toRadians(anguloB)) / Math.sin(Math.toRadians(anguloA));
						ladoC = ladoA * Math.sin(Math.toRadians(anguloC)) / Math.sin(Math.toRadians(anguloA));
					} else if (botonAnguloA.isSelected() && botonAnguloC.isSelected() && botonLadoA.isSelected()) {
						anguloB = 180 - (anguloA + anguloC);
						ladoB = ladoA * Math.sin(Math.toRadians(anguloB)) / Math.sin(Math.toRadians(anguloA));
						ladoC = ladoA * Math.sin(Math.toRadians(anguloC)) / Math.sin(Math.toRadians(anguloA));
					} else if (botonAnguloB.isSelected() && botonAnguloC.isSelected() && botonLadoB.isSelected()) {
						anguloA = 180 - (anguloB + anguloC);
						ladoA = ladoB * Math.sin(Math.toRadians(anguloA)) / Math.sin(Math.toRadians(anguloB));
						ladoC = ladoB * Math.sin(Math.toRadians(anguloC)) / Math.sin(Math.toRadians(anguloB));
					} else if (botonAnguloB.isSelected() && botonAnguloC.isSelected() && botonLadoC.isSelected()) {
						anguloA = 180 - (anguloB + anguloC);
						ladoA = ladoC * Math.sin(Math.toRadians(anguloA)) / Math.sin(Math.toRadians(anguloC));
						ladoB = ladoC * Math.sin(Math.toRadians(anguloB)) / Math.sin(Math.toRadians(anguloC));
					} else if (botonAnguloA.isSelected() && botonAnguloC.isSelected() && botonLadoC.isSelected()) {
						anguloB = 180 - (anguloA + anguloC);
						ladoA = ladoC * Math.sin(Math.toRadians(anguloA)) / Math.sin(Math.toRadians(anguloC));
						ladoB = ladoC * Math.sin(Math.toRadians(anguloB)) / Math.sin(Math.toRadians(anguloC));
					} else if (botonAnguloA.isSelected() && botonAnguloB.isSelected() && botonLadoB.isSelected()) {
						anguloC = 180 - (anguloA + anguloB);
						ladoA = ladoB * Math.sin(Math.toRadians(anguloA)) / Math.sin(Math.toRadians(anguloB));
						ladoC = ladoB * Math.sin(Math.toRadians(anguloC)) / Math.sin(Math.toRadians(anguloB));
					}
					
					campoPerimetro.setText(format.format(perimetro(ladoA, ladoB, ladoC)));
					campoArea.setText(format.format(area(ladoA, ladoB, ladoC)));
					campoLadoA.setText(format.format(ladoA));
					campoLadoB.setText(format.format(ladoB));
					campoLadoC.setText(format.format(ladoC));
					campoAnguloA.setText(format.format(anguloA));
					campoAnguloB.setText(format.format(anguloB));
					campoAnguloC.setText(format.format(anguloC));
				}
				
			} else if (evento.getSource() == opcionRestablecer) {
				restablecerValores();
			} else if (evento.getSource() == opcionSalir) {
				System.exit(0);
			} else if (evento.getSource() == opcionAcercaDe) {
				JOptionPane.showMessageDialog(elementosTriangulo.this, "Ejercicio 2\nCampoverde Esteban, Apolo Juan, Cabrera Franck\n Mayo 2024",
						"Acerca De", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		public boolean esNumericoPositivo(String texto) {
			return texto.matches("\\d*\\.?\\d+");
		}
		
		public boolean esAnguloValido(String texto) {
			if (!texto.matches("\\d*\\.?\\d+")) {
				return false;
			}
			double valor = Double.parseDouble(texto);
			return valor > 0 && valor < 180;
		}
		
		public void mostrarError(String mensaje) {
			JOptionPane.showMessageDialog(elementosTriangulo.this, mensaje, "Error de ingreso", JOptionPane.ERROR_MESSAGE);
		}
		
		public double perimetro(double ladoA, double ladoB, double ladoC){
			return ladoA + ladoB + ladoC;
		}
		
		public double area(double ladoA, double ladoB, double ladoC){
			double semiperimetro = perimetro(ladoA, ladoB, ladoC) / 2;
			double area = Math.sqrt(semiperimetro * (semiperimetro - ladoA) * (semiperimetro - ladoB) * (semiperimetro - ladoC));
			return area;
		}
		
		public double calcularAngulo(double lado1, double lado2, double ladoOpuesto) {
			return Math.acos((Math.pow(lado1, 2) + Math.pow(lado2, 2) - Math.pow(ladoOpuesto, 2)) / (2 * lado1 * lado2));
		}
		
		public void restablecerValores() {
			botonLadoA.setSelected(false);
			botonLadoB.setSelected(false);
			botonLadoC.setSelected(false);
			botonAnguloA.setSelected(false);
			botonAnguloB.setSelected(false);
			botonAnguloC.setSelected(false);
			campoLadoA.setEditable(false);
			campoLadoA.setText("");
			campoLadoB.setEditable(false);
			campoLadoB.setText("");
			campoLadoC.setEditable(false);
			campoLadoC.setText("");
			campoAnguloA.setEditable(false);
			campoAnguloA.setText("");
			campoAnguloB.setEditable(false);
			campoAnguloB.setText("");
			campoAnguloC.setEditable(false);
			campoAnguloC.setText("");
			campoPerimetro.setText("");
			campoArea.setText("");
			
			contadorLados = 0;
			contadorAngulos = 0;
		}
	}
	


    public static void main(String[] args) {
        elementosTriangulo ventana = new elementosTriangulo();
    }
}