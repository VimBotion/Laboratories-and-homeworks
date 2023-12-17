/*
# Laboratorio Ejercicio 6.7.
# Este programa utiliza un procedimiento que realice la conversión
# de coordenadas polares (r, θ) a coordenadas cartesianas (x, y)
# ENTRADA: las cordenadas polares
# SALIDA: las cordenadas cartesianas
# PROCESOS: 1. Pedir al usuario las cordenadas polares
#           2. Mediante un procedimiento, utilizar una libreria que tenga seno y coseno para transformar las cordenadas
#           3. Mostrar las cordenadas cartesianas
# Autor: Esteban Campoverde
*/

#include <iostream>
#include <cmath>

void coordenadaCartesiana(float r, float theta);

int main()
{
    float r, theta;
    std::cout << "Ingrese las coordenada polar r: \n";
    std::cin >> r;
    std::cout << "Ingrese la coordenada polar theta: \n";
    std::cin >> theta;
    coordenadaCartesiana(r, theta);
}

void coordenadaCartesiana(float r, float theta)
{
    int x, y;
    x = r * cos(theta);
    y = r * sin(theta);

    std::cout << "Las coordenada cartesiana de r es: \n" 
    << "x: " << x << "\n";
    std::cout << "Las coordenada cartesiana de theta es: \n" 
    << "y: " << y << "\n";
}