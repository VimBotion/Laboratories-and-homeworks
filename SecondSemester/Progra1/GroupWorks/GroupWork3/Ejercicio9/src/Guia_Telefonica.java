/**
 * 9. Escribir un programa que permita utilizando arreglos paralelos, manejar datos de una guía 
 *	telefónica, los campos de los registros de la guía son: teléfono (número de 7 dígitos en el 
 *	rango 2000000 - 4999999), nombre y dirección.
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Guia_Telefonica {
	public static int existeTelefono(int telefonos[], int elementos_ingresados, int telefono){
		for(int i = 0; i < elementos_ingresados; i++){
			if(telefonos[i] == telefono){
				return i;
			}
		}
		return -1;
	}
	public static int ingresar(int telefonos[], String nombres[], String direcciones[], int elementos_ingresados){
		Scanner entero = new Scanner(System.in);
		Scanner cadena = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);
		char opcion;
		int telefono;
		int indiceTelefono;	
		do {
			do{
				System.out.print("Ingrese numero de telefono: ");
				telefono = entero.nextInt();
				indiceTelefono = existeTelefono(telefonos, elementos_ingresados, telefono);
				if(indiceTelefono != -1){
					System.out.println("El telefono ingresado ya existe");
				}
				if(telefono < 2000000 || telefono > 4999999){
					System.out.println("El telefono no es valido");
				}
			}while(telefono < 2000000 || telefono > 4999999 || indiceTelefono != -1);
			telefonos[elementos_ingresados] = telefono;
				
			System.out.print("Ingrese nombre: ");
			nombres[elementos_ingresados] = cadena.nextLine();

			System.out.print("Ingrese direccion: ");
			direcciones[elementos_ingresados] = cadena.nextLine();
			elementos_ingresados++;
			do {
				System.out.print("Desea seguir ingresando? s/n: ");
				opcion = caracter.next().charAt(0);
				opcion = Character.toLowerCase(opcion);
			}while(opcion != 's' && opcion != 'n');
		} while(opcion == 's');
		return elementos_ingresados;
	}

	public static void listar(int telefonos[], String nombres[], String direcciones[], int elementos_ingresados){
		System.out.println("\tGuia Telefonica");
		System.out.printf("%-10s %-25s %-30s %n", "Telefono", "Nombre", "Direccion");
		for(int i = 0; i < elementos_ingresados; i++){
			System.out.printf("%-10d %-25s %-30s %n", telefonos[i], nombres[i], direcciones[i]);
		}
	}	

	public static void consultar(int telefonos[], String nombres[], String direcciones[], int elementos_ingresados){
		Scanner caracter = new Scanner(System.in);
		Scanner entero = new Scanner(System.in);
		int telefono;
		char opcion;
		do {
			System.out.print("Ingrese numero de telefono: ");
			telefono = entero.nextInt();
			int indiceTelefono = existeTelefono(telefonos, elementos_ingresados, telefono);
			if(indiceTelefono != -1){
				System.out.println("Nombre: " + nombres[indiceTelefono]);
				System.out.println("Direccion: " + direcciones[indiceTelefono]);
			}
			else {
					System.out.println("El numero de telefono " + telefono + " no ha sido encontrado");
			}
			do {
				System.out.print("Desea seguir consultando? s/n: ");
				opcion = caracter.next().charAt(0);
				opcion = Character.toLowerCase(opcion);
			} while(opcion != 's' && opcion != 'n');
		} while(opcion == 's');	
	}

	public static void modificar(int telefonos[], String nombres[], String direcciones[], int elementos_ingresados){
		Scanner entero = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);
		Scanner cadena = new Scanner(System.in);
		int telefono, indiceTelefono;
		char opcion;
		System.out.print("Ingrese numero de telefono: ");
		telefono = entero.nextInt();
		indiceTelefono = existeTelefono(telefonos, elementos_ingresados, telefono);
		do {
			if(indiceTelefono != -1){
				System.out.println("Nombre: " + nombres[indiceTelefono]);
				System.out.println("Direccion: " + direcciones[indiceTelefono]);
				System.out.println("\t1. Modificar nombre");
				System.out.println("\t2. Modificar direccion");
				System.out.println("\t3. Volver al menu principal");
				System.out.print("Que desea realizar? (1-3): ");
				opcion = caracter.next().charAt(0);
				
				switch(opcion){
					case '1':
						System.out.print("Ingrese nombre: ");
						nombres[indiceTelefono] = cadena.nextLine();	
						break;
					case '2':
						System.out.print("Ingrese direccion: ");
						direcciones[indiceTelefono] = cadena.nextLine();	
						break;
					case '3':
						System.out.println("Regresando al menu principal");
						break;
					default:
						System.out.println("Opcion Invalida!");
				}
			}
			else {
					System.out.println(telefono + " No ha sido encontrado");
					break;
			}
			
		} while(opcion != '3');
	}

	public static int eliminar(int telefonos[], String nombres[], String direcciones[], int elementos_ingresados){
		Scanner entero = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);
		int telefono, indiceTelefono;
		char opcion;
		System.out.print("Ingrese numero de telefono: ");
		telefono = entero.nextInt();
		indiceTelefono = existeTelefono(telefonos, elementos_ingresados, telefono);
		if(indiceTelefono != -1){
			System.out.println("Nombre: " + nombres[indiceTelefono]);
			System.out.println("Direccion: " + direcciones[indiceTelefono]);
			do {
				System.out.print("\nDesea eliminar el registro s/n: ");
				opcion = caracter.next().charAt(0);
				opcion = Character.toLowerCase(opcion);
			} while(opcion != 's' && opcion != 'n');
			
			if(opcion == 's'){
				for(int i = indiceTelefono; i < elementos_ingresados - 1; i++){
					telefonos[i] = telefonos[i +1];
					nombres[i] = nombres[i + 1];
					direcciones[i] = direcciones[i + 1];
				}
				elementos_ingresados--;
				return elementos_ingresados;
			}
		}
		System.out.println(telefono + " No ha sido encontrado");
		return -1;
	}
    public static void main(String[] args) {
		final int MAX_TAMANIO = 100;
		char opcion;
		int elementosIngresados = 0;
		Scanner caracter = new Scanner(System.in);
		int telefonos[] = new int[MAX_TAMANIO];
		String nombres[] = new String[MAX_TAMANIO];
		String direcciones[] = new String[MAX_TAMANIO];

		do {
    		System.out.println("Menu");
			System.out.println("1. Ingresar registros");
			System.out.println("2. Listar registros");
			System.out.println("3. Consultar registro por numero telefonico");
			System.out.println("4. Modificar registros");
			System.out.println("5. Eliminar registros");
			System.out.println("6. Salir");
			System.out.print("Que desea realizar? (1-6): ");	
			opcion = caracter.next().charAt(0);

			switch(opcion){
				case '1':
					elementosIngresados = ingresar(telefonos, nombres, direcciones, elementosIngresados);
					break;
				case '2':
					listar(telefonos, nombres, direcciones, elementosIngresados);
					break;
				case '3':
					consultar(telefonos, nombres, direcciones, elementosIngresados);
					break;
				case '4':
					modificar(telefonos, nombres, direcciones, elementosIngresados);
					break;
				case '5':
					// Si se elimino correctamente actualizar el numero de elementos ingresados
					int resultadoEliminar = eliminar(telefonos, nombres, direcciones, elementosIngresados);
					if(resultadoEliminar != -1){
						elementosIngresados = resultadoEliminar;
					}
					else {
						break;	
					}
					break;
				case '6':
					System.out.println("Fin del programa.");
					break;
				default:
					System.out.println("Opcion invalida!");
					break;
			}
		} while(opcion != '6');
	}
}
