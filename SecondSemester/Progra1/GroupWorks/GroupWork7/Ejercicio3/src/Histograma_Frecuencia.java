/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Histograma_Frecuencia {
	public static boolean validarCadena(String texto){
		String[] cadenasReales = texto.split("\\s+");
		for(String num :cadenasReales){
			if(!num.matches("[\\+-]?\\d+|[\\+-]?\\d+\\.\\d+")){
				return false;
			}
			double numero = Double.parseDouble(num);
			if(numero < 0 || numero > 30){
				return false;
			}
		}
		return true;
	}

	public static double[] generarArregloReales(String texto){
		String[] cadenasReales = texto.split("\\s+");
		double[] numReales = new double[cadenasReales.length];	

		for(int i = 0; i < cadenasReales.length; i++){
			numReales[i] = Double.parseDouble(cadenasReales[i]);
		}

		return numReales;
	}

	public static int[] contar(double[] arregloReales){
		int contador[] = new int[9];
		for(double num : arregloReales){
			if (num >= 0 && num < 5) {
				contador[0]++;
			} else if (num >= 5 && num < 10) {
				contador[1]++;
			} else if (num >= 10 && num < 14) {
				contador[2]++;
			} else if (num >= 14 && num < 17) {
				contador[3]++;
			} else if (num >= 17 && num < 20) {
				contador[4]++;
			} else if (num >= 20 && num < 24) {
				contador[5]++;
			} else if (num >= 24 && num < 27) {
				contador[6]++;
			} else if (num >= 27 && num < 30) {
				contador[7]++;
			} else {
				contador[8]++;
			}
		}

		return contador;
	}

	public static void mostrarResultado(int[] contador){
		String[] intervalos = {"0-5", "5-10", "10-14", "14-17", "17-20", "20-24", "24-27", "27-30", "30"};
		for(int i = 0; i < intervalos.length; i++){
			System.out.print(intervalos[i] + "\t");
			for(int j = 0; j < contador[i]; j++){
				System.out.print("*");
			}
			System.out.println("");
		}
	}

    public static void main(String[] args) {
		Scanner cadena = new Scanner(System.in);
		String texto, continuar;
		do{
			do{
				System.out.println("Ingrese números reales positivos (0 a 30) separados por un espacio en blanco: ");
				texto = cadena.nextLine().trim();
			}while(!validarCadena(texto));

			double[] calificaciones = generarArregloReales(texto);
			System.out.println("Histograma de frecuencia");			
			int[] contador = contar(calificaciones);
			mostrarResultado(contador);

			do{
				System.out.print("Desea repetir el programa? (s/n): ");
				continuar = cadena.nextLine();
			}while(!continuar.matches("[sSnN]"));
		}while(continuar.matches("[sS]"));
    }
}
