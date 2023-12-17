/*
# Laboratorio Ejercicio 6.11
# Este programa utiliza una función que permita devolver el valor absoluto de un número.
# PROCESOS: 1. Pedir el dividendo y el divisor
#           2. Mediante una funcion, restar el dividendo - el divisor hasta que este sea >= divisor
#           3. Aumentar mas uno el contador
#           4. Mostrar el resultado, si sobra algo en el divisor ese es el residuo
# Autor: Esteban Campoverde
*/

#include <iostream>

void division(int dividendo, int divisor);

int main()
{
    int dividendo, divisor;
    std::cout << "Ingrese el dividendo: \n";
    std::cin >> dividendo;
    std::cout << "Ingrese el divisor: \n";
    std::cin >> divisor;

    division(dividendo, divisor);
}

void division(int dividendo, int divisor)
{
    int contador = 0;
    while(dividendo >= divisor)
    {
        dividendo -= divisor;
        contador++;
    }

    std::cout << "La division es igual a: " << contador << "\n";
    std::cout << "El residuo es igual a: " << dividendo << "\n";
}