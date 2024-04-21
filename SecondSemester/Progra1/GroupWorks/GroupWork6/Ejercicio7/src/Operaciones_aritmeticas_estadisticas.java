/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Operaciones_aritmeticas_estadisticas {
	public static boolean validarCadena(String cadena){
		return cadena.matches("\\d+(\\s{1}\\d+)*");
	}

	public static int[] generarArregloEnteros(String[] arregloCadena){
		int[] arregloEnteros = new int[arregloCadena.length];
		
		for(int i = 0; i < arregloCadena.length; i++){
			arregloEnteros[i] = Integer.parseInt(arregloCadena[i]);
		}
		return arregloEnteros;
	} 	

	public static int suma(int[] arreglo){
		int suma = 0;
		for(int item : arreglo){
			suma += item;
		}
		return suma;
	}

	public static double mediaAritmetica(int[] arreglo){
		double mediana = 0;
		for(int item : arreglo){
			mediana += item;
		}
		return mediana / (double) arreglo.length;
	}

	public static double desviacionEstandarPoblacional(int[] arreglo){
		double desviacion = 0;
		double media = mediaAritmetica(arreglo);
		for(int item : arreglo){
			desviacion += Math.pow(item - media, 2);
		}

		return Math.sqrt(desviacion / (double) arreglo.length);
	}
	
	public static double varianzaPoblacional(int[] arreglo){
		double varianza = 0;
		double media = mediaAritmetica(arreglo);
		for(int item : arreglo){
			varianza += Math.pow(item - media, 2);
		}

		return varianza / (double) arreglo.length;
	}

	public static double mediana(int[] arreglo){
		ordenarArreglo(arreglo);
		double mediana = 0;
		int mitad = (int) Math.ceil(arreglo.length / 2);
		if(arreglo.length % 2 == 0){
			mediana = (arreglo[mitad] + arreglo[mitad - 1]) / 2.0;
		} else{
			mediana = arreglo[mitad];	
		}
		
		return mediana;
	}

	public static int mayor(int[] arreglo){
		// Como se ordeno el arreglo en el metodo mediana, el mayor es el ultimo elemento
		return arreglo[arreglo.length - 1];
	}

	public static int menor(int[] arreglo){
		// Como se ordeno el arreglo en el metodo mediana, el menor es el primer elemento
		return arreglo[0];
	}

	public static void ordenarArreglo(int[] arreglo){
		for(int i = 0; i < arreglo.length - 1; i++){
			int menor = i;
			for(int j = i + 1; j < arreglo.length; j++){
				if(arreglo[j] < arreglo[menor]){
					menor = j;
				}
			}
			if(i != menor){
				int aux = arreglo[i];
				arreglo[i] = arreglo[menor];
				arreglo[menor] = aux;
			}
		}
	}

	public static int numeroDeOcurrencias(int[] arreglo, int elemento) {
		int conteo = 0;
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i] == elemento) {
				conteo++;
			}
		}
		return conteo;
	}
    public static void mostrarModa(int[] arreglo) {
        int[] modas = moda(arreglo);
        System.out.printf("%-30s", "Moda");
        if (modas.length == 1) {
            int frecuencia = contarOcurrencias(arreglo, modas[0]);
            System.out.printf("%d con %d ocurrencias.%n", modas[0], frecuencia);
        } else {
            for (int moda : modas) {
                int frecuencia = contarOcurrencias(arreglo, moda);
                System.out.printf("%d con %d ocurrencias, ", moda, frecuencia);
            }
            System.out.println();
        }
    }

    public static int[] moda(int[] arreglo) {
        int[] modas;
        int maxFrecuencia = 1;
        int cantidadModas = 0;

        for (int i = 0; i < arreglo.length; i++) {
            int frecuencia = 1;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] == arreglo[j]) {
                    frecuencia++;
                }
            }
            if (frecuencia == maxFrecuencia) {
                cantidadModas++;
            } else if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                cantidadModas = 1;
            }
        }

        modas = new int[cantidadModas];
        int index = 0;
        for (int i = 0; i < arreglo.length; i++) {
            int frecuencia = 1;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] == arreglo[j]) {
                    frecuencia++;
                }
            }
            if (frecuencia == maxFrecuencia && !contains(modas, arreglo[i])) {
                modas[index++] = arreglo[i];
            }
        }

        return modas;
    }

    public static boolean contains(int[] array, int number) {
        for (int i : array) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }

    public static int contarOcurrencias(int[] arreglo, int numero) {
        int frecuencia = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == numero) {
                frecuencia++;
            }
        }
        return frecuencia;
    }
	

	public static void mostrarResultados(int[] arreglo) {
		System.out.printf("%-30s %d %n", "Suma", suma(arreglo));
		System.out.printf("%-30s %.2f %n", "Media Aritmetica", mediaAritmetica(arreglo));
		System.out.printf("%-30s %.2f %n", "Desviacion Estandar", desviacionEstandarPoblacional(arreglo));
		System.out.printf("%-30s %.2f %n", "Varianza Poblacional", varianzaPoblacional(arreglo));
		System.out.printf("%-30s %.2f %n", "Mediana", mediana(arreglo));
		mostrarModa(arreglo);
		System.out.printf("%-30s %d %n", "Mayor", mayor(arreglo));
		System.out.printf("%-30s %d %n", "Menor", menor(arreglo));
	}


	public static void main(String[] args){
		Scanner cadena = new Scanner(System.in);
		String repeticion, texto;
		do{
			do{
				System.out.print("Ingrese la cadena: ");
				texto = cadena.nextLine();
				texto = texto.trim();
				if(!validarCadena(texto)){
					System.out.println("Ingrese solo digitos separados por un espacio en blanco");
				}	
			}while(!validarCadena(texto));

			String[] arregloCadenas = texto.split(" ");
			int[] arregloEnteros = generarArregloEnteros(arregloCadenas);

			mostrarResultados(arregloEnteros);

			do{
				System.out.print("Desea repetir el programa? (s/n): ");
				repeticion = cadena.nextLine();
				if(!repeticion.matches("[sSnN]")){
					System.out.println("Escoja s o n");
				}
			}while(!repeticion.matches("[sSnN]"));
		}while(repeticion.matches("[sS]"));
	}	
}
