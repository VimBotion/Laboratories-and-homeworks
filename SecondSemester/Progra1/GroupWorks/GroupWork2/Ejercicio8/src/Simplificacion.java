/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Escribir un programa que utilizando métodos permita simplificar una fracción.
 * @author Franck Cabrera, Juan Apolo, Esteban CampoverdeQue 
 */
import java.util.Scanner;

public class Simplificacion {
    
    public static void main(String[] Argumentos) {
        long numerador, denominador;
        Scanner long1 = new Scanner(System.in);
        Scanner long2 = new Scanner(System.in);
        System.out.printf("Ingrese el numerador:");
        numerador = long1.nextLong();
        System.out.printf("Ingrese el denominador:");
        denominador = long2.nextLong();
        long[] fraccionSimplificada = simplificarfraccion(numerador, denominador);
        System.out.println("La fracción simplificada es: " + fraccionSimplificada[0] + "/" + fraccionSimplificada[1]);
    }
    public static long[] simplificarfraccion(long numerador, long denominador) {
        long mcd, num, den; 
        mcd = mcd(numerador, denominador);
        num = numerador / mcd;
        den = denominador / mcd;
        return new long[] { num, den };
    }
    public static long mcd(long a, long b) {
        while (b != 0) {
            long i = b;
            b = a % b;
            a = i;
        }
        return a;
    }
}
