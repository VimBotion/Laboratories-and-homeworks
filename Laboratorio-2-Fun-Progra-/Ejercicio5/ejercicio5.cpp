/*
C++ Laboratorio 2 Ejercicio 5
Este programa convierte un numero decimal a binario
ENTRADAS: numero decimal
SALIDAS: numero binario
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

int main()
{
    // La variable i se usa para multiplicar el residuo por 10 para que el residuo se almacene en la posicion correcta
    int num, residuo = 0, numBinario = 0, i = 1;
    std::cout << "Ingrese un numero decimal: \n";
    std::cin >> num;

    while(num != 0)
    {
        residuo = num % 2;
        numBinario = numBinario + (residuo * i);
        i = i * 10;
        num = num / 2;
    }
    std::cout << "El numero binario es: " << numBinario << "\n";
}