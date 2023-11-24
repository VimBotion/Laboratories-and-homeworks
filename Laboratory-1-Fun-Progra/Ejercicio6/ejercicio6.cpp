/*
C++ Laboratorio 1 Ejercicio 
Este programa pide al usuario 3 numeros y los muestra ordenados de mayor a menos
ENTRADAS: 3 numeros
SALIDAS: Los numeros ordenados de mayor a menor
PROCESOS: 1. Pedir al usuario 3 numeros
          2. Comprobar si el primero es mayor al segundo, intercambiar sus valores
          3. Comprobar si el primero es mayor al tercero, intercambiar sus valores
          3. Comprobar si el segundo es mayor al tercero, intercambiar sus valores
          4. Mostrar el resultado 

AUTOR: Esteban Campoverde y Johana Chungata
*/

#include <iostream>

using namespace std;

int main(){
    int num1, num2, num3;

    cout << "Ingrese el primer numero: " << endl;
    cin >> num1;
    cout << "Ingrese el segundo numero: " << endl;
    cin >> num2;
    cout << "Ingrese el tercer numero: " << endl;
    cin >> num3;

    if (num1 > num2)
    {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
    if (num1 > num3)
    {
        int temp = num1;
        num1 = num3;
        num3 = temp;
    }
    if (num2 > num3)
    {
        int temp = num2;
        num2 = num3;
        num3 = temp;
    }

    cout << num1 << " "<< num2 << " " << num3 << endl;

}