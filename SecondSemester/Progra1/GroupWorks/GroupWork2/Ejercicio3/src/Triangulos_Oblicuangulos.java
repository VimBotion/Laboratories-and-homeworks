/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sucoa
 */
import java.util.Scanner;
public class Triangulos_Oblicuangulos {
    public static double redondear_dos_decimales(double numero){
        return Math.round(numero * 100.0)/100.0;
    }
    public static void main(String[] args) {
        char opcion;
        double anguloA, anguloARad, anguloB, anguloBRad, anguloC, anguloCRad, ladoA, ladoB, ladoC;
        Scanner caracter = new Scanner(System.in);
        Scanner real = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("a)Cálculo de un ángulo y dos lados, conociendo un lado y dos ángulos adyacentes a él.");
            System.out.println("b)Cálculo de un lado y dos ángulos, conociendo dos lados y el ángulo comprendido.");
            System.out.println("c)Cálculo de un lado y dos ángulos, conociendo dos lados y un ángulo opuesto.");
            System.out.println("d)Cálculo de los tres ángulos, conociendo los tres lados.");
            System.out.println("e)Salir");
            System.out.print("Seleccione que desea realizar (a-e): ");
            opcion = caracter.next().charAt(0);
            // Convierte opcion a minusculas;
            opcion = Character.toLowerCase(opcion);    
            
            switch(opcion){
                case 'a':
                    do {
                        System.out.print("Ingrese el valor del lado A: ");
                        ladoA = real.nextDouble();
                        System.out.print("Ingrese el valor del angulo adyacente B: ");
                        anguloB = real.nextDouble();
                        anguloBRad = Math.toRadians(anguloB);
                        System.out.print("Ingrese el valor del angulo adyacente C: ");
                        anguloC = real.nextDouble();
                        anguloCRad = Math.toRadians(anguloC);
                        if (anguloB + anguloC >= 180){
                            System.out.println("Los valores de los angulos no forman un triangulo valido");
                            break;
                        }           
                    } while(ladoA <=0 || anguloC <= 0 || anguloB <= 0);
                    anguloA = 180 - anguloB - anguloC;
                    anguloARad = Math.toRadians(anguloA);
                    ladoB = ladoA * Math.sin(anguloBRad) / Math.sin(anguloARad);
                    ladoC = ladoA * Math.sin(anguloCRad) / Math.sin(anguloARad);  
                    System.out.printf("El valor del angulo faltante es de  %.2f", anguloA);
                    System.out.printf("El valor del lado B es %.2f y el valor del lado C es %.2f.%n", ladoB, ladoC);   
                    break;
                case 'b':
                    break;
                case 'c':
                    break;
                case 'd':
                    break;
                case 'e':
                    break;
                default:
                    System.out.println("Por favor ingrese una opcion valida (a-e)");
            }
        } while (opcion != 'e');

    }
    
}
