/**
 *
 * @author Campoverde Esteban
 */
import java.util.Scanner;
public class Validacion_Gtin {
	public static boolean validarCadena(String cadena){
		cadena = cadena.trim();
		return cadena.matches("\\d{13}+");
	}
	
	public static boolean validarGtin(String cadena){
		int digitoVerificador = cadena.charAt(12) - '0';
		int suma = 0;
		for(int i = cadena.length() - 2; i >= 0; i--){
			int digito = cadena.charAt(i) - '0';
			if(i % 2 == 0){
				suma += digito * 1;
			} else {
				suma += digito * 3;
			}
		}

		int residuo = suma % 10;
		int verificador = 0;
		if(residuo != 0){
			verificador = 10 - residuo;
		}
		return verificador == digitoVerificador;
	}
    public static void main(String[] args) {
		Scanner cadena = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);
		char opcion;
		String gtin;
		do {
			do{
				System.out.print("Ingrese el codigo: ");
				gtin = cadena.nextLine();
				if(!validarCadena(gtin)){
					System.out.println("El codigo GTIN debe ser de 13 digitos sin espacios en blanco!");
				}
			}while(!validarCadena(gtin));
			
			if(validarGtin(gtin)){
				System.out.println("El codigo ingresado es un codigo GTIN-13");
			} else {
				System.out.println("El codigo ingresado no es un codigo GTIN-13");
			}
			do{
				System.out.print("Desea continuar? (s/n): ");
				opcion = caracter.next().charAt(0);
				opcion = Character.toLowerCase(opcion);
				if(opcion != 's' &&opcion != 'n'){
					System.out.println("Escoga n o n");
				}
			}while(opcion != 's' &&opcion != 'n');
		}while(opcion == 's');
    }
}
