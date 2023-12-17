/*
C++ Laboratorio 1 Ejercicio 
Este programa calcula el incremento en el sueldo de un trabajador de una empresa que cobra 40.000 USD anuales.
El programa debe realizar los cálculos en función de diferentes criterios: 
ENTRADAS: Tiempo del trabajador en la empresa
SALIDAS: El incremento en el sueldo
PROCESOS: 1. Pedir el tiempo que lleva el trabajador en la empresa
          2. Si lleva mas de 10 años en la empresa se le aplica un aumento del 10%.
          3. Si_no_ si lleva menos de 10 años pero más que 5 se le aplica un aumento del 7%.
          4. Si_no_ si Si lleva menos de 5 años pero más que 3 se le aplica un aumento del 5%.
          5. Si_no si lleva menos de 3 años se le aplica un aumento del 3%.


AUTOR: Esteban Campoverde y Johana Chungata
*/

#include <iostream>

using namespace std;

int main(){
    float sueldo = 40000;
    float aumento = 0;
    int tiempo;
    cout << "Ingrese el tiempo que lleva el trabajador en la empresa: " << endl;
    cin >> tiempo;

    if (tiempo < 0)
    {
        cout << "Ingrese un valor valido" << endl;
        return 1;
    }

    if (tiempo > 10)
    {
        aumento = sueldo + (sueldo * 10/100);
    }
    else if (tiempo > 5)
    {
        aumento = sueldo + (sueldo * 7/100);
    }
    else if (tiempo > 3)
    {
        aumento = sueldo + (sueldo * 5/100);
    }
    else
    {
        aumento = sueldo + (sueldo * 3/100);
    }
    sueldo += aumento;
    cout << "El aumento es de: " << aumento << " el sueldo total va a ser de: " << sueldo << endl;
}