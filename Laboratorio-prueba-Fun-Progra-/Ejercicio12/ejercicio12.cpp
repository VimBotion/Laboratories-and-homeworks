/*
# Laboratorio Ejercicio 6.12
# Este programa utiliza una función que permita deducir si una fecha leída del teclado es válida.
# PROCESOS: 1. Pedir al usuario el dia, el mes y el anio
#           2. Mediante una funcion revisar si el dia se encuentra entre 1 y 31, el mes entre 1 y 12 y si el anio es mayor a 1
#           3. Comprobar para los meses 1,3,5,7,8,10,12 los dias no sean mayores a 31
#           4. Comprobar para los meses 4,6,9,11 los dias no sean mayores a 30
#           5. Comprobar para febrero si el anio es bisiesto
#           6. Mostrar el resultado
# Autor: Esteban Campoverde
*/

#include <iostream>

std::string FechaValida(int dia, int mes, int anio);


int main() {
  int dia, mes, anio;

  std::cout << "Introduce el día: ";
  std::cin >> dia;
  std::cout << "Introduce el mes: ";
  std::cin >> mes;
  std::cout << "Introduce el año: ";
  std::cin >> anio;

  std::string esValida = FechaValida(dia, mes, anio);
  std::cout << esValida << "\n";
}


std::string FechaValida(int dia, int mes, int anio) {
  if (dia < 1 || dia > 31) 
  {
    return "La fecha no es válida.";
  }
  if (mes < 1 || mes > 12) 
  {
    return "La fecha no es válida.";
  }

  if (anio < 1) 
  {
    return "La fecha no es válida.";
  }
  switch (mes) 
  {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
      if (dia > 31) {
        return "La fecha no es válida.";
      }
      break;
    case 4:
    case 6:
    case 9:
    case 11:
      if (dia > 30) {
        return "La fecha no es válida.";
      }
      break;
    case 2:
      if (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0) {
        if (dia > 29) {
          return "La fecha no es válida.";
        }
      } else {
        if (dia > 28) {
          return "La fecha no es válida.";
        }
      }
      break;
  }
  return "La fecha es válida.";
}