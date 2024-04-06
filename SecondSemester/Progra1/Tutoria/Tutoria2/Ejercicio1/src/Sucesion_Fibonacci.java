/**
 * 1. Realizar un programa que pida al usuario un numero entero n entre 1 y 50. Y muestre la sucesion de Fibonacci de los n primeros numeros.
 * @author Campoverde Esteban
 */

import java.util.Scanner;
public class Sucesion_Fibonacci {
    public static int fibonacci(int n){
        if(n == 0){   
            return 0;
        }
        if (n == 1){
            return 1;
        }
        
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public static void main(String[] args) {
        int numero;
        char opcion;
        Scanner caracter = new Scanner(System.in);
        Scanner entero = new Scanner(System.in);
        
        do{
            do{
                System.out.print("Ingrese un numero del 1 al 50: ");
                numero = entero.nextInt();
            } while(numero < 1 || numero > 50);
            
            System.out.print("La sucesion de fibonacci de los " + numero + " primeros numeros es: ");
            for (int i = 0; i < numero; i++){
                System.out.print(fibonacci(i) + " ");
            }
            
            do {
               System.out.print("\nDesea continuar? s/n: ");
                opcion = caracter.next().charAt(0);
                opcion = Character.toLowerCase(opcion); 
            } while (opcion != 'n' && opcion != 's');     
        } while(opcion == 's');
    }
    
}
