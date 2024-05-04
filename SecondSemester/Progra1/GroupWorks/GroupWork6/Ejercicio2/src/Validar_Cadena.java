/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Validar_Cadena {
	public static boolean validar_S_N(String texto){
		return texto.matches("[sSnN]");
	}
	public static boolean validarEntero(String texto){
		return texto.matches("\\d{3,9}[1-9]");
	}
	public static boolean validarEnteroReal(String texto){
		return texto.matches("[+-]?\\d+(\\.\\d+)?");
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
				System.out.println("[1]Letras s, S, n, N");
				System.out.println("[2]Numero entero de 3 a 10 digitos, el ultimo digito debe ser distinto de cero");
				System.out.println("[3]Numero entero o real, con o sin signo");
				System.out.print("Elija una opcion: ");
				opcion = caracter.next().charAt(0);
				switch(opcion){
					case '1':
						if(!validar_S_N(texto)){
							System.out.println("Validacion incorrecta, debe ingresar solamente las letras: s, S, n, N");
						}else{
							System.out.println("Validacion correcta");
						}
						break;
					case '2':
						if(!validarEntero(texto)){
							System.out.println("Validacion incorrecta, debe ingresar un numero entero de 3 a 10 digitos, el ultimo digito debe ser distinto de 0");
						} else{
							System.out.println("Validacion correcta");
						}
						break;
					case '3':
						if(!validarEnteroReal(texto)){
							System.out.println("Validacion incorrecta, debe ingresar un numero entero o real con o sin signo");
						}else{
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
					System.out.println("Escoja s o n");
				}
			}while(repetir != 's' && repetir != 'n');
		}while(repetir == 's');
    }
}
