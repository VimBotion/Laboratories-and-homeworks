/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  Escribir un programa que ingrese el número de filas (debe validarse que el número de filas
 *  se encuentre entre 2 y 9) que va a tener un rombo y utilizando un método, lo grafique.
 * @author Apolo Juan, Campoverde Esteban, Cabrera Franck
 */

import java.util.Scanner;
public class Rombo {   
    
    public static void graficarRombo(int filas) {
        // La parte superior del rombo
        for (int i = 1; i <= filas; i++) {
            // Imprime espacios
            for (int j = 1; j <= filas - i; j++) {
                System.out.print(" ");
            }    
            // Imprime números decrecientemente
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }          
            // Imprime números crecientemente
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }     
            System.out.println();
        }
        
        // La parte inferior del rombo
        for (int i = filas - 1; i >= 1; i--) {
            for (int j = 1; j <= filas - i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }      
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }   
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        char opcion;
        int filas; 
 
        Scanner entero1 = new Scanner(System.in);
        Scanner char1 = new Scanner(System.in);
        do{
            do{
                System.out.println("Ingrese el numero de filas (2-9): ");
                filas = entero1.nextInt();
            }while(filas < 2 || filas > 9);
        
            graficarRombo(filas);
        
            do{
                System.out.println("¿Desea continuar S/N?");
                opcion = char1.next().charAt(0);
                opcion = Character.toLowerCase(opcion);
            }while(opcion != 's' && opcion != 'n');
        
        }while(opcion != 'n');
    }
}
