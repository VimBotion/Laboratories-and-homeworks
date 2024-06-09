/**
 * 2.Obtener valores correspondientes a triángulos rectángulos
 * @author Campoverde Esteban, Cabrera Franck, Apolo Juan
 */
import java.util.Scanner;
public class Calc_lados_trianguloRectangulo {
    public static void main(String[] args) {
        char opcion;
        double hipotenusa, cateto1, cateto2, agudo1, agudo2;
        
        Scanner caracter = new Scanner(System.in);
        Scanner real = new Scanner(System.in);
       
        
       
        do {
            System.out.println("\t Menu");
            System.out.println("a) Calcular la hipotenusa y los angulos agudos");
            System.out.println("b) Calcular un cateto y los angulos agudos");
            System.out.println("c) Calcular los catetos y un angulo agudo");
            System.out.println("d) Calcular la hipotenusa, un cateto y un ángulo agudo");
            System.out.println("e) Salir");
            System.out.print("Que desea realizar: ");
            opcion = real.next().charAt(0);
            // Convierte opcion a minusculas
            opcion = Character.toLowerCase(opcion);
            switch(opcion){
            case 'a':
                do {
                    System.out.println("Los valores deben ser mayores a 0!");
                    System.out.print("Ingrese el cateto 1: ");
                    cateto1 = real.nextDouble();
                    System.out.print("Ingrese el cateto 2: ");
                    cateto2 = real.nextDouble(); 
                } while(cateto1 <= 0 || cateto2 <= 0);
                // Hipotenusa = raizCuadrada(cateto1^2 + cateto2^2)
                hipotenusa = Math.sqrt((Math.pow(cateto1, 2.0) + Math.pow(cateto2, 2.0)));
                hipotenusa = Math.round(hipotenusa * 100) / 100;
                // Agudo = arctan(catetoOpuesto/catetoAdyacente)
                agudo1 = Math.toDegrees(Math.atan(cateto1/cateto2));
                agudo1 = Math.round(agudo1 * 100) / 100;
                agudo2 = Math.toDegrees(Math.atan(cateto2/cateto1));
                agudo2 = Math.round(agudo2 * 100.0) / 100.0;
                
                System.out.println("La hipotenusa con catetos de " + cateto1 + " " + cateto2 + "es " + hipotenusa);
                System.out.println("Los angulos agudos con catetos de " + cateto1 + " " + cateto2 + "es " + agudo1 + ", " + agudo2);
                break;
            case 'b':
                do {
                    System.out.print("Ingrese el valor de la hipotenusa: ");
                    hipotenusa = real.nextDouble();
                    System.out.print("Ingrese el valor del cateto: ");
                    cateto1 = real.nextDouble();
                } while (hipotenusa <= 0 || cateto1 <= 0);
                // Cateto = raizCuadrada(hipotenusa^2 - cateto1 ^ 2)
                cateto2 = Math.sqrt((Math.pow(hipotenusa, 2.0) - Math.pow(cateto1, 2.0)));
                cateto2 = Math.round(cateto2 * 100.0) / 100.0;
                // Agudo = acttan(catetoOpuesto/catetoAdyacente)
                agudo1 = Math.toDegrees(Math.atan(cateto1/cateto2));
                agudo1 = Math.round(agudo1*100.0) / 100.0;
                agudo2 = Math.toDegrees(Math.atan(cateto2/cateto1));
                agudo2 = Math.round(agudo2*100.0) / 100.0;
                
                System.out.println("El valor del otro cateto con hipotenusa de " + hipotenusa + " y un cateto de " + cateto1 + " es " + cateto2);
                System.out.println("Los angulos agudos son: " + agudo1 + " y " + agudo2);
                break;
            case 'c':
                do {
                    System.out.print("Ingrese el valor de la hipotenusa: ");
                    hipotenusa = real.nextDouble();
                    System.out.print("Ingrese el valor del angulo en grados: ");
                    agudo1 = real.nextDouble();
                } while (hipotenusa <= 0 || agudo1 <= 0 || agudo1 >= 90);
                double agudo1Rad = Math.toRadians(agudo1);
                cateto1 = hipotenusa * Math.sin(agudo1Rad);
                cateto1 = Math.round(cateto1 * 100.0) / 100.0;
                cateto2 = hipotenusa * Math.cos(agudo1Rad);
                cateto2 = Math.round(cateto2 * 100.0) / 100.0;
                agudo2 = 90 - agudo1;
                agudo2 = Math.round(agudo2 * 100.0) / 100.0;
                System.out.println("Catetos: " + cateto1 + ", " + cateto2);
                System.out.println("El valor del otro angulo agudo: " + agudo2);                    
                break;
            case 'd':
                do {
                    System.out.println("Ingrese el valor del cateto: ");
                    cateto1 = real.nextDouble();
                    System.out.println("Ingrese el valor del angulo agudo: ");
                    agudo1 = real.nextDouble();
                } while(cateto1 <= 0 || agudo1 <= 0);
                agudo1Rad = Math.toRadians(agudo1);
                hipotenusa = cateto1 / Math.sin(agudo1Rad);
                hipotenusa = Math.round(hipotenusa * 100.0) / 100.0;
                cateto2 = cateto1 / Math.tan(agudo1Rad);
                cateto2 = Math.round(cateto2 * 100.0) / 100.0;
                agudo2 = 90 - agudo1;
                
                System.out.println("Hipotenusa: " + hipotenusa);
                System.out.println("Cateto desconocido: " + cateto2);
                System.out.println("Angulo agudo desconocido: " + agudo2);
                    
                break;
            case 'e':
                System.out.println("Gracias por utilizar");
                break;
            default:
                System.out.println("Por favor ingrese una opcion valida!");
               
            }
        } while (opcion != 'e');
        
    } 
}
