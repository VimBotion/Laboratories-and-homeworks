/**
 * 4. Escribir un programa que utilizando un método realice lo siguiente: Dado un número entero largo x, calcular la suma de los dígitos que lo forman.
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Suma_Digitos {
    public static short sumaDigitos(long numero){
        short suma = 0; 
        long digito;   
        numero = Math.abs(numero);
        while (numero > 0){
            digito = numero % 10;
            suma += digito;
            numero /= 10;
        }
        
        return suma;
    }
    
    public static void main(String[] args) {
        Scanner entero = new Scanner(System.in);
        Scanner caracter = new Scanner(System.in);
        char opcion;
        do {
            System.out.print("Ingrese el numero a sumar sus digitos: ");
            long numero = entero.nextLong();
            System.out.printf("La suma de de digitos del numero %d es %d %n", numero, sumaDigitos(numero)); 
            do {
                System.out.println("Desea continuar? s/n: ");
                opcion = caracter.next().charAt(0);
                // Convierte "opcion" a minusculas
                opcion = Character.toLowerCase(opcion);
            } while(opcion != 's' && opcion != 'n');
        } while (opcion == 's');
    }   
}
