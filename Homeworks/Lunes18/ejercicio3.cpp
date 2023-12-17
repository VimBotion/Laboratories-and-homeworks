// ejercicio 34 de la pagina 170
#include <iostream>
#include <stdlib.h>

void ingresarNumeros(int** matriz, int filas, int columnas);
void mostrarMatriz(int **matriz, int filas, int columnas);
void virasFilas(int **matriz, int filas, int columnas);
void virarColumnas(int **matriz, int filas, int columnas);

int main(){
    int filas, columnas;

    std::cout << "Ingrese el numero de filas de la matriz: ";
    std::cin >> filas;
    std::cout << "Ingrese el numero de columnas de la matriz: ";
    std::cin >> columnas;

    int **matriz = new int*[filas];
    for (int i = 0; i < filas; i++){
        matriz[i] = new int[columnas];
    }

    ingresarNumeros(matriz, filas, columnas);
    system("clear");
    std::cout << "La matriz con las filas viradas es: \n";
    virasFilas(matriz, filas, columnas);

    std::cout << "La matriz con las columnas viradas es: \n";
    virarColumnas(matriz, filas, columnas);

    for (int i = 0; i < filas; i++){
        delete[] matriz[i];
    }

    delete[] matriz;
}

void ingresarNumeros(int** matriz, int filas, int columnas){
    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            std::cout << "Ingrese un numero en la fila # " << i + 1 << " y en la columna # " << j + 1 << ": \n";
            std::cin >> matriz[i][j];
        }
    }
}

void mostrarMatriz(int **matriz, int filas, int columnas){
    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            std::cout << matriz[i][j] << '\t';
        }
        std::cout << '\n';
    }
}

void virasFilas(int **matriz, int filas, int columnas){
    for (int i = filas - 1; i >= 0; i--){
        for (int j = 0; j < columnas; j++){
            std::cout << matriz[i][j] << '\t';
        }
        std::cout << '\n';
    }
}

void virarColumnas(int **matriz, int filas, int columnas){
    for (int i = 0; i < filas; i++){
        for (int j = columnas - 1; j >= 0; j--){
            std::cout << matriz[i][j] << '\t';
        }
        std::cout << '\n';
    }
}