/**
 *
 * @author Campoverde Esteban
 */
import java.util.Scanner;
public class Matematicas_Financieras {
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
            // toLowerCase convierte "opcion" a minusculas
            opcion = Character.toLowerCase(opcion);
         
            switch(opcion){
                case 'a':
                    System.out.print("Ingrese el capital: ");
                    capital = real.nextDouble();
                    System.out.print("Ingrese la tasa de interes: ");
                    tasaInteres = real.nextDouble();
                    System.out.print("Ingrese el periodo de tiempo: ");
                    periodoTiempo = real.nextDouble();
                    // Interes = capital((1+tasaInteres)^periodoTiempo - 1)
                    interes = capital*((Math.pow(1 + tasaInteres, periodoTiempo)) -1);
                    interes = Math.round(interes * 100.0) / 100.0;
                    System.out.println("\nEl Interes con un capital de " + capital + 
                            " , una tasa de interes de " + tasaInteres + " y un periodo de tiempo de " + periodoTiempo + " es igual a " + interes);
                    break;
                case 'b':
                    System.out.print("Ingrese el interes: ");
                    interes = real.nextDouble();
                    System.out.print("Ingrese la tasa de interes: ");
                    tasaInteres = real.nextDouble();
                    System.out.print("Ingrese el periodo de tiempo: ");
                    periodoTiempo = real.nextDouble();
                    // Capital = Interes / (1+tasaInteres)^periodoTiempo - 1
                    capital = interes / ((Math.pow(1 + tasaInteres, periodoTiempo)) - 1);
                    capital = Math.round(capital * 100.0) / 100.0;
                    System.out.println("\nEl capital con un interes de " + interes +
                            " , una tasa de interes de " + tasaInteres + " y un periodo de tiempo de " + periodoTiempo + " es igual a " + capital);
                    break;
                case 'c':
                    System.out.print("Ingrese el interes: ");
                    interes = real.nextDouble();
                    System.out.print("Ingrese el capital: ");
                    capital = real.nextDouble();
                    System.out.print("Ingrese el periodo del tiempo: ");
                    periodoTiempo = real.nextDouble();
                    // TasaInteres = (interes/capital + 1)^1/periodoTiempo) - 1
                    tasaInteres = (Math.pow(interes/capital + 1, 1.0/periodoTiempo)) - 1;
                    tasaInteres = Math.round(tasaInteres * 100.0) / 100.0;
                    System.out.println("\nLa tasa de interes, con un interes de " + interes + 
                            " , un capital de " + capital + " y un periodo de tiempo de " + periodoTiempo + " es igual a " + tasaInteres);
                    break;
                case 'd':
                    System.out.print("Ingrese el capital: ");
                    capital = real.nextDouble();
                    System.out.print("Ingrese el interes: ");
                    interes = real.nextDouble();
                    System.out.print("Ingrese la tasa de interes: ");
                    tasaInteres = real.nextDouble();
                    periodoTiempo = 
                    break;
                case 'e':
                    System.out.println("Gracias por utilizar!");
                    break;
                default:
                    System.out.println("Por favor seleccione una opcion correcta (a-e)");
            }
        }while(opcion != 'e');
        

    
    }
    
}
