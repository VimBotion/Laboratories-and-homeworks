/*
C++ Laboratorio 2 Ejercicio 3
Este programa actua como una maquina dispensadora de bebidas, muestra al usuario 5 opciones y le 
permite ingresar su eleccion.
ENTRADAS: La eleccion del usuario
SALIDAS: La bebida que eligio el usuario
PROCESOS: 1. Mostar las bebidas
          2. Pedir la eleccion del usuario
          3. Utilizar un switch, cuyo default muestre un mensaje de error si la eleccion no es valida
          4. Mostrar la eleccion del usuario  

AUTOR: Esteban Campoverde y Maria Fernanda Bravo
*/
#include <iostream>

int main()
{
    int eleccion;
    std::cout << "Elija quie bebida va a llevar: \n";
    std::cout << "1. Coca-Cola\n";
    std::cout << "2. Agua\n";
    std::cout << "3. Sprite\n";
    std::cout << "4. Jugo\n";
    std::cout << "5. Leche\n";
    std::cin >> eleccion;

    switch (eleccion)
    {
        case 1:
            std::cout << "Escogio: Coca-Cola\n";
            break;
        case 2:
            std::cout << "Escogio: Agua\n";
            break;
        case 3:
            std::cout << "Escogio: Sprite\n";
            break;
        case 4:
            std::cout << "Escogio: Jugo\n";
            break;
        case 5:
            std::cout << "Escogio: Leche\n";
            break;
        default:
            std::cout << "Error. La eleccion no fue valida!\n";
            break;
    }
    
}