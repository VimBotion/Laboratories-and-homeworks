// Ejercicio 36 de la pagina 170
#include <iostream>

void ingresarNumeros(int **matriz, int filas, int columnas);
void literalA(int **matriz, int filas, int columnas);
void literalB(int **matriz, int filas, int columnas);
void literalC(int **matriz, int filas, int columnas);

int main(){
    int filas, columnas;

    std::cout << "Ingrese el numero de filas: \n";
    std::cin >> filas;
    std::cout << "Ingrese el numero de columnas: \n";
    std::cin >> columnas;

    // Crear el array de dos dimensiones
    int **matriz = new int *[filas];
    for (int i = 0; i < filas; i++){
        matriz[i] = new int [columnas];
    }   

    ingresarNumeros(matriz, filas, columnas);
    std::cout << "Literal A:  \n";
    literalA(matriz, filas, columnas);
    std::cout << "Literal B:  \n";
    literalB(matriz, filas, columnas);
    std::cout << "Literal C: \n";
    literalC(matriz, filas, columnas);

    // Borrar la memoria utilizada para prevenir memory leaks
    for (int i = 0; i < filas; i++){
        delete[] matriz[i];
    } 

    delete[] matriz;
}

void ingresarNumeros(int **matriz, int filas, int columnas){
    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            std::cout << "Ingrese un numero en la fila # " << i + 1 << " y en la columna # " << j + 1 << '\n';
            std::cin >> matriz[i][j];
        }
    }
}

void literalA(int **matriz, int filas, int columnas){
    for (int i = 0; i < filas; i++){
        for (int j = columnas - 1; j >= 0; j--){
            std::cout << matriz[i][j] << '\t';
        }
        std::cout << '\n';
    }
}

void literalB(int **matriz, int filas, int columnas){
    for (int i = filas - 1; i >= 0; i--){
        for (int j = 0; j < columnas; j++){
            std::cout << matriz[i][j] << '\t';
        }
        std::cout << '\n';
    }

}

void literalC(int **matriz, int filas, int columnas){
    int **matrizLiteralC = new int *[filas];
    for (int i = 0; i < filas; i++){
        matrizLiteralC[i] = new int [columnas];
    }

    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            matrizLiteralC[i][j] = matriz[i][j];
        }
    }

    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            std::cout << matrizLiteralC[i][j] << '\t';
        }
        std::cout << '\n';
    }

    for (int i = 0; i < filas; i++){
        delete[] matrizLiteralC[i];
    } 

    delete[] matrizLiteralC;
}
