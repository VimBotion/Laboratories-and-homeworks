/**
 *
 * @author Campoverde Esteban
 */
import java.util.Scanner;
public class Desviacion_Estandas {
	public static void ingresar(int vector[]){
		Scanner entero = new Scanner(System.in);
		int numero;
		for(int i = 0; i < vector.length; i++){
			do {
				System.out.print("Ingrese el elemento #" + (i +1) + ": ");
				numero = entero.nextInt();
				if(numero < 0){
					System.out.println("El numero debe ser un entero positivo");
				}
			} while(numero < 0);
			vector[i] = numero;
		}
	}
	
	public static void mostrar(int vector[]){
		System.out.println("El arreglo es: ");
		for(int i = 0; i < vector.length; i++){
			System.out.print(vector[i] + " ");
		}
	}
	public static int sumar(int vector[]){
		int suma = 0;
		for(int i = 0; i < vector.length; i++){
			suma += vector[i];
		}
		return suma;
	}

	public static void mostrarSuma(int vector[]){
		System.out.print("La suma de los elementos del arreglo es: " + sumar(vector));
	}

	public static double promediar(int vector[]){
		return (sumar(vector) / (double) vector.length);
	}

	public static void mostrarPromedio(int vector[]){
		System.out.printf("El promedio es: %.2f", promediar(vector));
	}

	public static double desviacionEstandar(int vector[]){
		double suma = 0;
		double promedio = promediar(vector); 
		for(int i = 0; i < vector.length; i++){
			suma += Math.pow(vector[i] - promedio, 2);
		}
		return Math.sqrt(suma / (double) vector.length);
	}

	public static void mostrarDesviacionE(int vector[]){
		System.out.printf("La desviacion estandar es: %.2f", desviacionEstandar(vector));
	}

public static void contarOcurrencias(int vector[]) {
    for (int i = 0; i < vector.length; i++) {
        int suma = 0;
        boolean yaImpreso = false;
        
        for (int j = 0; j < i; j++) {
            if (vector[j] == vector[i]) {
                yaImpreso = true;
                break;
            }
        }
        
        if (!yaImpreso) {
            for (int j = 0; j < vector.length; j++) {
                if (vector[j] == vector[i]) {
                    suma++;
                }
            }
            System.out.println("El numero de ocurrencias del numero: " + vector[i] + " es de: " + suma);
        }
    }
}


    public static void main(String[] args) {
		int tamano;
		char opcion;
		int vector[] = null;
		Scanner entero = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);
		do {
			System.out.println("\t\nMenu");	
			System.out.println("1. Ingresar datos");	
			System.out.println("2. Calcular la suma");	
			System.out.println("3. Calcular el promedio");	
			System.out.println("4. Calcular la desviacion estandar");	
			System.out.println("5. Calcular el numero de ocurrencias de cada valor");	
			System.out.println("6. Salir");	
			System.out.print("Que desea realizar: ");
			opcion = caracter.next().charAt(0);

			switch(opcion){
				case '1':
					do {
						System.out.print("Cuantos elementos va a ingresar: ");	
						tamano = entero.nextInt();
					}while(tamano <= 0);
					vector = new int[tamano];
					ingresar(vector);
					mostrar(vector);
					break;
				case '2':
					if(vector != null){
						mostrarSuma(vector);
					}
					else {
						System.out.println("Ingrese datos primero!");
					}
					break;
				case '3':
					if(vector != null){
						mostrarPromedio(vector);
					}
					else {
						System.out.println("Ingrese datos primero!");
					}
					break;
				case '4':
					if(vector != null){
						mostrarDesviacionE(vector);
					}
					else {
						System.out.println("Ingrese datos primero!");
					}
					break;
				case '5':
					if(vector != null){
						contarOcurrencias(vector);
					}
					else {
						System.out.println("Ingrese datos primero!");
					}
					break;
				case '6':
					System.out.println("Fin del programa");
					break;
				default:
					System.out.println("Opcion invalida");
			}
		}while(opcion != '6');
    }
}
