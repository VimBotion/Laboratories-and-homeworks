/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Escribir un programa que calcule el número de segundos que hay en U número de 
 * meses, X número de días, Y número de horas y Z número de minutos.
 * @author Franck Cabrera, Esteban Campoverde, Juan Apolo
 */
import java.util.Scanner;

public class numerosegundos {
    public static void main(String [] Argumentos){
        int meses, dias, horas, minutos, segmeses, segdias, seghoras, segminutos, totalseg;
        Scanner real1 = new Scanner(System.in);
        System.out.print("Ingrese el numero de meses: ");
        meses = real1.nextInt();
        Scanner real2 = new Scanner(System.in);
        System.out.print("Ingrese el numero de dias: ");
        dias = real2.nextInt();
        Scanner real3 = new Scanner(System.in);
        System.out.print("Ingrese el numero de horas: ");
        horas = real3.nextInt();
        Scanner real4 = new Scanner(System.in);
        System.out.print("Ingrese el numero de minutos: ");
        minutos = real4.nextInt();
        segmeses = meses*30*24*60*60;
        segdias = dias*24*60*60;
        seghoras = horas*60*60;
        segminutos = minutos*60;
        totalseg = segmeses+segdias+seghoras+segminutos;
        System.out.printf("El numero de segundos es: %d \n", totalseg);
    }
}
