/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Cinco personas deciden invertir su dinero para fundar una empresa. Obtener el valor
 * total invertido y el porcentaje que cada quien invierte con respecto al valor total invertido.
 * @author Apolo Juan, Campoverde Esteban, Cabrera Franck
 */

import java.util.Scanner;
public class Inversion {
    public static void main(String[] args){
        double inversionPersona1,inversionPersona2,inversionPersona3,inversionPersona4,inversionPersona5, 
               porcentajePersona1,porcentajePersona2,porcentajePersona3,porcentajePersona4,porcentajePersona5;
        double total = 0;
        
        Scanner real1 = new Scanner(System.in);
        
        // Pedir a cada persona la cantidad invertida
        System.out.print("Cantidad invertida de la persona #1: ");
        inversionPersona1 = real1.nextDouble();
        System.out.print("Cantidad invertida de la persona #2: ");
        inversionPersona2 = real1.nextDouble();
        System.out.print("Cantidad invertida de la persona #3: ");
        inversionPersona3 = real1.nextDouble();
        System.out.print("Cantidad invertida de la persona #4: ");
        inversionPersona4 = real1.nextDouble();
        System.out.print("Cantidad invertida de la persona #5: ");
        inversionPersona5 = real1.nextDouble();
        
        // total invertido entre los 5
        total = inversionPersona1 + inversionPersona2 + inversionPersona3 + inversionPersona4 + inversionPersona5;
        
        // Porcentajes con respecto al total de cada uno
        porcentajePersona1 = (inversionPersona1 / total)* 100;
        porcentajePersona2 = (inversionPersona2 / total)* 100;
        porcentajePersona3 = (inversionPersona3 / total)* 100;
        porcentajePersona4 = (inversionPersona4 / total)* 100;
        porcentajePersona5 = (inversionPersona5 / total)* 100;
        
        System.out.printf("Valor total invertido: $%,.4f \n", total);
        System.out.println("Porcentaje que invierte cada persona:");
        System.out.printf("Persona 1: %,.4f%%\n", porcentajePersona1);
        System.out.printf("Persona 2: %,.4f%%\n", porcentajePersona2);
        System.out.printf("Persona 3: %,.4f%%\n", porcentajePersona3);
        System.out.printf("Persona 4: %,.4f%%\n", porcentajePersona4);
        System.out.printf("Persona 5: %,.4f%%\n", porcentajePersona5);
        
        
    }
}
