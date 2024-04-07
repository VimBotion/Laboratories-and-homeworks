/**
 * 1. Ingresar datos en una matriz de reales de tamaño nxm y realizar operaciones sobre ellos
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Operaciones_Matrices {
	public static void ingresar(double matriz[][]){
		Scanner real = new Scanner(System.in);
		System.out.println("Ingrese los elementos de la matriz A");
		for(int filas = 0; filas < matriz.length; filas++){
			for(int columnas = 0; columnas < matriz[filas].length; columnas++){
				System.out.print("A["+ filas +"]["+ columnas +"]=");
				matriz[filas][columnas] = real.nextDouble();
			}
		}
	}
	
	public static void mostrar(double matriz[][]){
		System.out.println("Los elementos de la matriz A son: ");
		for(int filas = 0; filas < matriz.length; filas++){
			for(int columnas = 0; columnas < matriz[filas].length; columnas++){
				System.out.print(matriz[filas][columnas] +"\t");
			}	
			System.out.println("");
		}
	}

	public static int calcularCantidadNegativos(double matriz[][]){
		int cantidad = 0;
		for(int filas = 0; filas < matriz.length; filas++){
			for(int columnas = 0; columnas < matriz[filas].length; columnas++){
				if(matriz[filas][columnas] < 0){
					cantidad++;
				}
			}
		}
		return cantidad;
	}

	public static int calcularCantidadPositivos(double matriz[][]){
		int cantidad = 0;
		for(int filas = 0; filas < matriz.length; filas++){
			for(int columnas = 0; columnas < matriz[filas].length; columnas++){
				if(matriz[filas][columnas] > 0){
					cantidad++;
				}
			}
		}
		return cantidad;
	}

	public static double calcularPorcentaje(double matriz[][], int numeros){
		return ((double) numeros / (matriz.length * matriz[0].length) * 100);	
	}

	public static void mostrarPorcentajes(double matriz[][]){
		System.out.println("\t\nPorcentajes");
		// Porcentaje numeros positivos
		int positivos = calcularCantidadPositivos(matriz);
		double porcentajePositivos = calcularPorcentaje(matriz, positivos);
		System.out.printf("Con %d numero/s positivo/s, el porcentaje es de: %.2f%% %n", positivos, porcentajePositivos);
		// Porcentaje numeros negativos
		int negativos = calcularCantidadNegativos(matriz);
		double porcentajeNegativos = calcularPorcentaje(matriz, negativos);
		System.out.printf("Con %d numero/s negativo/s, el porcentaje es de: %.2f%% %n", negativos, porcentajeNegativos);
	}

	public static void promedioFilas(double matriz[][]){
		System.out.println("\t\nPromedio de filas");
		for(int filas = 0; filas < matriz.length; filas++){
			int suma = 0;
			for(int columnas = 0; columnas < matriz[filas].length; columnas++){
				suma += matriz[filas][columnas];	
			}
			double promedio = (double) suma / matriz[filas].length;
			System.out.printf("El promedio de la fila %d, es de: %.2f %n", filas, promedio);
		}	
	}

	public static void promedioColumnas(double matriz[][]) {
		System.out.println("\t\nPromedio de columnas");
    	for (int columnas = 0; columnas < matriz[0].length; columnas++) {
        	double suma = 0;
        	for (int filas = 0; filas < matriz.length; filas++) {
            	suma += matriz[filas][columnas];  
        	}
        	double promedio = suma / matriz.length;
        	System.out.printf("El promedio de la columna %d, es de: %.2f%n", columnas, promedio);
    	}   
	}

	public static void mayor(double matriz[][]){
		double mayor = matriz[0][0];
		int cantidadMayores = 1;
		int maxElementos = matriz.length * matriz[0].length;
		// Arreglos para la posicion de los numeros mayores
		int filasMayores[] = new int[maxElementos];
		int columnasMayores[] = new int[maxElementos];
		// Posiciones del primer mayor
		filasMayores[0] = 0;
		columnasMayores[0] = 0;
		System.out.println("\t\nNumero/s mayor/es y su/s posicion/es");
		for(int filas = 0; filas < matriz.length; filas++){
			for(int columnas = 1; columnas < matriz[filas].length; columnas++){
				if(matriz[filas][columnas] > mayor){
					// Se reinicia el contador si se encuentra un nuevo numero mayor
					cantidadMayores = 1;
					mayor = matriz[filas][columnas];
					// Se guarda las posiciones del nuevo numero mayor
					filasMayores[0] = filas;
					columnasMayores[0] = columnas;
				}
				else if(matriz[filas][columnas] == mayor){
					// Guarda la posicion del otro numero mayor
					filasMayores[cantidadMayores] = filas;
					columnasMayores[cantidadMayores] = columnas;
					cantidadMayores++;
				}
			}
		}
		System.out.println("El numero mayor de la matriz es: " + mayor);
		System.out.println("Posicion/es del mayor elemento");
		for(int i = 0; i < cantidadMayores; i++){
			System.out.println("Fila: " + filasMayores[i] + " Columnas: " + columnasMayores[i]);
		}
	}

	public static void menor(double matriz[][]){
		double menor = matriz[0][0];
		int cantidadMenores = 1;
		int maxElementos = matriz.length * matriz[0].length;
		// Arreglos para la posicion de los numeros menores
		int filasMenores[] = new int[maxElementos];
		int columnasMenores[] = new int[maxElementos];
		// Posiciones del primer menor
		filasMenores[0] = 0;
		columnasMenores[0] = 0;
		System.out.println("\t\nNumero/s menor/es y su/s posicion/es");
		for(int filas = 0; filas < matriz.length; filas++){
			for(int columnas = 1; columnas < matriz[filas].length; columnas++){
				if(matriz[filas][columnas] < menor){
					// Se reinicia el contador si se encuentra un nuevo numero menor
					cantidadMenores = 1;
					menor = matriz[filas][columnas];
					// Se guarda las posiciones del nuevo numero menor
					filasMenores[0] = filas;
					columnasMenores[0] = columnas;
				}
				else if(matriz[filas][columnas] == menor){
					// Guarda la posicion del otro numero mayor
					filasMenores[cantidadMenores] = filas;
					columnasMenores[cantidadMenores] = columnas;
					cantidadMenores++;
				}
			}
		}
		System.out.println("El numero menor de la matriz es: " + menor);
		System.out.println("Posicion/es del mayor elemento");
		for(int i = 0; i < cantidadMenores; i++){
			System.out.println("Fila: " + filasMenores[i] + " Columnas: " + columnasMenores[i]);
		}
	}
    public static void main(String[] args) {
		Scanner caracter = new Scanner(System.in);
		Scanner entero = new Scanner(System.in);
		char opcion;
		int filas, columnas;
		do{
			do {
				System.out.print("Ingrese el numero de filas: ");	
				filas = entero.nextInt();
			} while(filas <= 0);
			do {
				System.out.print("Ingrese el numero de columnas: ");	
				columnas = entero.nextInt();
			} while(columnas <= 0);

			double matriz[][] = new double[filas][columnas];

			ingresar(matriz);
			mostrar(matriz);
			mostrarPorcentajes(matriz);
			promedioFilas(matriz);
			promedioColumnas(matriz);
			mayor(matriz);
			menor(matriz);
			
			do{
				System.out.print("Desea repetir el programa? s/n: ");	
				opcion = caracter.next().charAt(0);
				// Convierte opcion a minusculas
				opcion = Character.toLowerCase(opcion);
			}while(opcion != 's' && opcion != 'n');
		}while(opcion == 's');
		System.out.println("Fin del programa.");
    }
}
