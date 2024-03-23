/**
 * 1. Obtener valores correspondientes a matemáticas financieras relacionadas con el interés=
 *   compuesto
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Matematicas_Financieras {
    public static double calc_interes(double capital, double tasaInteres, double periodoTiempo){
        double interes = 0;
        // Interes = capital((1+tasaInteres)^periodoTiempo - 1)
        interes = capital*((Math.pow(1 + tasaInteres, periodoTiempo)) -1);
        interes = Math.round(interes * 100.0) / 100.0;
        return interes;
    }
    
    public static double calc_capital(double interes, double tasaInteres, double periodoTiempo){
        double capital = 0;
        // Capital = Interes / (1+tasaInteres)^periodoTiempo - 1
        capital = interes / ((Math.pow(1 + tasaInteres, periodoTiempo)) - 1);
        capital = Math.round(capital * 100.0) / 100.0;
        return capital;
    }
    
    public static double calc_tasaInteres(double interes, double capital, double periodoTiempo){
        double tasaInteres = 0;
        // TasaInteres = (interes/capital + 1)^1/periodoTiempo) - 1
        tasaInteres = (Math.pow(interes/capital + 1, 1.0/periodoTiempo)) - 1;
        tasaInteres = Math.round(tasaInteres * 100.0) / 100.0;
        return tasaInteres;
    }
    
    public static double calc_periodoTiempo(double capital, double interes, double tasaInteres){
        double periodoTiempo = 0;
        // Periodo de tiempo = log (Interes/Capital + 1) / log (1 + tasa interes)
        periodoTiempo = Math.log10(interes/capital + 1) / Math.log10(1 + tasaInteres);
        periodoTiempo = Math.round(periodoTiempo * 100.0) / 100.0;
        return periodoTiempo;
    }
    
    
    public static void main(String[] args) {
        double interes, capital, tasaInteres, periodoTiempo;
        char opcion;
        
        Scanner caracter = new Scanner(System.in);
        Scanner real = new Scanner(System.in);
        do {
            System.out.println("\tMenu");
            System.out.println("a)Calculo del interes");
            System.out.println("b)Calculo del capital");
            System.out.println("c)Calculo de la tasa de interes");
            System.out.println("d)Calculo de el periodo del tiempo");
            System.out.println("e)Salir\n");
            System.out.print("Seleccione la opcion a realizar (a-e): ");
            opcion = caracter.next().charAt(0);
            opcion = Character.toLowerCase(opcion);
         
            switch(opcion){
                case 'a':
                    do {
                        System.out.println("Los valores deben ser mayores a 0");
                        System.out.print("Ingrese el capital: ");
                        capital = real.nextDouble();
                        System.out.print("Ingrese la tasa de interes: ");
                        tasaInteres = real.nextDouble();
                        System.out.print("Ingrese el periodo de tiempo: ");
                        periodoTiempo = real.nextDouble();
                    } while (capital <= 0 || tasaInteres <= 0 || periodoTiempo <= 0);
                    
                    interes = calc_interes(capital, tasaInteres, periodoTiempo);
                    
                    System.out.println("\nEl Interes con un capital de " + capital + 
                            " , una tasa de interes de " + tasaInteres + " y un periodo de tiempo de " + periodoTiempo + " es igual a " + interes);
                    break;
                case 'b':
                    do {
                        System.out.println("Los valores deben ser mayores a 0");
                        System.out.print("Ingrese el interes: ");
                        interes = real.nextDouble();
                        System.out.print("Ingrese la tasa de interes: ");
                        tasaInteres = real.nextDouble();
                        System.out.print("Ingrese el periodo de tiempo: ");
                        periodoTiempo = real.nextDouble();
                    } while (interes <= 0 || tasaInteres <= 0 || periodoTiempo <= 0);
                    
                    capital = calc_capital(interes, tasaInteres, periodoTiempo);
                    
                    System.out.println("\nEl capital con un interes de " + interes +
                            " , una tasa de interes de " + tasaInteres + " y un periodo de tiempo de " + periodoTiempo + " es igual a " + capital);
                    break;
                case 'c':
                    do {
                        System.out.println("Los valores deben ser mayores a 0");
                        System.out.print("Ingrese el interes: ");
                        interes = real.nextDouble();
                        System.out.print("Ingrese el capital: ");
                        capital = real.nextDouble();
                        System.out.print("Ingrese el periodo del tiempo: ");
                        periodoTiempo = real.nextDouble();
                    } while (interes <= 0 || capital <= 0 || periodoTiempo <= 0);
                    
                    tasaInteres = calc_tasaInteres(interes, capital, periodoTiempo);
                    
                    System.out.println("\nLa tasa de interes, con un interes de " + interes + 
                            " , un capital de " + capital + " y un periodo de tiempo de " + periodoTiempo + " es igual a " + tasaInteres);
                    break;
                case 'd':
                    do {
                        System.out.println("Los valores deben ser mayores a 0");
                        System.out.print("Ingrese el capital: ");
                        capital = real.nextDouble();
                        System.out.print("Ingrese el interes: ");
                        interes = real.nextDouble();
                        System.out.print("Ingrese la tasa de interes: ");
                        tasaInteres = real.nextDouble();
                    } while (capital <= 0 || interes <= 0 || tasaInteres <= 0);
                    
                    periodoTiempo = calc_periodoTiempo(capital, interes, tasaInteres);

                    System.out.println("\nEl periodo de tiempo, con un capital de " + capital +
                            " , un interes de " + interes + " y una tasa de interes de " + tasaInteres + " es igual a " + periodoTiempo);
                    break;
                case 'e':
                    System.out.println("Gracias por utilizar!");
                    break;
                default:
                    System.out.println("Por favor seleccione una opcion correcta (a-e)");
            }
        } while(opcion != 'e');
    }
}