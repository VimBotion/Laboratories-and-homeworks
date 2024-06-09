/**
 * 7.  Dos números se dicen amigos si la suma de los divisores de cada uno de ellos (incluida la 
 *     unidad, y exceptuando el número mismo) es igual al otro número dado. Escribir un programa 
 *     que, utilizando métodos, muestre los n primeros números amigos
 * @author Campoverde Esteban, Cabrera Franck, Apolo Juan
 */

import java.util.Scanner;
public class Numeros_amigos {
    public static int sumaDivisores(int numero){
        int suma = 1; // Se asigna el valor de 1, porque 1 siempre es divisor de cualquier numero
        for (int i = 2; i <= numero / 2; i++){ // Se asigna a i el valor de 2 porque ya se incluyo el valor de 1 previamente
            if (numero % i == 0){
                suma += i;
            }
        }
        return suma;
    }
    
   public static void esAmigo(int cantidadNumeros) {
    
    int contador = 0;
    int num = 2; // Empezamos desde 2 porque el número 1 no es considerado amigo
    while (contador < cantidadNumeros) {
        int posibleAmigo = sumaDivisores(num);
        // num < sumaDivNum verifica que no se impriman los mismos pares dos veces
        if (num < posibleAmigo && num == sumaDivisores(posibleAmigo)) {
            System.out.printf("%,d %,d %n", num, posibleAmigo);
            contador++;
        }
        num++;
    }
}

    public static void main(String[] args) {
        char opcion;
        int cantidadNumeros;
        Scanner caracter = new Scanner(System.in);
        Scanner entero = new Scanner(System.in);
        do {
            do {
                System.out.print("Ingrese cuantos numeros amigos quiere imprimir: ");
                cantidadNumeros = entero.nextInt();
            } while (cantidadNumeros <= 0);
            
            System.out.println("Los " + cantidadNumeros + " primeros numeros amigos son:");
            esAmigo(cantidadNumeros);
            
            do {
                System.out.print("Desea continuar? s/n: ");
                opcion = caracter.next().charAt(0);
                // toLowerCase convierte "opcion" a minuscula
                opcion = Character.toLowerCase(opcion);
            } while(opcion != 's' && opcion != 'n'); 
        } while(opcion == 's');
    }  
}
