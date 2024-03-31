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

	public static void sumarVotos(int votos[], int contador[], int elementos_ingresados){
		int posicion;

		for(int i = 0; i < contador.length; i++){
			contador[i] = 0;
		}

		for(int j = 0; j < elementos_ingresados; j++){
			// Las posiciones se asignan segun el voto desde 1 - 4, el index 0 no es tomado en cuenta
			posicion = votos[j];
			contador[posicion]++;
		}
	}
	
	public static double calcularPorcentaje(int votosCandidato, int elementos_ingresados){
		return (votosCandidato / (double) elementos_ingresados) * 100.0;
	}	

	public static void determinarGanador(int contador[], int elementos_ingresados){
		// Uno es la posicion del primer candidato
		int posibleGanador = contador[1];
		int indicePosibleGanador = 1;
		boolean empate = false;
		// i = 2 para comparar desde el segundo candidato
		for(int i = 2; i < contador.length; i++){
			if(contador[i] > posibleGanador){
				posibleGanador = contador[i];
				indicePosibleGanador = i;
			}
			else if(contador[i] == posibleGanador){
				empate = true;
			}
		}
		if(!empate){
			double porcentaje = calcularPorcentaje(contador[indicePosibleGanador], elementos_ingresados);
			System.out.printf("El candidato %d con %d votos correspondientes al %.2f%% es el ganador %n", indicePosibleGanador, contador[indicePosibleGanador], porcentaje);
		}else{
			for(int i = 1; i < contador.length; i++){
				if(contador[i] == posibleGanador && i != indicePosibleGanador){
					double porcentaje = calcularPorcentaje(contador[i], elementos_ingresados);
					System.out.printf("Los candidatos %d y %d empatan con %d votos correspondiente al %.2f%% %n", i, indicePosibleGanador, contador[i], porcentaje);
					break;
				}
			}	
		}
	}

	public static void mostrarResultados(int contador[], int elementos_ingresados){
		System.out.println("\t\nResultados");
		System.out.println("Total de votantes: " + elementos_ingresados);
		System.out.printf("%10s %10s %15s %n", "Candidato", "Votos", "Porcentaje");
		for(int i = 1; i < contador.length; i++){
			double porcentaje = calcularPorcentaje(contador[i], elementos_ingresados);
			System.out.printf("%10d %10d %15.2f%% %n", i, contador[i], porcentaje);
		}

		determinarGanador(contador, elementos_ingresados);
	}
	
    public static void main(String[] args) {
		Scanner caracter = new Scanner(System.in);
		char opcion;
		int votos[] = new int[100];
		int contador[] = new int[5];
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
					sumarVotos(votos, contador, elementosIngresados);
					mostrarResultados(contador, elementosIngresados);
					break;
				case '4':
					System.out.println("Fin del programa");
					break;
				default:
					System.out.println("Opcion invalida");
			}
		} while(opcion != '4');
    }
}
