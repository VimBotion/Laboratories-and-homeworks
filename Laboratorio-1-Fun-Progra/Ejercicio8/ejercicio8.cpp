/*
C++ Laboratorio 1 Ejercicio 8
Este programa pide al usuario que ingrese una letra y determina si es vocal o no
ENTRADAS: letra
SALIDAS: Si es vocal o no
PROCESOS: 1. Pedir una letra
          2. Comprobar que la letra sea vocal
          3. Mostrar el resultado
AUTOR: Esteban Campoverde y Johana Chungata
*/

#include <iostream>
#include <cctype>

using namespace std;

int main(){
    char esVocal;

    cout << "Ingrese una letra: " << endl;
    cin >> esVocal;
    esVocal = tolower(esVocal);


    if (esVocal == 'a' | esVocal == 'e' | esVocal == 'i' | esVocal == 'o' | esVocal == 'u')
    {
        cout << "La letra es una vocal: " << esVocal << endl;
    }
    else 
    {
        cout << "No es una vocal" << endl;
    }
}