/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Secuencia_Sin_Repetidos {
	public static boolean validarIngreso(String secuencia){
		// La secuencia empieza con un digito, seguido de solo un espacio en blanco y 0 o mas digitos
		return secuencia.matches("^\\d+(\\s{1}\\d+)*$");
	}

	public static int[] generarArregloEnteros(String[] arregloCadenas){
		int[] arregloEnteros = new int[arregloCadenas.length];
		for(int i = 0; i < arregloCadenas.length; i++){
			// Convierte el numero de tipo string a entero
			arregloEnteros[i] = Integer.parseInt(arregloCadenas[i]);
		}	
		return arregloEnteros;
	}

	public static void mostrarSinDuplicados(int[] arreglo){
		System.out.println("La secuencia sin duplicados es: ");
		for(int i = 0; i < arreglo.length; i++){
			boolean esDuplicado = false;
			for(int j = i; j >= 0; j--){
				if(arreglo[i] == arreglo[j] && j != i){
					esDuplicado = true;					
				}
			}
			if(!esDuplicado){
				System.out.print(arreglo[i] + " ");
			}
		}
		System.out.println(" ");
	}
	
    public static void main(String[] args) {
		Scanner cadena = new Scanner(System.in, "ISO-8859-1");
		Scanner caracter = new Scanner(System.in);
		char opcion;
		String secuencia;
		
		do {
			// Ingreso de la cadena
			do{
				System.out.print("Ingrese una secuencia de numeros enteros: ");
				secuencia = cadena.nextLine();
				secuencia = secuencia.trim();
				if(!validarIngreso(secuencia)){
					System.out.println("Ingrese solo digitos, separados por solo un espacio en blanco");
				}
			}while(!validarIngreso(secuencia));
			
			String[] arregloCadenas = secuencia.split(" ");
			int[] arregloEnteros = generarArregloEnteros(arregloCadenas);
			mostrarSinDuplicados(arregloEnteros);
			do{
				System.out.print("Desea continuar? (s/n): ");
				opcion = caracter.next().charAt(0);
				if(opcion != 's' && opcion != 's'){
					System.out.println("Ingrese s o n");
				}
			}while(opcion != 's' && opcion != 'n');
		}while(opcion == 's');
    }
}
