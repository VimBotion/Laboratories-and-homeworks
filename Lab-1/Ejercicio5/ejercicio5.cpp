/*
C++ Laboratorio 1 Ejercicio 5
Este programa pide al usuario un número comprendido entre el 1 al 12 e indica el nombre del mes correspondiente.
ENTRADAS: numero
SALIDAS: El nombre del mes
PROCESOS: 1. Pedir el numero entre 1 y 12
          2. Comprobar que el numero se encuentre entre 1 y 12
          3. Utilizar un switch para mostrar el nombre del mes segun el numero
          4. Mostrar el resultado 

AUTOR: Esteban Campoverde y Johana Chungata
*/

#include <iostream>

using namespace std;

int main(){
    int num;

    do{
        cout << "Ingrese un numero del 1 al 12" << endl;
    cin >> num;
    } while(num < 1 | num > 12);
    
    switch (num)
    {
    case 1:
        cout << "Enero" << endl;
        break;
    case 2:
        cout << "Febrero" << endl;
        break;
    case 3:
        cout << "Marzo" << endl;
        break;
    case 4:
        cout << "Abril" << endl;
        break;
    case 5:
        cout << "Mayo" << endl;
        break;
    case 6:
        cout << "Junio" << endl;
        break;
    case 7:
        cout << "Julio" << endl;
        break;
    case 8:
        cout << "Agosto" << endl;
        break;
    case 9:
        cout << "Septiembre" << endl;
        break;
    case 10:
        cout << "Octubre" << endl;
        break;
    case 11:
        cout << "Noviembre" << endl;
        break;
    case 12:
        cout << "Diciembre" << endl;
        break;
    }

}