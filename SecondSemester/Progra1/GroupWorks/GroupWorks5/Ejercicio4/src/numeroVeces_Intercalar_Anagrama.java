/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class numeroVeces_Intercalar_Anagrama {
	public static String convertirCadena(String cadena){
		// Devuelve una cadena en minusculas y sin espacios en blanco
		cadena = cadena.toLowerCase();
		return cadena.trim();
	}

	public static String pedirCadena(int numeroCadena){
		Scanner entrada = new Scanner(System.in, "ISO-8859-1");
		System.out.print("Cadena" + numeroCadena + ": ");
		String cadena = entrada.nextLine();
		return convertirCadena(cadena);
	}
	
	public static int numeroVeces(String cadena1, String cadena2){
		int repetidos = 0;
		int index = 0;
		// Mientras se encuentre la cadena 2 en la cadena 1
		while((index = cadena1.indexOf(cadena2, index)) != -1){
			repetidos++;
			// Mueve el index para que compare despues de una ocurrencia
			index++;
		}
		return repetidos;
	}


    public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in, "ISO-8859-1");
		Scanner caracter = new Scanner(System.in);
		char opcion;
		do {
			System.out.println("Menu");
			System.out.println("a) Numero de veces");
			System.out.println("b) Intercalar");
			System.out.println("c) Anagramas");
			System.out.println("d) Salir");
			System.out.print("Que desea realizar? (a-d): ");
			opcion = caracter.next().charAt(0);
			// Devuelve opcion en minusculas
			opcion = Character.toLowerCase(opcion);
			switch(opcion){
				case 'a':
					String cadena1 = pedirCadena(1);
					String cadena2 = pedirCadena(2);
					System.out.println("La subcadena " + cadena2 + " aparece " + numeroVeces(cadena1, cadena2) + " en la cadena " + cadena1);
					break;
				case 'b':
					break;
				case 'c':
					break;
				case 'd':
					System.out.println("Fin del programa");
					break;
				default:
					System.out.println("Opcion invalida");
			}
		}while(opcion != 'd');
	}
}
