/**
 *
 * @author Campoverde Esteban
 */
import java.util.Scanner;
public class Operaciones_Matrices {
	public static int[][] suma(int matrizA[][], int matrizB[][]){
		int matrizResultado[][] = new int[matrizA.length][matrizA.length];
		for(int i = 0; i < matrizResultado.length; i++){
			for(int j = 0; j < matrizResultado[0].length; j++){
				matrizResultado[i][j] = matrizA[i][j] + matrizB[i][j];
			}
		}
		return matrizResultado;
	}
	public static int[][] resta(int matrizA[][], int matrizB[][]){
		int matrizResultado[][] = new int[matrizA.length][matrizA.length];
		for(int i = 0; i < matrizResultado.length; i++){
			for(int j = 0; j < matrizResultado[0].length; j++){
				matrizResultado[i][j] = matrizA[i][j] - matrizB[i][j];
			}
		}
		return matrizResultado;
	}

	public static void mostrar(int matriz[][]){
		for(int i = 0; i < matriz.length; i++){
			for(int j = 0; j < matriz[0].length; j++){
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void ingresar(int matriz[][]){
		Scanner entero = new Scanner(System.in);
		for(int i = 0; i < matriz.length; i++){
			for(int j = 0; j < matriz[0].length; j++){
				System.out.print("Elemento["+ i +"]["+ j +"]=");
				matriz[i][j] = entero.nextInt();
			}
		}
	}
    public static void main(String[] args) {
		int tamano;
		Scanner entero = new Scanner(System.in);
		do {
			System.out.print("Ingrese el tamano de las matrices: ");
			tamano = entero.nextInt();
		}while(tamano < 0);
		int matrizA[][] = new int[tamano][tamano];
		System.out.println("Ingrese los elementos de la matriz A: ");
		ingresar(matrizA);
		mostrar(matrizA);
		int matrizB[][] = new int[tamano][tamano];
		System.out.println("Ingrese los elementos de la matriz B: ");
		ingresar(matrizB);
		mostrar(matrizB);
		
		int matrizResultadoSuma[][] = suma(matrizA, matrizB);
		System.out.println("El resultado de la suma de las matrices es: ");
		mostrar(matrizResultadoSuma);
		int matrizResultadoResta[][] = resta(matrizA, matrizB);
		System.out.println("El resultado de la resta de las matrices es: ");
		mostrar(matrizResultadoResta);
    }
}
