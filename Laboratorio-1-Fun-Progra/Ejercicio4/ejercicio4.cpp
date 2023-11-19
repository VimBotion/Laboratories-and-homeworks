/*
C++ Laboratorio 1 Ejercicio 4
Este programa pide al usuario un numero positivo y determina si es par o impar
ENTRADAS: Numero
SALIDAS: Si el numero es par o impar
PROCESOS: 1. Pedir al usuario un numero
          2. Comprobar con mod si el numero es par o impar
          3. Mostrar el resultado

AUTOR: Esteban Campoverde y Johana Chungata
*/

#include <iostream>

using namespace std;

int main() 
{
    int num;
    do {
        cout << "Ingrese un numero positivo: " << endl;
        cin >> num;
    } while(num < 1);

    if (num % 2 == 0)
    {
        cout << "El numero: " << num << " es par" << endl;
    }
    else 
    {
        cout << "El numero: " << num << " es impar" << endl;
    }

}