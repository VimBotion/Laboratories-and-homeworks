/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Diseñar un programa que lea desde teclado el nombre de un alumno y una de sus notas
 * en una determinada materia, luego el programa debe mostrar la información leída con un
 * mensaje que indique el tipo de nota de acuerdo a la siguiente tabla
 * @author Apolo Juan, Campoverde Esteban, Cabrera Franck
 */

import java.util.Scanner;
public class NotaMateria {
    public static void main(String[] args) {
        String nombreAlumno;
        double nota;
        
        Scanner string1 = new Scanner(System.in);
        Scanner real1 = new Scanner(System.in);

        System.out.print("Ingrese el nombre del alumno: ");
        nombreAlumno = string1.nextLine();

        System.out.print("Ingrese la nota del alumno en la materia: ");
        nota = real1.nextDouble();
        
        if (nota >= 0 && nota <= 59.99) {
            System.out.printf("El alumno %s ha obtenido una nota de %,.4f en la materia, que equivale a F.%n", nombreAlumno, nota);
        } else if (nota >= 60 && nota <= 66.99) {
            System.out.printf("El alumno %s ha obtenido una nota de %,.4f en la materia, que equivale a D.%n", nombreAlumno, nota);
        } else if (nota >= 67 && nota <= 69.99) {
            System.out.printf("El alumno %s ha obtenido una nota de %,.4f en la materia, que equivale a D+.%n", nombreAlumno, nota);
        } else if (nota >= 70 && nota <= 72.99) {
            System.out.printf("El alumno %s ha obtenido una nota de %,.4f en la materia, que equivale a C-.%n", nombreAlumno, nota);
        } else if (nota >= 73 && nota <= 76.99) {
            System.out.printf("El alumno %s ha obtenido una nota de %,.4f en la materia, que equivale a C.%n", nombreAlumno, nota);
        } else if (nota >= 77 && nota <= 79.99) {
            System.out.printf("El alumno %s ha obtenido una nota de %,.4f en la materia, que equivale a C+.%n", nombreAlumno, nota);
        } else if (nota >= 80 && nota <= 82.99) {
            System.out.printf("El alumno %s ha obtenido una nota de %,.4f en la materia, que equivale a B-.%n", nombreAlumno, nota);
        } else if (nota >= 83 && nota <= 86.99) {
            System.out.printf("El alumno %s ha obtenido una nota de %,.4f en la materia, que equivale a B.%n", nombreAlumno, nota);
        } else if (nota >= 87 && nota <= 89.99) {
            System.out.printf("El alumno %s ha obtenido una nota de %,.4f en la materia, que equivale a B+.%n", nombreAlumno, nota);
        } else if (nota >= 90 && nota <= 92.99) {
            System.out.printf("El alumno %s ha obtenido una nota de %,.4f en la materia, que equivale a A-.%n", nombreAlumno, nota);
        } else if (nota >= 93 && nota <= 100) {
            System.out.printf("El alumno %s ha obtenido una nota de %,.4f en la materia, que equivale a A.%n", nombreAlumno, nota);
        } else {
            System.out.println("La nota ingresada esta fuera de rango.");
        }
    }
}
