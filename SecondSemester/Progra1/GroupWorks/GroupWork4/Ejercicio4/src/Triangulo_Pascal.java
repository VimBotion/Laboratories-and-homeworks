/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Triangulo_Pascal {
	public static void inicializarMatriz(int matriz[][]){
		for(int i = 0; i < matriz.length; i++){
			for(int j = 0; j < matriz[0].length; j++){
				matriz[i][j] = 1;
			}
		}
	}
			
	public static void dibujarTriangulo(int matriz[][]){
		inicializarMatriz(matriz);
		for(int i = 0; i < matriz.length; i++){
			for(int j = 0; j < i + 1; j++){
				if (i > 2 && j > 2){
					matriz[i][j] = matriz[i - 1][j - 1] + matriz[i-1][j];
				}
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}
	}
    public static void main(String[] args) {
		Scanner entero = new Scanner(System.in);
		int lineas;
		do{
			System.out.print("Ingrese el numero de lineas del triangulo de Pascal: ");
			lineas = entero.nextInt();
		}while(lineas <= 0);
		int matriz[][] = new int[lineas][lineas];
		dibujarTriangulo(matriz);
    }
}
