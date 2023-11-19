/*
# Laboratorio Ejercicio 6.4
# Este programa utiliza una funcion para calcular el mayor de dos numeros enteros
# ENTRADA: num1, num2
# SALIDA: el mayor de ambos numeros
# PROCESOS: 1. Pedir al usuario 2 numeros
#           2. Crear una funcion que calcule el mayor de ambos numeros enteros
#           3. Mostrar el resultado
# Autor: Esteban Campoverde
*/

#include <iostream>

int numMayor(int num1, int num2);

int main()
{
    int num1, num2, resultado;
    std::cout << "Ingrese el numero 1 \n";
    std::cin >> num1;
    std::cout << "Ingrese el numero 2 \n";
    std::cin >> num2;

    if (num1 == num2)
    {
        std:: cout << "Ambos numeros son iguales \n";
    }
    else
    {
        resultado = numMayor(num1, num2);
        std::cout << "El numero mayor es: " << resultado << "\n";
    }
}

int numMayor(int num1, int num2)
{
    if (num1 > num2)
    {
        return num1;
    } 
    else
    {
        return num2;
    } 
}