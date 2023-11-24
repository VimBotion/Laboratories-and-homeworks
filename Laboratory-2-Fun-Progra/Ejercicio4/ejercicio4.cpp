/*
C++ Laboratorio 2 Ejercicio 4
Este programa pide al usuario que ingrese un numero difrente de 5, y le muestra un mensaje si ingresa el numero 5
ENTRADAS: numero
SALIDAS: Mensaje si el usuario ingresa 5
PROCESOS: 1. Pedir al usuario un numero
          2. Verificar si el numero es diferente de 5
          3. Si es diferente de 5, continuar pidiendo al usuario que ingrese un numero diferente de 5
          4. Si es 5, mostrar al usuario un mensaje

AUTOR: Esteban Campoverde y Maria Fernanda Bravo
*/
#include <iostream>

int main()
{
    int num;
    do {
        std::cout << "Ingrese un numero diferente de 5:\n";
        std::cin >> num;
    } while (num != 5);

    std::cout << "¡Oye! ¡No se suponía que debías ingresar 5!\n";
}