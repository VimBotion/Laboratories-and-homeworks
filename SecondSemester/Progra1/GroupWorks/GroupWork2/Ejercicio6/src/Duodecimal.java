/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Escribir un programa que utilizando un método convierta un entero positivo en duodecimal. 
 * @author Franck Cabrera, Juan Apolo, Esteban Campoverde
 */
import java.util.Scanner;

public class Duodecimal {
    public static void main(String[] Argumentos) {
        int numero;
        Scanner entero = new Scanner(System.in);
        System.out.printf("Ingrese un número entero positivo: ");
        numero = entero.nextInt();
        if(numero < 0) {
            System.out.println("El número debe ser positivo.");
        } else {
            String duodecimal = conversion(numero);
            System.out.println("El número en duodecimal es: " + duodecimal);
        }
    }
    public static String conversion(int numero) {
        if(numero == 0) {
            return "0";
        }
        StringBuilder duodecimal = new StringBuilder();
        while(numero > 0) {
            int residuo = numero % 12;
            if(residuo < 10) {
                duodecimal.insert(0, residuo);
            } else {
                char digito = (char) ('A' + (residuo - 10));
                duodecimal.insert(0, digito);
            }
            numero /= 12;
        }
        return duodecimal.toString();
    }
}