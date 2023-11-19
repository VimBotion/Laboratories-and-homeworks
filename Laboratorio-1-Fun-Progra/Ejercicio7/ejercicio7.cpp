/*
C++ Laboratorio 1 Ejercicio 7
Este programa pide al usuario un número y muestra si es positivo o negativo
ENTRADAS: numero
SALIDAS: Si es positivo o negativo
PROCESOS: 1. Pedir el numero
          2. Comprobar si el numero es mayor a 0,menor a 0 o 0
          3. Mostrar el resultado

AUTOR: Esteban Campoverde y Johana Chungata
*/

#include <iostream>

using namespace std;

int main(){
    int num;
    cout << "Ingrese un numero: " << endl;
    cin >> num;

    if (num > 0)
    {
        cout << "El numero es positivo" << endl;
    }
    else if (num < 0)
    {
        cout << "El numero es negativo" << endl;
    }
    else {
        cout << "0 no es positivo ni negativo" << endl;
    }
}