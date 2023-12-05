/*
# Laboratorio Ejercicio 6.9
# Este programa utiliza una función booleana Digito que determine
# si un carácter es uno de los dígitos 0 al 9.
# PROCESOS: 1. Pedir al usuario un caracter
#           2. Mediante una funcion bool, determinar si el caracter es un digito del 0 al 9
#           3. Mostrar el resultado
# Autor: Esteban Campoverde
*/

#include <iostream>

bool esDigito(char num);

int main()
{
    char digito;
    std::cout << "Ingrese un caracter: \n";
    std::cin >> digito;
    
    if (esDigito(digito))
    {
        std::cout << "El caracter si es un digito entre 0 al 9\n";
    }
    else
    {
        std::cout << "No es un digito entre 0 al 9\n";
    }
}

bool esDigito(char num)
{
    return (num >= '0' && num <= '9');    
}