/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class validacion_Ruc_Cedula {
	// Valida que solo se ingrese numeros
	public static boolean validarNumero(String numero){
		for(int i = 0; i < numero.length(); i++){
			if(!Character.isDigit(numero.charAt(i))){
				return false;
			}
		}
		return true;
	}

	public static boolean validarProvincia(String numero){
		int provincia = (numero.charAt(0) - '0') * 10 + (numero.charAt(1) - '0');
		if(provincia < 1 || provincia > 24){
			return false;
		}
		return true;
	}
	
	public static int tercerDigito(String numero){
		return numero.charAt(2) - '0';
	}

	public static boolean validarTresUltimos(String numero){
		if(numero.substring(10).equals("000")){
			return false;
		}
		return true;
	}

	public static boolean validarCedula(String numero){
		// Verificar provincia
		if(!validarProvincia(numero)){
			return false;
		}
		// Verificar tercer digito
		if(tercerDigito(numero) < 0 || tercerDigito(numero) > 5){
			return false;
		}
		// Suma de digitos por coeficientes
		int coeficientes[] = {2, 1, 2, 1, 2, 1, 2, 1, 2};
		int suma = 0, multiplicacion;
		for(int i = 0; i < coeficientes.length; i++){
			multiplicacion = (numero.charAt(i) - '0') * coeficientes[i];
			if(multiplicacion > 9){
				multiplicacion -= 9;
			}
			suma += multiplicacion;
		}
		int digitoVerificador = numero.charAt(9) - '0';
		int moduloVerificador = suma % 10;
		if(moduloVerificador != 0){
			moduloVerificador = 10 - moduloVerificador; 
		}
		return moduloVerificador == digitoVerificador;
	}

	public static boolean validarJuridico(String numero){
		// Verificar provincia
		if(!validarProvincia(numero)){
			return false;
		}
		// Verificar tercerDigito
		if(tercerDigito(numero) != 9){
			return false;
		}
		// Verificar que los tres ultimos numeros no sean 000
		if(!validarTresUltimos(numero)){
			return false;
		}
		// Suma de digitos por coeficientes
		int coeficientes[] = {4, 3, 2, 7, 6, 5, 4, 3, 2};
		int suma = 0;
		for(int i = 0; i < coeficientes.length; i++){
			suma += (numero.charAt(i) - '0') * coeficientes[i];
		}
		int digitoVerificador = numero.charAt(9) - '0';
		int moduloVerificador = suma % 11;
		if(moduloVerificador == 0){
			return moduloVerificador == digitoVerificador;
		}else {
			moduloVerificador = 11 - moduloVerificador;
			return moduloVerificador == digitoVerificador;
		}
	}

	public static boolean validarPublico(String numero){
		// Verificar provincia
		if(!validarProvincia(numero)){
			return false;
		}
		// Verificar tercerDigito
		if(tercerDigito(numero) != 6){
			return false;
		}
		// Verificar que los tres ultimos numeros no sean 000
		if(!validarTresUltimos(numero)){
			return false;
		}

		// Suma de digitos por coeficientes
		int coeficientes[] = {3, 2, 7, 6, 5, 4, 3, 2};
		int suma = 0;
		for(int i = 0; i < coeficientes.length; i++){
			suma += (numero.charAt(i) - '0') * coeficientes[i];	
		}
		int digitoVerificador = numero.charAt(8) - '0';
		int moduloVerificador = suma % 11;
		if(moduloVerificador == 0){
			return moduloVerificador == digitoVerificador;
		}else {
			moduloVerificador = 11 - moduloVerificador;
			return moduloVerificador == digitoVerificador;
		}
	}

    public static void main(String[] args) {
		Scanner cadena = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);
		char opcion;
		String numero;
		do{
			// Validar que el numero sea corrector
			do {
				System.out.print("Ingrese el numero de cedula o RUC: ");
				numero = cadena.nextLine();
				if(!validarNumero(numero)){
					System.out.println("Ingrese solo numeros!");
				}
			}while(!validarNumero(numero));
			
			switch (numero.length()) {
				// Cedula
				case 10:
					if(validarCedula(numero)){
						System.out.println("El numero " + numero + " es un numero de cedula valido");
					} else{
						System.out.println("El numero " + numero + " no es un numero de cedula valido");
					}
					break;
				// RUC
				case 13:
					if(validarJuridico(numero)){
						System.out.println("El numero " + numero + " es un numero de RUC juridico o extranjero sin cedula");
					} else if(validarPublico(numero)){
						System.out.println("El numero " + numero + " es un numero de RUC publico");
					} else if(validarTresUltimos(numero) && validarCedula(numero.substring(0, 10))){
						System.out.println("El numero " + numero + " es un numero de RUC persona natural");
					} else {
						System.out.println("El numero " + numero + " no es un numero de RUC valido");
					}
					break;
				default:
					System.out.println("El numero no es valido!");
					break;
			}

			do{
				System.out.print("Desea repetir el programa (s/n): ");
				opcion = caracter.next().charAt(0);
				// Devuelve opcion en minusculas
				opcion = Character.toLowerCase(opcion);
			}while(opcion != 's' && opcion != 'n');
		}while(opcion == 's');
    }
}
