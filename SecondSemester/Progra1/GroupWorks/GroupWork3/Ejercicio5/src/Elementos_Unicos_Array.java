/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Elementos_Unicos_Array {
	public static int busquedalineal(double vector[], double argumento_busqueda){
		for(int i = 0; i < vector.length; i++){
			if(vector[i] == argumento_busqueda){
				return i;
			}
		}
		return -1;
	}
	public static void ingresarElementos(double vector[]){
		Scanner real = new Scanner(System.in);
		for(int i = 0; i < vector.length; i++){
			System.out.println("Ingrese el elemento " + i + ": ");
			double elemento = real.nextDouble();
			if(busquedalineal(vector, elemento) != -1){
				System.out.println("El elemento " + elemento + " ya se encuentra en el array, ingrese un valor diferente");
				i--;
			}
			else {
				vector[i] = elemento;
			}
		}
	}

	public static void mostrarElementos(double vector[]){
		System.out.println("Los valores del arreglo son: ");
		for(double element : vector){
			System.out.print(element + " ");
		}
		System.out.print("\n");
	}
	public static void main(String args[]){
		char opcion;
		int numeroElementos;
		double vector[];
		Scanner caracter = new Scanner(System.in);
		Scanner entero = new Scanner(System.in);
		
		do {
			do {
				System.out.println("Ingrese el numero de elementos que tendra el arreglo (mayor a 0): ");
				numeroElementos = entero.nextInt();
			} while(numeroElementos <= 0);

			// Crea el vector con el tamano dado por el usuario
			vector = new double[numeroElementos];
			ingresarElementos(vector);
			mostrarElementos(vector);

			
			do {
				System.out.print("Desea repetir el programa? s/n: ");
				opcion = caracter.next().charAt(0);
				// Convierte opcion a minusculas
				opcion = Character.toLowerCase(opcion);
			} while(opcion != 's' && opcion != 'n');
		} while(opcion == 's');
	}
}