/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class numeroVeces_Intercalar_Anagrama {
	// Devuelve una cadena en minusculas y sin espacios en blanco
	public static String convertirCadena(String cadena){
		cadena = cadena.toLowerCase();
		return cadena.trim();
	}

	public static String pedirCadena(int numeroCadena){
		Scanner entrada = new Scanner(System.in, "ISO-8859-1");
		System.out.print("Cadena" + numeroCadena + ": ");
		String cadena = entrada.nextLine();
		return convertirCadena(cadena);
	}
	
	// Metodo para el literal a
	public static int numeroVeces(String cadena1, String cadena2){
		int repetidos = 0;
		int index = 0;
		// Mientras se encuentre una ocurrencia
		while((index = cadena1.indexOf(cadena2, index)) != -1){
			repetidos++;
			// Mueve el index para que compare despues de una ocurrencia
			index++;
		}
		return repetidos;
	}

	// Metodo para el literal b
	public static String intercalar(String cadena1, String cadena2){
		String cadena = " ";
		// Si los tamanos de las cadenas son distintos itera hasta el tamano de la cadena mas pequena
		int minimo = Math.min(cadena1.length(), cadena2.length());
		for(int i = 0; i < minimo; i++){
			cadena += cadena1.charAt(i);
			cadena += cadena2.charAt(i);
		}
		
		// Substring devuelve una cadena vacia si el indice de inicio es igual al tamano de la cadena
		// Devuelve la cadena mas los caracteres restantes de la cadena mas larga
		return cadena + cadena1.substring(minimo) + cadena2.substring(minimo);
	}

	// Metodo para el literal c
	public static boolean esAnagrama(String cadena1, String cadena2){
		if(cadena1.length() != cadena2.length()){
			return false;
		}
		// Array para cada letra del abecedario en espanol
		int contador[] = new int[27];

		for(int i = 0; i < cadena1.length(); i++){
			contador[cadena1.charAt(i) - 'a']++; // - 'a' convierte el caracter en la posicion i a su valor numerico UNICODE 
		}
		for(int i = 0; i < cadena2.length(); i++){
			contador[cadena2.charAt(i) - 'a']--;
		}

		for(int cont : contador){
			if(cont != 0){
				return false;
			}
		}

		return true;
	}


    public static void main(String[] args) {
		Scanner caracter = new Scanner(System.in);
		String cadena1, cadena2;
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
					cadena1 = pedirCadena(1);
					cadena2 = pedirCadena(2);
					System.out.println("La subcadena " + cadena2 + " aparece " + numeroVeces(cadena1, cadena2) + " veces en la cadena " + cadena1);
					break;
				case 'b':
					cadena1 = pedirCadena(1);
					cadena2 = pedirCadena(2);
					System.out.println("Resultado " + intercalar(cadena1, cadena2));
					break;
				case 'c':
					cadena1 = pedirCadena(1);
					cadena2 = pedirCadena(2);
					if(esAnagrama(cadena1, cadena2)){
						System.out.println("Las cadenas son anagramas");	
					} else{
						System.out.println("Las cadenas no son anagramas");
					}
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
