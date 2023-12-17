/*
C++ Laboratorio 3 Ejercicio 2
Este programa calcula el factorial de un numero 
ENTRADAS: Numero 
SALIDAS: El factorial del numero 
PROCESOS: 1. Pedir el numero
          2. Utilizar una funcion recursiva con caso base n = 1, que disminuya el valor de n (num)
          3. Mostrar el resultado

AUTOR: Esteban Campoverde y Maria Fernanda Bravo
*/

#include <iostream>

int factorial(int num);
int main()
{
    int num;
    std::cout << "Ingrese un numero:\n";
    std::cin >> num;
    int resultado = factorial(num);

    std::cout << "El factorial es: " << num << "\n";
}

int factorial(int num)
{
    if (num == 0)
    {
        num = 1;
        return num;
    }

    return num * factorial(num -1);
}