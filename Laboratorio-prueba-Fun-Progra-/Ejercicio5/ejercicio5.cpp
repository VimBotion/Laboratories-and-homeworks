/*
# Laboratorio Ejercicio 6.5
# Este programa utiliza una funcion que calcula x^n donde x es de tipo real y n de tipo entero
# ENTRADA: la base, el exponente
# SALIDA: el resultado del numero elevado al exponente
# PROCESOS: 1. Pedir al usuario la base del numero (x) y el exponente(n)
#           2. Utilizar una funcion que multiplique el numero x, n veces 
#           3. Mostrar el resultado
# Autor: Esteban Campoverde
*/

#include <iostream>

float potencia(float x, int n);

int main()
{
    float x;
    int n;
    std::cout << "Ingrese la base: \n";
    std::cin >> x;
    std::cout << "Ingrese el exponente \n";
    std::cin >> n;

    float resultado = potencia(x, n);
    std::cout << "El resultado es: " << resultado << "\n";
}

float potencia(float x, int n)
{
    float resultado = 1;
    for (int i = 1; i <= n; i++)
    {
        resultado *= x;
    }
    return resultado;
}