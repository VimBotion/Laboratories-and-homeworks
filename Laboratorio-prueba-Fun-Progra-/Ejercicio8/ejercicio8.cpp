/*
# Laboratorio Ejercicio 6.8
# Este programa utiliza una función Salario que calcule los salarios
# de un trabajador para un número dado de horas trabajadas y un salario hora.
# Las horas que su peren las 40 horas semanales se pagarán como extras con un sala-
# rio hora 1,5 veces el salario ordinario.
# ENTRADA: las horas trabajadas, el salario por hora
# SALIDA: el salario del trabajador
# PROCESOS: 1. Pedir al usuario las horas trabajadas y el salario por hora
#           2. Mediante una funcion calcular el salario final del trabajador
#           3. Si las horas trabajadas son mas de 40, conseguir el salario extra 
#           4. Sumar el salario base mas el salario de las horas extras trabajadas
#           5. Mostrar el salario final
# Autor: Esteban Campoverde
*/

#include <iostream>

float CalcularSalarioExtra(int horasExtras, int salarioHora);
float salario(int horas, int salarioHora);

int main()
{
    int horasTrabajadas, salarioHora;
    std::cout << "Ingrese las horas trabajadas: \n";
    std::cin >> horasTrabajadas;
    std::cout << "Ingrese el salario por hora: \n";
    std::cin >> salarioHora;

    std::cout << "El salario final es de: " << salario(horasTrabajadas, salarioHora) << "\n";
}

float CalcularSalarioExtra(int horasExtras, int salarioHora)
{
    float salarioHoraExtra = salarioHora * 1.5; 
    return horasExtras * salarioHoraExtra;
}

float salario(int horas, int salarioHora)
{
    int salarioExtra, salarioFinal;
    salarioFinal = 40 * salarioHora;
    if(horas > 40)
    {
        int horasExtras = horas - 40;
        salarioExtra = CalcularSalarioExtra(horasExtras, salarioHora);
        salarioFinal += salarioExtra;
    }
    return salarioFinal;
}