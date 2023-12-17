// ejercicio 34 de la pagina 170
#include <iostream>

void ingresarNumeros(int** matriz, int filas, int columnas);
void mostrarMatriz(int **matriz, int filas, int columnas);

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
    mostrarMatriz(matriz, rows, cols);

    for (int i = 0; i < rows; i++){
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
