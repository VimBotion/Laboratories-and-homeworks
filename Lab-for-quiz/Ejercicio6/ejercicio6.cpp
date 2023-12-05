/*
# Laboratorio Ejercicio 6.6
# Este programa utiliza un procedimiento que acepte un número de mes, un número de día y un número de año y los vi-
# sualice en el formato dd/mm/aa
# ENTRADA: el dia, el mes y el anio
# SALIDA: la fecha en el formato dd/mm/aa
# PROCESOS: 1. Pedir al usuario el dia, mes y año
#           2. Mediante un procedimiento convertir el dia, mes y año a string
#           3. Formatear el anio para que devuelva los dos ultimos digitos
#           4. Mostrar el resultado
# Autor: Esteban Campoverde
*/
#include <iostream>
#include <string>

void formatearFecha(int dia, int mes, std::string anio);
std::string formatearAnio(std::string anio);

int main()
{
    int dia, mes;
    std::string anio;

    std::cout << "Ingrese el dia: \n";
    std::cin >> dia;
    std::cout << "Ingrese el mes: \n";
    std::cin >> mes;
    std::cout << "Ingrese el anio: \n";
    std::cin >> anio; 
    formatearFecha(dia, mes, anio);
}

void formatearFecha(int dia, int mes, std::string anio)
{
    if (dia < 1 || dia > 31)
    {
        std::cout << "Ingrese un número de dia valido \n";
        return;
    }
    else if (mes < 1 || mes > 12 )
    {
        std::cout << "Ingrese un número de mes valido \n";
        return;
    }

    std::string anioFormateado = formatearAnio(anio);

    std::cout << dia << "/" << mes << "/" << anioFormateado << "\n";
}

std::string formatearAnio(std::string anio)
{
    int anioLength = anio.length() - 2;
    std::string anioFormateado = anio.substr(anioLength, 2);
    return anioFormateado;
}

