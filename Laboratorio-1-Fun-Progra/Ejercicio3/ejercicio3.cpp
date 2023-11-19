/*
C++ Laboratorio 1 Ejercicio 3
Este programa imprime si un numero es primo o no
ENTRADAS: numero
SALIDAS: si el numero es primo o no
PROCESOS: 1. Pedir el numero
          2. Comprobar que el numero ingresado este entre 1 y 5
          3. Comprobar si el numero es primo o no
          4. Imprimir la respuesta

AUTOR: Esteban Campoverde y Johana Chungata
*/

#include <iostream>

using namespace std;

int main() {
    int num;
    bool primo = true;
    do
    {
        cout << "Ingrese un numero entre 1-5: " << endl;
        cin >> num;
    } while (num < 1 | num > 5);

    if (num == 1) {
        primo = false;
    }
    else
    {
        for (int i = 2; i <= num/2; i++)
        {
            if(num % i == 0) 
            {
                primo = false;
                break;
            }
        }
    }

    if(primo) {
        cout << "El numero es primo" << endl;
    }
    else
    {
        cout << "No es primo" << endl;
    }
}