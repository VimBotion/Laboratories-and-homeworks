/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Palindromo {
	public static boolean validarIngreso(String texto){
		// El usuario no ingresa nada o solo una letra
		return texto.length() < 2;
	}
	
	public static String removerTildes(String texto){
		texto = texto.replaceAll("á", "a")
				.replaceAll("é", "e")
				.replaceAll("í", "i")
				.replaceAll("ó", "o")
				.replaceAll("ú", "u")
				.replaceAll("ñ", "n")
				.replaceAll("ü", "u")
				.replaceAll("Á", "A")
				.replaceAll("É", "E")
				.replaceAll("Í", "I")
				.replaceAll("Ó", "O")
				.replaceAll("Ú", "U")
				.replaceAll("Ñ", "N")
				.replaceAll("Ü", "U");
		return texto;
	}

	public static String formatearTexto(String texto){
		texto = removerTildes(texto);
		// Remueve signos de puntuacion, espacios en blanco y convierte a minusculas
		texto = texto.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

		return texto;
	}

	public static boolean esPalindromo(String texto){
		StringBuilder textoInverso = new StringBuilder(texto);
		textoInverso = textoInverso.reverse();

		return texto.equals(textoInverso.toString());
	}

    public static void main(String[] args) {
		Scanner cadena = new Scanner(System.in, "ISO-8859-1");
		String opcion, texto;
		do{
			do {
				System.out.print("Cadena: ");
				texto = cadena.nextLine();
				if(validarIngreso(texto)){
					System.out.println("Ingrese al menos una palabra, de dos o mas caracteres");
				}
			}while(validarIngreso(texto));

			texto = formatearTexto(texto);
			if(esPalindromo(texto)){
				System.out.println("La cadena es un palindromo");
			}
			else{
				System.out.println("La cadena no es un palindromo");
			}
			do{
				System.out.print("Desea repetir el programa? (s/n): ");
				opcion = cadena.nextLine();
				if(!opcion.matches("[sSnN]")){
					System.out.println("Ingrese solo las letras s o n");
				}
			}while(!opcion.matches("[sSnN]"));
		}while(opcion.matches("[sS]"));
    }
}
