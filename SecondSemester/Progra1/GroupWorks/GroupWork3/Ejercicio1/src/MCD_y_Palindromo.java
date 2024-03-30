/**
 * 1. El programa debe tener una solución modular que realize el Maximo Comun Divisor de un numero, y compruebe si un numero es Palindromo.
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class MCD_y_Palindromo {
    public static long MCD(long numero1, long numero2){
		while(numero2 >= 1){
			long temp = numero2;
			numero2 = numero1 % numero2;
			numero1 = temp;
		}
		return numero1;
	}
	public static boolean esPalindromo(long numero){
		long numeroInvertido = 0;
		long numeroOriginal = numero;
		while(numero != 0){
			long residuo = numero % 10;
			numeroInvertido = numeroInvertido * 10 + residuo;
			numero /= 10;
		}
		return (numeroOriginal == numeroInvertido);
	}
    public static void main(String[] args) {
   		long numero1, numero2;
		char opcion;
		Scanner largo = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);

		do {
			System.out.println("Menu:");	
			System.out.println("1. Maximo comun divisor");
			System.out.println("2. Numero Palindromo");
			System.out.println("3. Palindromo");
			System.out.print("Elija una opcion (1-3): ");
			opcion = caracter.next().charAt(0);

			switch(opcion){
				case '1':
					do {
						System.out.print("Ingrese el primero numero entero positivo: ");
						numero1 = largo.nextLong();
					} while(numero1 <= 0);
					do {
						System.out.print("Ingrese el segundo numero entero positivo: ");
						numero2 = largo.nextLong();
					} while(numero2 <= 0);
					System.out.println("El Maximo Comun Divisor (MCD) de " + numero1 + " y " + numero2 + " es " + MCD(numero1, numero2));
					break;
				case '2':
					do {
						System.out.print("Ingrese un numero entero positivo: ");
						numero1 = largo.nextLong();
					} while(numero1 <= 0);
					if (esPalindromo(numero1)){
						System.out.println(numero1 + " es un palindromo.");
					}
					else {
						System.out.println(numero1 + " no es un palindromo.");
					}
					break;
				case '3':
					System.out.println("Fin del programa");
					break;
				default:
					System.out.println("Opcion no valida");
			}
		} while(opcion != '3');
    }    
}
