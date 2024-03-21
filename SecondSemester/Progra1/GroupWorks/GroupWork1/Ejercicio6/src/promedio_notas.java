/**
 * Un alumno que cursa cuatro materias desea saber que nota obtendrá en cada una de
 * ellas y cuál será su promedio general.
 * @author Campoverde Esteban, Apolo Juan, Franck Cabrera
 */

import java.util.Scanner;
public class promedio_notas {
    public static void main(String[] args) {
        double nota, promedioEstructura = 0, promedioAnalisis = 0, promedioAlgebra = 0, promedioFisica = 0, promedioGeneral = 0;
        Scanner real = new Scanner(System.in);
        // Promedio Estructura de datos
        System.out.print("Ingrese la nota de la primera tarea de Estructura de Datos: ");
        nota = real.nextDouble();
        promedioEstructura += nota;
        System.out.print("Ingrese la nota de la segunda tarea de Estructura de Datos: ");
        nota = real.nextDouble();
        promedioEstructura += nota;
        System.out.print("Ingrese la nota de la tercera tarea de Estructura de Datos: ");
        nota = real.nextDouble();
        promedioEstructura += nota;
        // Promedio de las tareas = (suma de las notas / numero de notas) * 46%
        promedioEstructura = (promedioEstructura / 3) * 0.46;
        System.out.print("Ingrese la nota del examen de Estructura de Datos: ");
        nota = real.nextDouble();
        // Promedio Total = Promedio de las tareas + (nota del examen * 54%)
        promedioEstructura = promedioEstructura + (nota * 0.54);        
        // Promedio Analisis Matematico
        System.out.print("Ingrese la nota de la primera tarea de Analisis Matematico: ");
        nota = real.nextDouble();
        promedioAnalisis += nota;
        System.out.print("Ingrese la nota de la segunda tarea de Analisis Matematico: ");
        nota = real.nextDouble();
        promedioAnalisis += nota;
        // Promedio de las tareas = (suma de las notas / numero de notas) * 35%
        promedioAnalisis = (promedioAnalisis / 2) * 0.35;
        System.out.print("Ingrese la nota del examen de Analisis Matematico: ");
        nota = real.nextDouble();
        // Promedio Total = Promedio de las tareas + (nota del examen * 65%)
        promedioAnalisis = promedioAnalisis + (nota * 0.65);
        // Promedio Algebra Lineal
        System.out.print("Ingrese la nota de la primera tarea de Algebra Lineal: ");
        nota = real.nextDouble();
        promedioAlgebra += nota;
        System.out.print("Ingrese la nota de la segunda tarea de Algebra Lineal: ");
        nota = real.nextDouble();
        promedioAlgebra += nota;
        System.out.print("Ingrese la nota de la tercera tarea de Algebra Lineal: ");
        nota = real.nextDouble();
        promedioAlgebra += nota;
        System.out.print("Ingrese la nota de la cuarta tarea de Algebra Lineal: ");
        nota = real.nextDouble();
        promedioAlgebra += nota;
        // Promedio de las tareas = (suma de las notas / numero de notas) * 55%
        promedioAlgebra = (promedioAlgebra / 4) * 0.55;
        System.out.print("Ingrese la nota del examen de Algebra Lineal: ");
        nota = real.nextDouble();
        // Promedio Total = Promedio de las tareas + (nota del examen * 45%)
        promedioAlgebra = promedioAlgebra + (nota * 0.45);
        // Promedio Fisica
        System.out.print("Ingrese la nota de la primera tarea de Fisica: ");
        nota = real.nextDouble();
        promedioFisica += nota;
        System.out.print("Ingrese la nota de la segunda tarea de Fisica: ");
        nota = real.nextDouble();
        promedioFisica += nota;
        System.out.print("Ingrese la nota de la tercera tarea de Fisica: ");
        nota = real.nextDouble();
        promedioFisica += nota;
        // Promedio de las tareas = (suma de las notas / cantidad de notas) * 45%
        promedioFisica = (promedioFisica / 3) * 0.45;
        System.out.print("Ingrese la nota del examen de Fisica: ");
        nota = real.nextDouble();
        // Promedio total = Promedio de las tareas + (nota del examen * 55%)
        promedioFisica = promedioFisica + (nota * 0.55);
        // Promedio General
        promedioGeneral = (promedioEstructura + promedioAnalisis + promedioAlgebra + promedioFisica) / 4;
        
        System.out.printf("El promedio de Estructuras de Datos es: %,.4f \n", promedioEstructura);
        System.out.printf("El promedio de Analisis Matematico II es: %,.4f \n", promedioAnalisis);
        System.out.printf("El promedio de Algebra Lineal es: %,.4f\n", promedioAlgebra);
        System.out.printf("El promedio de Fisica es: %,.4f \n", promedioFisica);
        System.out.printf("El promedio General es: %,.4f \n", promedioGeneral);
        
    }   
}
