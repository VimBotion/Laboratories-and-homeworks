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
                    System.out.print("Ingrese el valor del lado A: ");
                    ladoA = real.nextDouble();
                    System.out.print("Ingrese el valor del lado B: ");
                    ladoB = real.nextDouble();
                    System.out.print("Ingrese el valor del ángulo comprendido entre los lados A y B: ");
                    anguloC = real.nextDouble();
                    anguloCRad = Math.toRadians(anguloC);
                    
                    anguloA = Math.asin((ladoA * Math.sin(anguloC)) / ladoB);
                    anguloA = Math.toDegrees(anguloA);
                    anguloB = 180 - anguloC - anguloA;
                    
                    ladoC = Math.sqrt(Math.pow(ladoA, 2) + Math.pow(ladoB, 2) - 2 * ladoA * ladoB * Math.cos(anguloCRad));

                    System.out.printf("El valor del ángulo A es de %.2f\n", anguloA);
                    System.out.printf("El valor del ángulo B es de %.2f\n", anguloB);
                    System.out.printf("El valor del lado C es de %.2f\n", ladoC);
                    break;
                case 'c':
                    System.out.print("Ingrese el valor del lado A: ");
                    ladoA = real.nextDouble();
                    System.out.print("Ingrese el valor del lado B: ");
                    ladoB = real.nextDouble();
                    System.out.print("Ingrese el valor del ángulo opuesto al lado A: ");
                    anguloA = real.nextDouble();
                    
                    anguloA = Math.toRadians(anguloA);
                    anguloC = Math.acos((Math.pow(ladoA, 2) + Math.pow(ladoB, 2) - (2 * ladoA * ladoB * Math.cos(anguloA))));
                    anguloC = Math.toDegrees(anguloC);
                    anguloB = 180 - Math.toDegrees(anguloA) - anguloC;

                    ladoC = Math.sqrt(Math.pow(ladoA, 2) + Math.pow(ladoB, 2) - (2 * ladoA * ladoB * Math.cos(anguloA)));

                    System.out.printf("El valor del ángulo B es de %.2f\n", anguloB);
                    System.out.printf("El valor del ángulo C es de %.2f\n", anguloC);
                    System.out.printf("El valor del lado C es de %.2f\n", ladoC);
                    break;
                case 'd':
                    System.out.print("Ingrese el valor del lado A: ");
                    ladoA = real.nextDouble();
                    System.out.print("Ingrese el valor del lado B: ");
                    ladoB = real.nextDouble();
                    System.out.print("Ingrese el valor del lado C: ");
                    ladoC = real.nextDouble();

                    anguloA = Math.acos((Math.pow(ladoB, 2) + Math.pow(ladoC, 2) - Math.pow(ladoA, 2)) /(2 * ladoB * ladoC));
                    anguloA = Math.toDegrees(anguloA);

                    anguloB = Math.acos((Math.pow(ladoA, 2) + Math.pow(ladoC, 2) - Math.pow(ladoB, 2)) / (2 * ladoA * ladoC));
                    anguloB = Math.toDegrees(anguloB);

                    anguloC = 180 - anguloA - anguloB;

                    System.out.printf("El valor del ángulo A es de %.2f\n", anguloA);
                    System.out.printf("El valor del ángulo B es de %.2f\n", anguloB);
                    System.out.printf("El valor del ángulo C es de %.2f\n", anguloC);
                    break;
                case 'e':
                    System.out.println("Gracias por utilizar!");
                    break;
                default:
                    System.out.println("Por favor ingrese una opcion valida (a-e)");
            }
        } while (opcion != 'e');

    }
    
}
