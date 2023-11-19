/*
C++ Laboratorio 2 Ejercicio 6
Este programa convierte un numero binario a decimal
ENTRADAS: numero binario
SALIDAS: numero decimal
PROCESOS: 1. Pedir al usuario un numero decimal
          2. Se divide el numero para dos, y se almacena
          3. Se suma al numero binario el residuo mutiplicado por i
          4. Se multiplica i por 10
          5. Se divide el numero decimal entre dos
          6. Se repite el proceso hasta que el numero decimal sea 0
          7. Mostrar el resultado

AUTOR: Esteban Campoverde y Maria Fernanda Bravo
*/
#include <iostream>
#include <cmath>

int main()
{
    // la variable i es el exponente por el que se debe multiplicar el residuo
    int num, residuo = 0, numDecimal = 0, i = 0;
    std::cout << "Ingrese un numero binario: \n";
    std::cin >> num;

    while(num != 0)
    {
        residuo = num % 10;
        numDecimal = numDecimal + (residuo * pow(2, i));
        i++;
        num = num / 10;        
    }

    std::cout << "El numero decimal es: " << numDecimal << "\n";
}