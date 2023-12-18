// Ejercicio 31 de la pagina 170
#include <iostream>
#include <string>
#include <iomanip>

const int NUM_ALUMNOS = 50;
const int NUM_MATERIAS = 6;

void sort(std::string *nombres, int cantidadAlumnos, double notas[][NUM_MATERIAS]);
void ingresarAlumnos(std::string *nombres, int cantidadAlumnos);
void ingresarNotas(double notas[][NUM_MATERIAS], std::string *nombres, int cantidadAlumnos);
void mostrarTabla(double notas[][NUM_MATERIAS], std::string *nombres, int cantidadAlumnos);

int main(){
    std::string nombres[NUM_ALUMNOS];

    int cantidadAlumnos;
    do{
        std::cout << "Ingrese la cantidad de alumnos, como maximo " << NUM_ALUMNOS << '\n';
        std::cin >> cantidadAlumnos;
    } while (cantidadAlumnos <= 0 || cantidadAlumnos > NUM_ALUMNOS);

    std::cin.ignore();
    
    ingresarAlumnos(nombres, cantidadAlumnos);

    double notas[cantidadAlumnos][NUM_MATERIAS];

    ingresarNotas(notas, nombres, cantidadAlumnos);

    sort(nombres, cantidadAlumnos, notas);
    
    mostrarTabla(notas, nombres, cantidadAlumnos);
}

void ingresarAlumnos(std::string *nombres, int cantidadAlumnos){
    std::cout << "Ingrese los nombres de los alumnos: \n";
    for (int i = 0; i < cantidadAlumnos; i++){
        std::cout << "Alumno:\n";
        getline(std::cin, nombres[i]);
    }
}

void ingresarNotas(double notas[][NUM_MATERIAS], std::string *nombres, int cantidadAlumnos){
    for (int i = 0; i < cantidadAlumnos; i++){
        std::cout << "Ingrese las notas para el alumno " << nombres[i] << '\n';
        for (int j = 0; j < NUM_MATERIAS; j++){
            std::cout << "Nota para la materia " << j + 1 << '\n';
            std::cin >> notas[i][j];
        }
    }
}

void mostrarTabla(double notas[][NUM_MATERIAS], std::string *nombres, int cantidadAlumnos) {
    std::cout << "\nTabla de alumnos:\n";
    std::cout << std::left << std::setw(20) << "Nombre";
    for (int j = 0; j < NUM_MATERIAS; ++j) {
        std::cout << std::setw(15) << "Materia ";
    }
    std::cout << std::setw(10) << "MEDIA" << '\n';

    for (int i = 0; i < cantidadAlumnos; ++i) {
        double sumaNotas = 0;
        std::cout << std::left << std::setw(20) << nombres[i];
        for (int j = 0; j < NUM_MATERIAS; ++j) {
            std::cout << std::fixed << std::setprecision(2) << std::setw(15) << notas[i][j];
            sumaNotas += notas[i][j];
        }
        double media = sumaNotas / NUM_MATERIAS;
        std::cout << std::fixed << std::setprecision(2) << std::setw(10) << media << '\n';

    }
}

void sort(std::string *nombres, int cantidadAlumnos, double notas[][NUM_MATERIAS]){
    for (int i = 0; i < cantidadAlumnos - 1; i++) {
        for (int j = 0; j < cantidadAlumnos - i - 1; j++) {
            if (nombres[j] > nombres[j + 1]) {
                std::swap(nombres[j], nombres[j + 1]);

                for (int k = 0; k < NUM_MATERIAS; k++) {
                    std::swap(notas[j][k], notas[j + 1][k]);
                }
            }
        }
    }
}