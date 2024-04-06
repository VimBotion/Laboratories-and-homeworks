/**
 *
 * @author Campoverde Esteban
 */

import java.util.Scanner;
public class Determinar_Numero {
    public static void esPrimo(long numero){
        if (numero == 1){
            System.out.println("El numero 1 no es primo");
        }
        
        for (int i = 2; i < numero; i++){
            if (numero % i == 0){
                System.out.println("El numero "+ numero + " no es primo");
                return;
            }
        }
        
        System.out.println("El numero " + numero + " es primo");
    }
    
    public static void esPerfecto(long numero){
        long suma = 0;
        for (int i = 1; i < numero; i++){
            if (numero % i == 0){
                suma += i;
            }
        }
        if (suma == numero){
            System.out.println("El numero " + numero + " es perfecto");
        }
        else {
            System.out.println("El numero " + numero + " no es perfecto");
        }
    }
    
    
    public static void main(String[] args) {
        long numero;
        char opcion;
        Scanner largo = new Scanner(System.in);
        Scanner caracter = new Scanner(System.in);
        do {
            do {
                System.out.print("Ingrese un numero: ");
                numero = largo.nextLong();
            } while (numero < 0);
            esPrimo(numero);  
            esPerfecto(numero);
            
            do {
                System.out.print("Desea continuar? s/n: ");
                opcion = caracter.next().charAt(0);
                opcion = Character.toLowerCase(opcion);
            } while (opcion != 's' && opcion != 'n'); 
        } while (opcion == 's');
    }
    
}
