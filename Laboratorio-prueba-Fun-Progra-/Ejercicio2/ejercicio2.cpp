/*
# Laboratorio Ejercicio 6.2
# Este programa utiliza una funcion FACTORIAL para calcular el factorial de un numero en el rango 1 a 100
# ENTRADA: numero
# SALIDA: el factorial del numero
# PROCESOS: 1. Pedir al usuario 1 numero
#           2. Verificar si el numero se encuentre entre el rango permitido 
#           3. Crear la funcion factorial con parametro num de tipo int
#           4. Llamar a la funcion factorial recursivamente restando menos 1 al valor de num hasta que suvalor sea 1
#           5. Mostrar el resultado
# Autor: Esteban Campoverde
*/

#include <iostream>

double factorial(double num);

int main()
{
    int num = 0;
    double resultado = 0;
    do 
    {
        std::cout << "Ingrese el numero: \n";
        std::cin >> num;
    } while (num < 1 || num > 100);
    resultado = factorial(num);
    std::cout << "El factorial es: " << resultado << "\n";

}

double factorial(double num)
{
    if (num == 1)
    {
        return 1;
    }

    return num * factorial(num - 1);
}