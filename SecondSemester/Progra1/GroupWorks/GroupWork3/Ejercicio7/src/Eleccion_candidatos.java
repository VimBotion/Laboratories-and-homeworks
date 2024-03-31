/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Eleccion_candidatos {
	public static int ingresar(int votos[], int elementos_ingresados){
		char opcion;
		int voto;
		Scanner caracter = new Scanner(System.in);
		Scanner entero = new Scanner(System.in);
		System.out.println("\tIngreso de votos");
		System.out.println("Candidatos disponibles: 1 al 4");
		do{
			do {
				System.out.print("Ingrese voto: ");
				voto = entero.nextInt();
				// Candidatos validos: 1 al 4
				if(voto < 1 || voto > 4){
					System.out.println("Candidato no valido!");
				}
			} while(voto < 1 || voto > 4);
			votos[elementos_ingresados] = voto;
			elementos_ingresados++;
			// Repeticion del ingreso de votos
			do{
				System.out.print("Desea continuar S/N: ");
				opcion = caracter.next().charAt(0);
				// Convierte opcion a mayusculas
				opcion = Character.toUpperCase(opcion);
			}while(opcion != 'S' && opcion != 'N');
		}while(opcion == 'S');

		return elementos_ingresados;
	}

	public static void listar(int votos[], int elementos_ingresados){
		System.out.println("\n\t Listado de votos");
		for(int i = 0; i < elementos_ingresados; i++){
			System.out.println(votos[i] + "");
		}
	}
    public static void main(String[] args) {
		Scanner caracter = new Scanner(System.in);
		char opcion;
		int votos[] = new int[100];
		int contador[] = new int[4];
		int elementosIngresados = 0;	
		do {
			
			System.out.println("\nPrograma para calcular los votos en una Eleccion");
			System.out.println("1. Ingresar votos");
			System.out.println("2. Listar votos");
			System.out.println("3. Mostrar resultados");
			System.out.println("4. Salir");
			System.out.print("Que desea realizar? (1-4): ");
			opcion = caracter.next().charAt(0);
			switch(opcion){
				case '1':
					// Ingresar pide el voto y devuelve el numero de votos existentes en el arreglo 
					elementosIngresados = ingresar(votos, elementosIngresados);
					break;
				case '2':
					listar(votos, elementosIngresados);
					break;
				case '3':
					break;
				case '4':
					break;
				default:
					System.out.println("Opcion invalida");
			}
		} while(opcion != '4');
    }
}
