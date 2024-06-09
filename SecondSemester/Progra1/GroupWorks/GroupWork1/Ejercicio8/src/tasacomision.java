/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Escribir un programa que ingrese el nombre del vendedor, el monto de ventas y 
 * el número de años que tiene en la Empresa, y que calcule y visualice la tasa 
 * de comisión y la comisión del vendedor.
 * @author Franck Cabrera, Esteban Campoverde, Juan Apolo
 */
import java.util.Scanner;

public class tasacomision {
    public static void main(String [] Argumentos){
        String nombre;
        int anhos;
        double ventas, tasa, comision;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del vendedor: ");
        nombre = scanner.nextLine();
        System.out.print("Ingrese el monto de ventas: ");
        ventas = scanner.nextDouble();
        System.out.print("Ingrese el numero de años: ");
        anhos = scanner.nextInt();
        if (ventas<4000){
            tasa = 1.0;
        } else if (ventas<6500){
            tasa = 2.0;
        } else if (ventas<8500){
            tasa = 3.0;
        } else if (ventas<10000){
            tasa = 4.0;
        } else if (ventas<12000){
            tasa = 5.0;
        } else if (ventas<14500){
            tasa = 6.0;
        } else{
            tasa = 7.0;
        }
        comision = ventas*(tasa/100);
        if (anhos>10){
            comision *= 2;
            if (anhos>10){
                comision += (anhos-10)*10;
            }
        }
        System.out.printf("La tasa de comisión para %s es del %.2f%%\n", nombre, tasa);
        System.out.printf("La comisión para %s es de %.2f\n", nombre, comision);
    }
}
