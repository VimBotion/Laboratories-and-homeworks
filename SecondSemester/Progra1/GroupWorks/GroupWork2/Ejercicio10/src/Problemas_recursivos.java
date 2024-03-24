/*
 * 10. Escribir un programa que utilizando metodos recursivos resuelva cada una de las opciones del menu.
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.util.Scanner;
public class Problemas_recursivos {
    public static void generarBinarios(int numeroBits, String resultado){
        if (numeroBits == 0){
            System.out.println(resultado);
            return;
        } 
        generarBinarios(numeroBits - 1, resultado + "0");
        generarBinarios(numeroBits - 1, resultado + "1");
    }
    
    public static void torreHanoi(int numDiscos, char varillaA, char varillaB, char varillaC){
        if (numDiscos == 1){
            System.out.println("Mover disco 1 de la varilla " + varillaA + " hacia la varilla " + varillaB);
            return;
        }
        torreHanoi(numDiscos-1, varillaA, varillaC, varillaB);
        System.out.println("Mover disco " + numDiscos + " de la varilla " + varillaA + " hacia la varilla " + varillaB);
        torreHanoi(numDiscos-1, varillaC, varillaB, varillaA);
    }
    public static void main(String[] args) {
        int numero;
        char opcion;
        Scanner caracter = new Scanner(System.in);
        Scanner entero = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("1. Generar todos los numeros binarios de n bits");
            System.out.println("2. Torres de Hanoi");
            System.out.println("3. Salir");
            System.out.println("Que desea realizar: ");
            opcion = caracter.next().charAt(0);
            
            
            switch(opcion){
                case '1':
                    do {
                      System.out.println("Ingrese el numero de bits, mayor a 0: ");
                        numero = entero.nextInt();  
                    } while (numero <= 0);
                    generarBinarios(numero, "");
                    break;
                case '2':
                    do {
                      System.out.println("Ingrese el numero de discos: ");
                        numero = entero.nextInt();  
                    } while (numero <= 0);
                    torreHanoi(numero, 'A', 'B', 'C');
                    break;
                case '3':
                    System.out.println("Gracias por utilizar");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida!");            
            }
            
            do{
                System.out.println("Desea continuar? s/n: ");
                opcion = caracter.next().charAt(0);
                opcion = Character.toLowerCase(opcion);
            } while(opcion != 's' && opcion != 'n');
        } while (opcion == 's');
    }
    
}
