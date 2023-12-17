/*
C++ Laboratorio 2 Ejercicio 2
Este programa calcula cuantos digitos tiene un entero positivo
ENTRADAS: Numero entero positivo
SALIDAS: Numero de digitos que tiene el numero
PROCESOS: 1. Pedir el numero
          2. Revisar si el numero es positivo
          3. Mientras el numero sea mayor a 0
            -Dividir el numero para 10
            -Aumentar el contador
          4. Mostrar el numero de digitos (contador)  

AUTOR: Esteban Campoverde y Maria Fernanda Bravo
*/
#include <iostream>

int main()
{
    int numIngresado = 0; 
    int cont = 0;

    std::cout << "Ingrese un numero positivo: \n";
    std::cin >> numIngresado;
    int num = numIngresado;

    if (num <= 0)
    {
        std::cout << "Debe ingresar un numero positivo! \n";
        return 1;
    }
    while(num > 0)
    {
        num = num / 10;
        cont++;
    }
    std::cout << "El numero " << numIngresado << " contiene: " << cont << " digitos\n";  
}