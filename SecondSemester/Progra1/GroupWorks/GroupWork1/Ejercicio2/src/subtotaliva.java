/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Escribir un programa que dado el total de una factura, desglose el valor del 
 * SUBTOTAL y del IVA correspondiente 
 * @author Franck Cabrera, Esteban Campoverde, Juan Apolo
 */
import java.util.Scanner;

public class subtotaliva {
    public static void main(String [] Argumentos){
        double total, subtotal, iva;
        Scanner real1 = new Scanner(System.in);
        System.out.print("Ingrese el total de la factura: ");
        total = real1.nextDouble();
        subtotal = total/1.15;
        iva = total - subtotal;
        System.out.printf("El subtotal de la fatura es: %,.2f \n", subtotal);
        System.out.printf("El IVA de la factura es: %,.2f \n", iva);
    }
}
