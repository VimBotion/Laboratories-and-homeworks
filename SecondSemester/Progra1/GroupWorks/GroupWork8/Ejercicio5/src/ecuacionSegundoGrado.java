/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ecuacionSegundoGrado extends JFrame {
	JButton botonCalcular, botonBorrar, botonSalir;
	JLabel etiquetaIngreso, etiquetaResultado;
	JTextField campoIngreso;
	JTextArea areaSalida;
	
	ecuacionSegundoGrado(){
		setLayout(new FlowLayout());

		etiquetaIngreso = new JLabel("Ingrese ecuacion");
		add(etiquetaIngreso);

		campoIngreso = new JTextField(30);
		add(campoIngreso);

		etiquetaResultado = new JLabel("Resultado");
		add(etiquetaResultado);

		areaSalida = new JTextArea(1, 30);
		areaSalida.setEditable(false);
		add(areaSalida);
		
		botonCalcular = new JButton("Calcular");
		add(botonCalcular);

		botonBorrar = new JButton("Borrar Todo");
		add(botonBorrar);

		botonSalir = new JButton("Salir");
		add(botonSalir);
		
		ManejadorBoton manejador = new ManejadorBoton();
		botonCalcular.addActionListener(manejador);
		botonBorrar.addActionListener(manejador);
		botonSalir.addActionListener(manejador);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Calculo de raices de la ecuacion de segundo grado");
		setResizable(false);
		setSize(400, 400);
		setVisible(true);
	}	

	private class ManejadorBoton implements ActionListener {
		public void actionPerformed(ActionEvent evento){
			String cadena;
			if(evento.getSource() == botonCalcular){
				cadena = campoIngreso.getText();
				if(!validarIngreso(cadena)){
					JOptionPane.showMessageDialog(null, "Ingrese la formula de la ecuacion cuadratica de la siguiente manera: Ax^2+Bx+C", "Mensaje informativo",
							JOptionPane.INFORMATION_MESSAGE);
					campoIngreso.setText("");
					areaSalida.setText("");
					campoIngreso.requestFocus();
				}	
				else{
					// Separa los numeros ingresados en la ecuacion cuadratica
					String resultados[] = cadena.split("x\\^2|x");	
					double reales[] = generarArregloReales(resultados);
					// Coeficientes de la ecuacion cuadratica
					double a = reales[0];
					double b = reales[1];
					double c = reales[2];

					double discriminante = discriminante(a, b, c);
					if(a != 0 && discriminante > 0){
						// Raices desiguales
						areaSalida.setText(resultado(a, b, c));
					}
					else if(a != 0 && discriminante == 0){
						// Raices iguales
						areaSalida.setText(resultado(a, b, c));
					}
					else if(a != 0 && discriminante < 0){
						areaSalida.setText("Existen dos raices imaginarias");
					}
					else if(a == 0 && b != 0){
						// Existe una sola raiz
						areaSalida.setText(resultado(a, b, c));
					}
					else if(a == 0 && b == 0){
						areaSalida.setText("La ecuacion es degenerada");
					}
				}
			}
			else if(evento.getSource() == botonBorrar){
				campoIngreso.setText("");
				areaSalida.setText("");
				campoIngreso.requestFocus();
			}
			else if(evento.getSource() == botonSalir){
				System.exit(0);
			}
		}

		public boolean validarIngreso(String cadena){
			return(cadena.matches("[\\+-]?\\d+(\\.\\d+)?x\\^2[\\+-]\\d+(\\.\\d+)?x[\\+-]\\d(\\.\\d+)?"));
		}

		public double[] generarArregloReales(String[] arreglo){
			double[] arregloReales = new double[arreglo.length];
			for(int i = 0; i < arreglo.length; i++){
				arregloReales[i] = Double.parseDouble(arreglo[i]);
			}

			return arregloReales;
		}

		public double discriminante(double a, double b, double c){
			double discriminante = Math.pow(b, 2) - 4.0*(a * c);
			return discriminante;
		}

		public String resultado(double a, double b, double c){
			double discriminante = discriminante(a, b, c);
			double resultado1, resultado2;
			
			DecimalFormat formato = new DecimalFormat("#,###.###");
			if(discriminante > 0){
				resultado1 = (-b + Math.sqrt(discriminante)) / (2 * a);
				resultado2 = (-b - Math.sqrt(discriminante)) / (2 * a);

				return("Las raices son X1=" + formato.format(resultado1) + " y X2=" + formato.format(resultado2));
			} else if(discriminante == 0){
				resultado1 = (-b / (2 * a));

				return("Las raices son X1=" + formato.format(resultado1) + " y X2" + formato.format(resultado1));
			} else if(a == 0 && b != 0){
				// Ecuacion de grado 1
				resultado1 = - c / b; 

				return("La raiz es X=" + formato.format(resultado1));
			}
		
			return("");
		}
		
	}
    public static void main(String[] args) {
		ecuacionSegundoGrado ejercicio = new ecuacionSegundoGrado();
    }
}