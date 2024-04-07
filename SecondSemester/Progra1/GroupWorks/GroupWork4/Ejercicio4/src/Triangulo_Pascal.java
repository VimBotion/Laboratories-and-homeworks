/**
 * 4. Escribir un programa que permita utilizando una matriz, crear e imprimir el triángulo de Pascal
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Triangulo_Pascal {
	public static void dibujarTriangulo(int matriz[][]){
		int tamano = matriz.length;
		for(int i = 0; i < tamano; i++){
			// Imprime los espacios en blanco en cada linea
			for(int k = 0; k < tamano - i - 1; k++){
				System.out.print(" ");
			}

			for(int j = 0; j <= i; j++){
				// El valor de la primera y ultima columna se convierte en 1
				if(j == 0 || j == i){
					matriz[i][j] = 1;
				}
				else{
					matriz[i][j] = matriz[i - 1][j - 1] + matriz[i - 1][j];
				}
				System.out.print(matriz[i][j] +" ");
			}
			System.out.println("");
		}
	}
    public static void main(String[] args) {
		Scanner entero = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);
		int lineas;
		char opcion;
		do {
			do{
				System.out.print("Ingrese el numero de lineas del triangulo de Pascal: ");
				lineas = entero.nextInt();
			}while(lineas <= 0);
			int matriz[][] = new int[lineas][lineas];
			dibujarTriangulo(matriz);
			do{
				System.out.print("Desea repetir el programa? s/n: ");
				opcion = caracter.next().charAt(0);
				opcion = Character.toLowerCase(opcion);
			}while(opcion != 's' && opcion != 'n');	
		} while(opcion == 's');
    }
}
