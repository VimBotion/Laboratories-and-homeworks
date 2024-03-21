/**
 * Realizar un programa que permita calcular el valor de la multa, el número de puntos que se restarán 
 * y las observaciones si se cometen contravenciones de tránsito
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class CalculadoraMulta {
   public static void main(String[] args){
       double valorMulta = 0, puntosRestados = 0, RBU = 460;
       String observaciones = "";
       int opcion, opcion2;
       
       Scanner entero = new Scanner(System.in);
       
       System.out.println("\tInfracciones");
       System.out.println("1.Contraveccion de primera clase");
       System.out.println("2.Contraveccion de segunda clase");
       System.out.println("3.Contraveccion de tercera clase");
       System.out.println("4.Contraveccion de cuarta clase");
       System.out.println("5.Contraveccion de quinta clase");
       System.out.println("6.Contraveccion de sexta clase");
       System.out.println("7.Contraveccion de septima clase");
       System.out.println("8.Conduccion en Estado de Embriaguez");
       System.out.println("9.Salir");
       
       System.out.print("Seleccione el tipo de infraccion cometida (1-8): ");
       opcion = entero.nextInt();
       switch (opcion ){
           case 1:
               valorMulta = RBU * 1;
               puntosRestados = 10;
               observaciones = "3 dias de prision y aprension del vehiculo por 24 horas";
               break;
           case 2:
               valorMulta = RBU * 0.5;
               puntosRestados = 9;
               observaciones = "Ninguna observacion";
               break;
           case 3:
               valorMulta = RBU * 0.4;
               puntosRestados = 7.5;
               observaciones = "Ninguna observacion";
               break;
            case 4:
               valorMulta = RBU * 0.3;
               puntosRestados = 6;
               observaciones = "Ninguna observacion";
               break;
            case 5:
               valorMulta = RBU * 0.15;
               puntosRestados = 4.5;
               observaciones = "Ninguna observacion";
               break;
            case 6:
               valorMulta = RBU * 0.1;
               puntosRestados = 3;
               observaciones = "Ninguna observacion";
               break;
            case 7:
               valorMulta = RBU * 0.04;
               puntosRestados = 1.5;
               observaciones = "Ninguna observacion";
               break;
            case 8:
                System.out.println("Infracciones por conduccion en Estado de Embriaguez");
                System.out.println("1.Conductor de vehículos de transporte público liviano o pesado, comercial o de carga con un nivel de alcohol mayor a 0.1 gramos");
                System.out.println("2.Nivel de Alcohol de 0.3 a 0.8");
                System.out.println("3.Nivel de Alcohol mayor de 0.8 a 1.2");
                System.out.println("4.Nivel de Alcohol mayor a 1.2");
                System.out.println("5.Salir");
                System.out.println("Seleccione la infraccion cometida: ");
                opcion2 = entero.nextInt();
                
                switch (opcion2) {
                    case 1:
                        valorMulta = 0;
                        puntosRestados = 30;
                        observaciones = "Prision de 90 dias";
                        break;
                    case 2:
                        valorMulta = RBU * 1;
                        puntosRestados = 5;
                        observaciones = "5 dias de prision";
                        break;
                    case 3:
                        valorMulta = RBU * 2;
                        puntosRestados = 10;
                        observaciones = "15 dias de prision";
                        break;
                    case 4:
                        valorMulta = RBU * 3;
                        puntosRestados = 0;
                        observaciones = "Suspension de licencia por 60 dias y 30 dias de prision";
                        break;
                    case 5:
                        System.out.println("Gracias por usar");
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida!");
                        break;
                }
                break;
            case 9:
                System.out.println("Gracias por usar");
                break;
            default:
                System.out.println("Ingrese una opcion valida!");
       }
       System.out.printf("Valor de la multa: %.2f\n", valorMulta);
       System.out.printf("Puntos a restar: %.2f\n", puntosRestados);
       System.out.println("Observaciones: " + observaciones);
   }
}
