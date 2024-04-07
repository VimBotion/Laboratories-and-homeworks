/**
 * 7. Resolver un sistema de ecuaciones utilizando determinantes 
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Sistema_Ecuaciones {
    public static void ingresarCoeficientes(double coeficientes[][]) {
        Scanner real = new Scanner(System.in);
        System.out.println("Ingrese los coeficientes de las ecuaciones:");
        for (int i = 0; i < coeficientes.length; i++) {
            for (int j = 0; j < coeficientes[0].length; j++) {
                System.out.print("Coeficiente para x" + (j + 1) + " en la ecuación " + (i + 1) + ": ");
                coeficientes[i][j] = real.nextDouble();
            }
        }
    }

    public static void ingresarIndependientes(double independiente[]) {
        Scanner real = new Scanner(System.in);
        System.out.println("Ingrese los valores independientes:");

        for (int i = 0; i < independiente.length; i++) {
            System.out.print("Valor independiente para la ecuación " + (i + 1) + ": ");
            independiente[i] = real.nextDouble();
        }
    }
	
	// Devuelve una sub-matriz eliminando la fila y columna del parametro
	public static double[][] minor(double[][] matriz, int fila, int columna) {
        int tamano = matriz.length;
        double[][] menor = new double[tamano - 1][tamano - 1]; 
        int mFila = 0;
        for (int i = 0; i < tamano; i++) {
			// Omite los valores de la fila especificssssada
            if (i == fila) {
                continue;
            }
            int mColumna = 0;
            for (int j = 0; j < tamano; j++) {
				// Omite los valores de la columna especificada
                if (j == columna) {
                    continue;
                }
                menor[mFila][mColumna] = matriz[i][j];
                mColumna++;
            }
            mFila++;
        }
        return menor;
    }

	// Cofactor = determinante de una submatriz menor, cuyo signo depende de la posicion
    public static double cofactor(double[][] matriz, int fila, int columna) {
		// Math.pow(-1, fila + columna) calcula el signo del cofactor
        return Math.pow(-1, fila + columna) * determinante(minor(matriz, fila, columna));
    }

    public static double determinante(double[][] matriz) {
        int tamano = matriz.length;
        if (tamano == 1) {
            return matriz[0][0];
        }
        double det = 0;
        for (int j = 0; j < tamano; j++) {
			// El determinante = suma de la multiplicacion de los cofactores de los elementos de la primera fila * elemento
            det += matriz[0][j] * cofactor(matriz, 0, j);
        }
        return det;
    }
	

	// Retorna un array de soluciones mediante el metodo de Cramer
    public static double[] resolverEcuaciones(double[][] coeficientes, double[] independiente) {
        int tamano = coeficientes.length;
		
		// Calcula el determinante del sistema
        double determinanteA = determinante(coeficientes);

        if (determinanteA == 0) {
            // El sistema no tiene solución
            return null;
        }

        double[] solucion = new double[tamano];

		
        for (int i = 0; i < tamano; i++) {
			// Crea una matriz temporal
            double[][] matrizTemp = new double[tamano][tamano];
            for (int j = 0; j < tamano; j++) {
                for (int k = 0; k < tamano; k++) {
                    if (k == i) {
						// Los valores independientes son los valores de la columna 0
                        matrizTemp[j][k] = independiente[j];
                    } else {
                        matrizTemp[j][k] = coeficientes[j][k];
                    }
                }
            }
			// Solucion de cada incognica = determinante Matriz / determinante del Sistema
            solucion[i] = determinante(matrizTemp) / determinanteA;
        }

        return solucion;
    }

    public static double[][] calcularMatrizInversa(double[][] matriz) {
        int n = matriz.length;
        double[][] identidad = new double[n][n];
        double[][] matrizInversa = new double[n][n];

        // Inicializa la matriz identidad
        for (int i = 0; i < n; i++) {
			// Matriz identidad: Los elementos de la diagona principal valen 1, los demas 0
            identidad[i][i] = 1;
        }

		// Metodo: eliminacion gauss jordan
        for (int i = 0; i < n; i++) {
            double pivot = matriz[i][i];

            for (int j = 0; j < n; j++) {
                matriz[i][j] /= pivot;
                identidad[i][j] /= pivot;
            }
			
			// Elimina las otras filas
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    for (int j = 0; j < n; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                        identidad[k][j] -= factor * identidad[i][j];
                    }
                }
            }
        }
		// La matriz original se convierte en una matriz identidad y viceversa
		// Devuelve la matriz identidad, contiene los elementos de la matriz inversa
        return identidad;
    }

    public static void mostrarMatriz(double[][] matriz, String mensaje) {
        System.out.println(mensaje);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%-10.4f ", matriz[i][j]);
            }
            System.out.println();
        }
    }

	public static void mostrarArreglo(double[] arreglo, String mensaje){
		System.out.println(mensaje);
		for(int i = 0; i < arreglo.length; i++){
			System.out.println(arreglo[i]);
		}
	}

    public static void main(String[] args) {
        Scanner entero = new Scanner(System.in);
        Scanner caracter = new Scanner(System.in);
        int tamano;
        char opcion;
        do {
            do {
                System.out.print("Ingrese el número de ecuaciones: ");
                tamano = entero.nextInt();
                if (tamano < 2) {
                    System.out.println("El numero de ecuaciones debe ser mayor a 1");
                }
            } while (tamano < 2);

            double[][] coeficientes = new double[tamano][tamano];
            double[] independiente = new double[tamano];
            ingresarCoeficientes(coeficientes);
            ingresarIndependientes(independiente);

            double[] solucion = resolverEcuaciones(coeficientes, independiente);

            if (solucion != null) {
				mostrarMatriz(coeficientes, "\nMatriz de coeficientes");
				mostrarArreglo(independiente, "\nVector de terminos independientes");
                System.out.println("\nSolución:");
                double[][] inversa = calcularMatrizInversa(coeficientes);
                mostrarMatriz(inversa, "\nMatriz Inversa:");
                for (int i = 0; i < solucion.length; i++) {
                    System.out.printf("x%d = %.2f %n", (i + 1), solucion[i]);
                }
            } else {
                System.out.println("No existe solución.");
            }

            do {
                System.out.print("Desea repetir el programa? s/n: ");
                opcion = caracter.next().charAt(0);
                opcion = Character.toLowerCase(opcion);
            } while (opcion != 's' && opcion != 'n');
        } while (opcion == 's');
    }
}