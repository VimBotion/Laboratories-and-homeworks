/*
C++ Laboratorio 2 Ejercicio 7
Este programa utiliza el algoritmo de Luhn para verificar si una cedula ecuatoriana es valida
ENTRADAS: numero de cedula
SALIDAS: si el numero de cedula es valido o no
PROCESOS: 1. Pedir al usuario el numero de cedula
          2. Verificar que el numero de cedula tenga 10 digitos
          3. Recorrer el numero de la cedula de derecha a izquierda
          4. Si la posicion es par, se debe multiplicar por 2 y sumar a la variable sumaDigitos
          4. Si la posicion es impar, sumar a la variable sumaDigitos
          5. Si la suma de los digitos no tiene residuo, osea es divisible para 10, el numero de cedula es valido.
          6. Mostrar el resultado


AUTOR: Esteban Campoverde y Maria Fernanda Bravo
*/
#include <iostream>
#include <string>

int main()
{
    std::string numCedula;
    int digitoPar, digitoImpar, sumaDigitos = 0;

    std::cout << "Ingrese su numero de cedula: \n";
    std::cin >> numCedula;

    if (numCedula.length() != 10)
    {
        std::cout << "Error. El numero de cedula debe tener 10 digitos\n";
    }

    // Se resta uno por que el indice empieza en 0
    for(int i = (numCedula.length() - 1); i >= 0; i--)
    {
        if (i % 2 == 0)
        {
            // Se resta el caracter '0' para obtener el convertir el numero (char) a int acorde a la tabla ASCII
            digitoPar = (numCedula[i] - '0') * 2; // Ejemplo, el caracter 5, en Ascii el numero 0 es 48 y el numero 5 es 53, por lo tanto 53 - 48 = 5 (el int 5)

            if (digitoPar > 9)
            {
                digitoPar -= 9;
            }
            sumaDigitos += digitoPar;
        } 
        else 
        {
            digitoImpar = (numCedula[i] - '0');
            sumaDigitos += digitoImpar;
        }
    }

    if (sumaDigitos % 10 == 0)
    {
        std::cout << "El número de cedula es válido de acuerdo a la fórmula de Luhn\n";
    }
    else
    {
        std::cout << "El número de cedula es inválido de acuerdo a la fórmula de Luhn\n";
    }
}