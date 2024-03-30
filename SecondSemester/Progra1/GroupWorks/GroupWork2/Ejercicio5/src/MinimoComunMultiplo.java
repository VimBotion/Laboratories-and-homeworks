/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Escribir un programa que utilizando un método permita encontrar el mínimo común
 * múltiplo entre dos números enteros largos. 
 * @author Apolo Juan, Campoverde Esteban, Cabrera Franck
 */

import java.util.Scanner;
public class MinimoComunMultiplo {
    
    // Función para calcular el máximo común divisor utilizando el algoritmo de Euclides
    public static long maximoComunDivisor(long numero1, long numero2){
        while (numero2 != 0) {
            long temp = numero2;
            numero2 = numero1 % numero2;
            numero1 = temp;
        }
        return numero1;
    }
    // Función para calcular el mínimo común múltiplo usando mcd
    public static long minimoComunMultiplo(long numero1, long numero2) {
        return (numero1 * numero2) / maximoComunDivisor(numero1, numero2);
    }
    
    public static void main(String[] args){
        char opcion;
        long numero1, numero2;
        
        Scanner entero1 = new Scanner(System.in);
        Scanner char1 = new Scanner(System.in);
        
        do{
            do{
                System.out.println("Ingrese el primer numero positivo: ");
                numero1 = entero1.nextInt();
                System.out.println("Ingrese el segundo numero positivo: ");
                numero2 = entero1.nextInt();
            }while(numero1 <= 0 || numero2 <= 0);  
     
            long mcd = maximoComunDivisor(numero1, numero2);
            long mcm = minimoComunMultiplo(numero1, numero2);

            System.out.printf("El mínimo común múltiplo es: %,d%n", mcm);
            do{
                System.out.println("¿Desea continuar S/N?");
                opcion = char1.next().charAt(0);
                opcion = Character.toLowerCase(opcion);
            }while(opcion != 's' && opcion != 'n');
        }while(opcion != 'n');
        
    }
}
