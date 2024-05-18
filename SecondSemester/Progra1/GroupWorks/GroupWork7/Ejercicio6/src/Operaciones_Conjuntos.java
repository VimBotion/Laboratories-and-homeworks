/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
public class Operaciones_Conjuntos {
	public static boolean validarIngreso(String texto){
		return(texto.matches("\\w(,\\w)*\\s\\w(,\\w)*"));
	}

	public static boolean existeDuplicado(String[] conjunto){
		Set<String> sinDuplicados = new HashSet<>();
		for(String elemento : conjunto){
			// add() devuelve true si se anadio un elemento
			if(!sinDuplicados.add(elemento)){
				// No se pudo anadir un elemento
				return true; // Existe duplicado
			}
		}
		return false;
	}

	public static boolean sonIguales(String[] conjunto1, String[] conjunto2){
		Arrays.sort(conjunto1);
		Arrays.sort(conjunto2);
		return Arrays.equals(conjunto1, conjunto2);
	}

	public static Set<String> union(String[] conjunto1, String[] conjunto2){
		Set<String> conjuntoA = new HashSet<>(Arrays.asList(conjunto1));
		Set<String> conjuntoB = new HashSet<>(Arrays.asList(conjunto2));
		// Anade los elementos sin repetir del conjunto B
		conjuntoA.addAll(conjuntoB);
		return conjuntoA;
	}

	public static Set<String> diferenciaSimetrica(String[] conjunto1, String[] conjunto2){
		Set<String> conjuntoA = new HashSet<>(Arrays.asList(conjunto1));
		Set<String> conjuntoB = new HashSet<>(Arrays.asList(conjunto2));

		Set<String> diferenciaSimetrica = new HashSet<>(conjuntoA);
		diferenciaSimetrica.addAll(conjuntoB);

		// Guarda los elementos comunes entre ambos conjuntos
		Set<String> interseccion = new HashSet<>(conjuntoA);
		interseccion.retainAll(conjuntoB);

		diferenciaSimetrica.removeAll(interseccion);

		return diferenciaSimetrica;
	}

	public static Set<String> productoCartesiano(String[] conjunto1, String[] conjunto2){
		Set<String> productoCartesiano = new HashSet<>();
		for(String item : conjunto1){
			for(String item2 : conjunto2){
				productoCartesiano.add("(" + item + "," + item2 + ")");
			}
		}
		return productoCartesiano;
	}
	
    public static void main(String[] args) {
		Scanner cadena = new Scanner(System.in);
		String texto, repeticion;
		String[] conjunto1, conjunto2;
		do{
			do{
				do{
					System.out.print("Ingrese conjuntos: ");
					texto = cadena.nextLine();
					if(!validarIngreso(texto)){
						System.out.println("Debe ingresarse dos conjuntos separados por un espacio en blanco, cada elemento del conjunto debe estar separado por una coma");
					}
				}while(!validarIngreso(texto));

				String[] conjuntos = texto.split(" ");
				conjunto1 = conjuntos[0].split(",");
				conjunto2 = conjuntos[1].split(",");

				if(existeDuplicado(conjunto1) || existeDuplicado(conjunto2)){
					System.out.println("Los elementos de los conjuntos no deben repetirse");
				}
			}while(existeDuplicado(conjunto1) ||  existeDuplicado(conjunto2));

			if(sonIguales(conjunto1, conjunto2)){
				System.out.println("Los conjuntos son iguales");
			}
			Set<String> union = union(conjunto1, conjunto2);
			System.out.println("La union es: " + union);
			Set<String> diferenciaSimetrica = diferenciaSimetrica(conjunto1, conjunto2);
			if(diferenciaSimetrica.isEmpty()){
				System.out.println("No existe diferencia simetrica");
			}
			else {
				System.out.println("La diferencia simetrica es " + diferenciaSimetrica);
			}
			Set<String>	productoCartesiano = productoCartesiano(conjunto1, conjunto2);
			System.out.println("EL producto cartesiano es: " + productoCartesiano);
			do{
				System.out.print("Desea repetir el programa? (s/n): ");	
				repeticion = cadena.nextLine();
			}while(!repeticion.matches("[sSnN]"));
		}while(repeticion.matches("[sS]"));
    }
}
