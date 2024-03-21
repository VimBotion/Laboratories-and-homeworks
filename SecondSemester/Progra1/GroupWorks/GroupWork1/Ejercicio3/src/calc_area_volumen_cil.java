/**
 * Escribir un programa que calcule el area total y el volumen de un cilindro. Utilizar
 * como valor de Pi: 3.141592653589
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */

import java.util.Scanner;
public class calc_area_volumen_cil {
    public static void main(String[] args) {
        final double PI = 3.141592653589;
        double radio, altura, area, volumen;
        Scanner real = new Scanner(System.in);
        
        System.out.print("Ingrese el valor del radio: ");
        radio = real.nextDouble();
        System.out.print("Ingrese el valor de la altura: ");
        altura = real.nextDouble();
        
        if (radio <= 0){
            System.out.println("El valor del radio debe ser mayor a 0!");
            return;
        }
        if (altura <= 0){
            System.out.println("El valor de la altura debe ser mayor a 0!");
            return;
        }
        // A = 2PIr(r+h)
        area = 2*PI*radio*(radio + altura);
        // V = PIr^2*h
        volumen = PI*radio*radio*altura;
        
        System.out.printf("Area total = %,.4f\n", area);
        System.out.printf("Volumen = %,.4f\n", volumen);
    } 
}