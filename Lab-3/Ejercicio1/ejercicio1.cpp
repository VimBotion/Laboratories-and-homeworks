/*
C++ Laboratorio 3 Ejercicio 1
Este programa imprime la tabla de multiplicar del 1 al 10 de un numero
ENTRADAS: Numero 
SALIDAS: La tabla de multiplicar del numero
PROCESOS: 1. Pedir el numero
          2. Desde i hasta  10 multiplicar el numero por i 
          3. Mostrar el resultado 

AUTOR: Esteban Campoverde y Maria Fernanda Bravo
*/

#include <iostream>

int main()
{
  int num;
  std::cout << "Ingrese un numero: \n";
  std::cin >> num;

  for (int i = 1; i <= 10; i++)
  {
    int resultado = num * i;
    std::cout << num << " * " << i << " = " << resultado << "\n";
  }
  
}





