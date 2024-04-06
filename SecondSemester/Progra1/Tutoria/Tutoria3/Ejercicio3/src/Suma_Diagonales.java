/**
 *
 * @author Campoverde Esteban
 */
import java.util.Scanner;
public class Suma_Diagonales {
	public static void ingresar(int matriz[][]){
		Scanner entero = new Scanner(System.in);
		for(int i = 0; i < matriz.length; i++){
			for(int j = 0; j < matriz.length; j++){
				System.out.print("Elemento["+ i +"]["+ j +"]: ");
				matriz[i][j] = entero.nextInt();
			}
		}
	}
	public static void mostrar(int matriz[][]){
		System.out.println("Matriz: ");
		for(int i = 0; i < matriz.length; i++){
			for(int j = 0; j < matriz[0].length; j++){
				System.out.print(matriz[i][j] + "\t ");
			}
			System.out.println("");
		}
	}
	public static int sumDiagonalPrincipal(int matriz[][]){
		int suma = 0;
		for(int i = 0; i < matriz.length; i++){
				suma += matriz[i][i]; 
		}
		return suma;
	}

	public static int sumDiagonalMenor(int matriz[][]){
		int suma = 0;
		for(int i = 0; i < matriz.length; i++){
			suma += matriz[i][matriz.length - i - 1];
		}
		return suma;
	}

	public static int sumaEntreDiagonales(int matriz[][]){
		return sumDiagonalPrincipal(matriz) + sumDiagonalMenor(matriz);
	}

	public static void mostrarSumas(int matriz[][]){
		System.out.println("La suma de los elementos de la diagonal mayor: " + sumDiagonalPrincipal(matriz));
		System.out.println("La suma de los elementos de la diagonal menor: " + sumDiagonalMenor(matriz));
		System.out.println("La suma entre diagonales: " + sumaEntreDiagonales(matriz));
	}

public static void mostrarEspiral(int matriz[][]) {
    int tamano = matriz.length;
    int arriba = 0, abajo = tamano - 1, izquierda = 0, derecha = tamano - 1;
    
    while (arriba <= abajo && izquierda <= derecha) {
        for (int i = izquierda; i <= derecha; i++) {
            System.out.print(matriz[arriba][i] + " ");
        }
        arriba++; 

        for (int i = arriba; i <= abajo; i++) {
            System.out.print(matriz[i][derecha] + " ");
        }
        derecha--;

        if (arriba <= abajo) {
            for (int i = derecha; i >= izquierda; i--) {
                System.out.print(matriz[abajo][i] + " ");
            }
            abajo--;
        }

        if (izquierda <= derecha) {
            for (int i = abajo; i >= arriba; i--) {
                System.out.print(matriz[i][izquierda] + " ");
            }
            izquierda++;
        }
    }
    System.out.println();
}


	public static void modificar(int matriz[][]){
		Scanner entero = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);
		int filas, columnas;
		char opcion;
		mostrar(matriz);
		// El usuario ingresa desde 1, sin tomar en cuenta zero index
		System.out.println("En que posicion se encuentra el elemento a modificar? (1-" + matriz.length * matriz.length + "):");
		do {
			System.out.print("Fila: ");
			filas = entero.nextInt();
			System.out.print("Columna: ");
			columnas = entero.nextInt();

			if(filas <= 0 || columnas <= 0 || filas > matriz.length || columnas > matriz.length){
				System.out.println("Ingrese una posicion valida");
			}
		}while(filas <= 0 || columnas <= 0 || filas > matriz.length || columnas > matriz.length);
		// Se resta menos porque los arreglos empiezan desde 0

		System.out.println("El elemento a modificar es: " + matriz[filas - 1][columnas - 1]);
		do {
			System.out.print("Desea modificar? s/n: ");	
			opcion = caracter.next().charAt(0);
			opcion = Character.toLowerCase(opcion);
		}while(opcion != 's' && opcion != 'n');

		if(opcion == 's'){
			System.out.print("Ingrese el nuevo valor: ");	
			matriz[filas - 1][columnas - 1] = entero.nextInt();
		}
		else {
			System.out.print("Regresando al menu principal");	
		}
	}


	 
    public static void main(String[] args) {
		int tamano;
		char opcion;
		int matriz[][] = null;
		Scanner caracter = new Scanner(System.in);
		Scanner entero = new Scanner(System.in);

		do {
			System.out.println("\n\tMenu");
			System.out.println("1. Ingresar Datos");
			System.out.println("2. Mostrar matriz");
			System.out.println("3. Sumar diagonales");
			System.out.println("4. Mostrar en Espiral");
			System.out.println("5. Modificar elemento");
			System.out.println("6. Salir");
			System.out.println("Que desea realizar: ");
			opcion = caracter.next().charAt(0);

			switch(opcion){
				case '1':
					do {
						System.out.print("Ingrese el tamano de la matriz: ");
						tamano = entero.nextInt();
					}while(tamano <= 0);
					matriz = new int[tamano][tamano];
					ingresar(matriz);
					break;
				case '2':
					if(matriz != null){
						mostrar(matriz);
					} else{
						System.out.println("Ingrese datos a la matriz");
					}
					break;
				case '3':
					if(matriz != null){
						mostrarSumas(matriz);
					} else{
						System.out.println("Ingrese datos a la matriz");
					}
					break;
				case '4':
					if(matriz != null){
						mostrarEspiral(matriz);
					} else{
						System.out.println("Ingrese datos a la matriz");
					}
					break;
				case '5':
					if(matriz != null){
						modificar(matriz);
					} else{
						System.out.println("Ingrese datos a la matriz");
					}
					break;
				case '6':
					System.out.println("Fin del Programa");
					break;
				default:
					System.out.println("Opcion invalida");
			}
		}while(opcion != '6');
    }
}
