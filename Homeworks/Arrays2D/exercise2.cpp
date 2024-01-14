// ejercicio 34 de la pagina 170
#include <iostream>
#include <stdlib.h>

void ingresarNumeros(int** matriz, int rows, int cols);
void mostrarMatriz(int **matriz, int rows, int cols);
void virasFilas(int **matriz, int rows, int cols);
void virarColumnas(int **matriz, int rows, int cols);

int main(){
    int rows, cols;

    std::cout << "Ingrese el numero de filas de la matriz: ";
    std::cin >> rows;
    std::cout << "Ingrese el numero de columnas de la matriz: ";
    std::cin >> cols;

    int **matriz = new int*[rows];
    for (int i = 0; i < rows; i++){
        matriz[i] = new int[cols];
    }

    ingresarNumeros(matriz, rows, cols);
    system("CLS");
    std::cout << "La matriz con las filas viradas es: \n";
    virasFilas(matriz, rows, cols);

    std::cout << "La matriz con las columnas viradas es: \n";
    virarColumnas(matriz, rows, cols);

    for (int i = 0; i < rows; i++){
        delete[] matriz[i];
    }

    delete[] matriz;
}

void ingresarNumeros(int** matriz, int rows, int cols){
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
            std::cout << "Ingrese un numero en la fila # " << i + 1 << " y en la columna # " << j + 1 << ": \n";
            std::cin >> matriz[i][j];
        }
    }
}

void mostrarMatriz(int **matriz, int rows, int cols){
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
            std::cout << matriz[i][j] << '\t';
        }
        std::cout << '\n';
    }
}

void virasFilas(int **matriz, int rows, int cols){
    for (int i = rows - 1; i >= 0; i--){
        for (int j = 0; j < cols; j++){
            std::cout << matriz[i][j] << '\t';
        }
        std::cout << '\n';
    }
}

void virarColumnas(int **matriz, int rows, int cols){
    for (int i = 0; i < rows; i++){
        for (int j = cols - 1; j >= 0; j--){
            std::cout << matriz[i][j] << '\t';
        }
        std::cout << '\n';
    }
}