/*
# Laboratorio Ejercicio 6.3
# Este programa utiliza una funcion para calcular el maximo comun divisor de dos numeros
# ENTRADA: numero
# SALIDA: el factorial del numero
# PROCESOS: 1. Pedir al usuario 2 numeros
#           2. Crear una funcion que calcule el maximo comun divisor de dos numeros
#           3. Calcular el modulo del primer numero entre el segundo numero
#           4. Llamar a la funcion factorial recursivamente restando menos 1 al valor de num hasta que suvalor sea 1
#           5. Mostrar el resultado
# Autor: Esteban Campoverde
*/

#include <iostream>

int maximoComun(int num1, int num2);

int main()
{
    int num1= 0, num2 = 0, resultado = 0;
    std::cout << "Ingrese el primer numero : \n";
    std::cin >> num1;
    std::cout << "Ingrese el segundo numero : \n";
    std::cin >> num2;

    resultado = maximoComun(num1, num2);

    std::cout << "El maximo comun divisor es: " << resultado << "\n";
}

int maximoComun(int num1, int num2)
{
    int residuo = num1 % num2;
    while (residuo != 0)
    {
        num1 = num2;
        num2 = residuo;
        residuo = num1 % num2;
    }

    return num2;
}
