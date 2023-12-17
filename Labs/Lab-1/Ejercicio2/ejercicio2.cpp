/*
C++ Laboratorio 1 Ejercicio 2
Este programa evalua unas expresiones aritmeticas 
ENTRADAS: No existe
SALIDAS: El resultado de las expresiones
PROCESOS: 1. Utilizar las librerias necesarias para realizar las expresiones aritmeticas
          2. Utilizar de <cmath> la funcion sqrt para la raiz de 16 y 16.0
          3. Mostrar el resultado en Fahrenheit  

AUTOR: Esteban Campoverde y Johana Chungata
*/

#include <iostream>
#include <cmath>

using namespace std;

int main() {
    // Para la raiz de 16.0
    float expresion1 = sqrt(16.0);
    cout << "El resultado de la raiz 16.0 es: " << expresion1 << endl;

    // Para la raiz de 16
    int expresion2 = sqrt(16);
    cout << "El resultado de la raiz 16 es: " << expresion2 << endl;

    // Para la expresion (7+raiz de 4)/ 3.0
    float expresion3 = (7 + sqrt(4)) / 3.0;
    cout << "El resultado de (7+raiz de 4): " << expresion3 << endl;

    // Para 2 ^ 3
    int expresion4 = pow(2, 3);
    cout << "El resultado de 2 ^ 3 es: " << expresion4 << endl;

    // Para valor absoluto de -45
    int expresion5 = abs(-45);
    cout << "El resultado del valor absoluto de -45 es: " << expresion5 << endl;

}