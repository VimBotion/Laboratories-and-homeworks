/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Escribir un programa que convierta Libras en Kilogramos
 * @author Apolo Juan, Campoverde Esteban, Cabrera Franck
 */

import java.util.Scanner;
public class ConversionLibras {
    public static void main(String[] args){
        double libras, kilogramos;
        final double factorConversion = 0.4535;
        
        Scanner real1 = new Scanner(System.in);
        
        System.out.print("Ingrese las libras: ");
        libras = real1.nextDouble();
        
        // Formula para convertir las libras a kilogramos
        kilogramos = libras * factorConversion;
        
        System.out.printf("El peso en kilogramos es de %,.4f \n", kilogramos);
        
    }
}
