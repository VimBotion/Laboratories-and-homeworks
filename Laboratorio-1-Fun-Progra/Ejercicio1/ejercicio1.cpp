/*
C++ Laboratorio 1 Ejercicio 1
Este programa convierte de Celsius a Fahrenheit
ENTRADAS: Temperatura en Celsius
SALIDAS: Temperatura en Fahrenheit
PROCESOS: 1. Pedir la temperatura
          2. Utilizar la formula (9/5) TC + 32
          3. Mostrar el resultado en Fahrenheit  

AUTOR: Esteban Campoverde y Johana Chungata
*/

#include <iostream>

using namespace std;

int main()
{
    float temperaturaCelsius;
    float temperaturaFahrenheit;
    cout << "Ingrese la temperatura en Celsius: " << endl;
    cin >> temperaturaCelsius;
    temperaturaFahrenheit = (float) 9/5 * temperaturaCelsius + 32;
    cout << "La temperatura en Fahrenheit es: " << temperaturaFahrenheit << endl;

}