/*
C++ Laboratorio 2 Ejercicio 1
Este programa calcula el promedio de la edad de una familia de 6 integrantes
ENTRADAS: Edad de los integrantes de la familia
SALIDAS: Promedio
PROCESOS: 1. Pedir las edades
          2. Calcular el promedio
          3. Mostrar el resultado  

AUTOR: Esteban Campoverde y Maria Fernanda Bravo
*/
#include <iostream>

int main()
{
    float edad1, edad2, edad3, edad4, edad5, edad6;

    std::cout << "Ingrese la edad del padre: \n";
    std::cin >> edad1;
    std::cout << "Ingrese la edad de la madre: \n";
    std::cin >> edad2;
    std::cout << "Ingrese la edad del primer hijo: \n";
    std::cin >> edad3;
    std::cout << "Ingrese la edad del segundo hijo: \n";
    std::cin >> edad4;
    std::cout << "Ingrese la edad del tercer hijo: \n";
    std::cin >> edad5;
    std::cout << "Ingrese la edad del cuarto hijo: \n";
    std::cin >> edad6;

    float promedioEdades = (edad1 +edad2 + edad3 + edad4 +edad5 + edad6) / 6;
    std::cout << "El promedio de las edades es: " << promedioEdades << "\n";

    return 0;
}