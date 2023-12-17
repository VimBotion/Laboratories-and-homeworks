/*
# Laboratorio Ejercicio 6.1
# Este programa utiliza una funcion para calcular la media de tres numeros ingresados por teclado
# ENTRADA: 3 numeros
# SALIDA: la media de los 3 numeros
# PROCESOS: 1. Pedir al usuario 3 numeros
#           2. Calcular la suma de los 3 numeros mediante una funcion
#           3. Utilizando otra funcion, calcular la division de los 3 numeros (media)
#           4. Mostrar el resultado
# Autor: Esteban Campoverde
*/

#include <iostream>
#include <iomanip>

float suma(float num1, float num2, float num3);
float division(float num1, float num2, float num3);

int main()
{
    float num1 = 0, num2 = 0, num3 = 0, resultado = 0;
    std::cout << "Ingrese el primer numero: \n";
    std::cin >> num1;
    std::cout << "Ingrese el segundo numero: \n";
    std::cin >> num2;
    std::cout << "Ingrese el tercer numero: \n";
    std::cin >> num3;

    resultado = division(num1, num2, num3);
    std::cout << "La media es: " << std::setprecision(4) << resultado << "\n";
}

float suma(float num1, float num2, float num3)
{
    return num1 + num2 + num3;
}

float division(float num1, float num2, float num3)
{
    float resultado = suma(num1, num2, num3);
    return resultado / 3;
}