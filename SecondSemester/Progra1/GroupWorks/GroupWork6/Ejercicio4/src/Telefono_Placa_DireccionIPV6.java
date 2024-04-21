/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Telefono_Placa_DireccionIPV6 {
	public static boolean validarTelefono(String cadena){
		// Formato del telefono fijo: Codigo de area  numero de telefono, 04 XXX-XXXX
		return cadena.matches("0[2-7]\\s\\d{4}-\\d{3}");
	}

	public static boolean validarPlacaParticular(String cadena){
		// Formato de la placa: ABC-123 o ABC-1234, la primera letra no puede ser D o F y la segunado letra no puede ser A U Z E M
		return cadena.matches("[^DF][^AUZEM][A-Z]-\\d{3,4}");
	}

	public static boolean validarIPV6(String cadena){
		// Desde  0000:0000:0000:0000:0000:0000:0000:0000 hasta ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff en mayusculas o minusculaas
		return cadena.matches("([0-9a-fA-F]{4}:){7}[0-9a-fA-F]{4}");
	}
  public static void main(String[] args) {
		Scanner caracter = new Scanner(System.in);
		Scanner cadena = new Scanner(System.in);
		char repetir, opcion;
		String texto;
		do{
			System.out.print("Ingrese la cadena a ser validada: ");
			texto = cadena.nextLine();
			texto = texto.trim();

			do {
				System.out.println("[1]Telefono convencional para el Ecuador");
				System.out.println("[2]Placa de vehiculo particular para el Ecuador");
				System.out.println("[3]Direccion IPV6");
				System.out.print("Elija una opcion: ");
				opcion = caracter.next().charAt(0);
				switch(opcion){
					case '1':
						if(!validarTelefono(texto)){
							System.out.println("Validacion incorrecta, debe ingresar el codigo de area 0(numero del 2 al 7) seguido de un espacio en blanco y el numero de telefono XXXX-XXX");
						} else {
							System.out.println("Validacion correcta");
						}
						break;
					case '2':
						if(!validarPlacaParticular(texto)){
							System.out.println("Validacion incorrecta, debe ingresar en mayusculas, "
									+ "la primera letra no puede ser D F, la segunda letra no puede ser A U Z E M, ABC-1234 o ABC-123");
						}else{
							System.out.println("Validacion correcta");
						}
						break;
					case '3':
						if(!validarIPV6(texto)){
							System.out.println("Validacion incorrecta, debe ingresar 8 grupos de 4 numeros hexadecimales (0-f) separados por :, "
									+ "desde 0000:0000:0000:0000:0000:0000:0000:0000 hasta ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff");
						} else{
							System.out.println("Validacion correcta");
						}
						break;
					default:
						System.out.println("Opcion invalida");
				}
			}while(opcion != '1' && opcion != '2' && opcion != '3');
			do{
				System.out.print("Desea repetir el programa? (s/n): ");
				repetir = caracter.next().charAt(0);
				repetir = Character.toLowerCase(repetir);
				if(repetir != 's' && repetir != 'n'){
					System.out.println("Escoga s o n");
				}
			}while(repetir != 's' && repetir != 'n');
		}while(repetir == 's');
    }
}