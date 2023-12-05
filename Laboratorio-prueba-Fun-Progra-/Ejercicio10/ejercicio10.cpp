/*
# Laboratorio Ejercicio 6.0
# Este programa utiliza una función que permita devolver el valor absoluto de un número.
# PROCESOS: 1. Pedir un numero
#           2. Mediante una funcion devolver el valor absoluto
#           3. Quitar el signo al numero ingresado al multiplicar por menos uno si es negativo, si no devolver el numero
#           3. Mostrar el resultado
# Autor: Esteban Campoverde
*/

#include <iostream>

int valorAbsoluto(int num);

int main()
{
    int num = 0;
    std::cout << "Ingrese un numero: \n";
    std::cin >> num;

    int numeroValorAbsoluto = valorAbsoluto(num);
    std::cout << "El valor absoluto del numero es: " << valorAbsoluto(num) << "\n";
}

int valorAbsoluto(int num)
{
    if (num < 0)
    {
        return num * (-1);
    }
    else
    {
        return num;
    }
    
}