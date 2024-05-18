/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class numeroPerfecto extends JFrame {
	JLabel etiquetaNumeros;
	JTextField numerosEntrada;
	JTextArea numerosSalida;
	numeroPerfecto(){
		setLayout(new FlowLayout()); // Implementa flow layout
		
		etiquetaNumeros = new JLabel("Ingrese numeros enteros positivos");
		add(etiquetaNumeros);

		numerosEntrada = new JTextField(10); // Campo de texto para ingreso de numeros por el usuario
		add(numerosEntrada);

		numerosSalida = new JTextArea(15, 30); // Area de texto para mostrar los resultados
		numerosSalida.setEditable(false);
		add(new JScrollPane(numerosSalida));

		ManejadorCampoTexto manejador = new ManejadorCampoTexto();
		numerosEntrada.addActionListener(manejador); // Anade un oyente cuando el usuario da enter


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Calculo de numeros perfecto");
		setSize(500, 500);
		setVisible(true);

	}

	private class ManejadorCampoTexto implements ActionListener
	{
		public void actionPerformed(ActionEvent evento){
			String cadenaEnteros;
			if(evento.getSource() == numerosEntrada){
				cadenaEnteros = numerosEntrada.getText(); //Se guarda el ingreso del usuario

				if(!validarIngreso(cadenaEnteros)){
					JOptionPane.showMessageDialog(null, "Ingrese numeros enteros positivos separados por un espacio en blanco", "Mensaje Informativo", 
							JOptionPane.INFORMATION_MESSAGE);
					numerosEntrada.setText(""); // Borra el campo de texto
					numerosSalida.setText(""); // Borra el area de texto
					numerosEntrada.requestFocus(); // Vuelve el enfoque al campo de texto
				}
				else{
					// Arreglo de numeros ingresados
					int[] numeros = generarEnteros(cadenaEnteros);
					String textoFormateado = " ";
					textoFormateado = textoFormateado.format("%-20s %-20s %-20s %n", "Numero", "Perfecto", "Comprobacion");
					numerosSalida.setText(textoFormateado); // Pone el area de texto con el titulo de la columna
					for(int num : numeros){
						if(esPerfecto(num)){
							numerosSalida.append(num + "\t X \t" + generarComprobacion(num) + "\n");
						}
						else{
							numerosSalida.append(num + "\n");
						}
					}
				}
			}
		}	

		// Valida que se ingrese un numero positivo
		public boolean validarIngreso(String cadena){
			String[] numeroCadena = cadena.split(" ");
			for(String num : numeroCadena){
				if(!num.matches("[\\+]?\\d+")){
					return false;
				}
			}
			return true;
		}
		
		// Devuelve un arreglo con los numeros ingresados por el usuario
		public int[] generarEnteros(String cadena){
			String[] numeroCadena = cadena.split(" ");
			int[] arregloEnteros = new int[numeroCadena.length];

			for(int i = 0; i < arregloEnteros.length; i++){
				arregloEnteros[i] = Integer.parseInt(numeroCadena[i]);
			}

			return arregloEnteros;
		}

		public boolean esPerfecto(int num){
			int suma = 0;
			for(int i = 1; i <= num / 2; i++){
				if(num % i == 0){
					suma += i;
				}
			}
			
			return suma == num;
		}

		// Devuelve una cadena con la comprobacion del numero perfecto
		public String generarComprobacion(int numero){
			StringBuilder comprobacion = new StringBuilder();
			for(int i = 1; i <= numero / 2; i++){
				if(numero % i == 0){
					comprobacion.append(i);
					if (i != numero / 2) {
						comprobacion.append(" + ");
					}
				}
			}
			return comprobacion.toString();
		}
	}
    public static void main(String[] args) {
		numeroPerfecto ejercicio = new numeroPerfecto();
    }
}
