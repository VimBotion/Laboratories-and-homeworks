/**
 * 3. Escribir un programa que permita utilizando un método, realizar una búsqueda secuencial 
 * en un vector de reales. Deben existir métodos que permitan ingresar y mostrar los elementos 
 * del vector. 
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class BusquedaSecuencial {
	public static void ingresarElementos(double vector[]){
		Scanner real = new Scanner(System.in);
		for(int i = 0; i < vector.length; i++){
			// i + 1 porque el usuario puede no conocer index 0
			System.out.print("Ingrese el elemento " + i +  ": ");
			vector[i] = real.nextDouble();
		}
	}

	public static void mostrarElementos(double vector[]){
		System.out.print("Los valores del arreglo son: ");
		for(double element : vector){
			System.out.print(element + " ");
		}
		System.out.print("\n");
	}

	public static int busquedalineal(double Vector[], double argumento_busqueda){
		// Itera sobre el vector y devuelve la posicion del vector, o -1 si no encuentra
		for(int i = 0; i < Vector.length; i++){
			if(Vector[i] == argumento_busqueda){
				return i;
			}
		}
		return -1;
	}

    public static void main(String[] args) {
		int numeroElementos;
    	char opcion;
		double valorBuscar;
		Scanner entero = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);
		Scanner real = new Scanner(System.in);
		
		do {
			do {
				System.out.print("Ingrese el numero de elementos que tendra el arreglo (mayor a 0): ");
				numeroElementos = entero.nextInt();
			} while(numeroElementos <= 0);
			
			// Crear el vector con el tamano dado por el usuario
			double vector[] = new double[numeroElementos];
			ingresarElementos(vector);
			mostrarElementos(vector);
		
			System.out.print("Ingrese el valor a buscar: ");
			valorBuscar = real.nextDouble();
			// Comprueba si existe el valor a buscar en el vector
			if(busquedalineal(vector, valorBuscar) != -1){
				System.out.println("El " + valorBuscar + " se encuentra en la posicion " + busquedalineal(vector, valorBuscar));
			}
			else {
				System.out.println("El " + valorBuscar + " no se encuentra en el arreglo");
			}	
			do {
				System.out.print("Desea repetir el programa? (s/n): ");
				opcion = caracter.next().charAt(0);
				opcion = Character.toLowerCase(opcion);
			} while(opcion != 's' && opcion != 'n');
		} while(opcion == 's');
	}
}
