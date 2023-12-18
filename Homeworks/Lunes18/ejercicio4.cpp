// Ejercicio 35 de la pagina 170
#include <iostream>

void ingresarNumeros(int **matriz, int tamano);
void rotarNoventa(int **matriz, int tamano);
void mostrarMatriz(int **matriz, int tamano);

int main(){
    int tamano;
    std::cout << "Ingrese el orden de la matriz: ";
    std::cin >> tamano;

    int **matriz = new int*[tamano];
    for (int i = 0; i < tamano; i++){
        matriz[i] = new int[tamano];
    }

    ingresarNumeros(matriz, tamano);
    std::cout << '\n';
    mostrarMatriz(matriz, tamano);
    std::cout << '\n';
    rotarNoventa(matriz, tamano);

    for(int i = 0; i < tamano; i++){
        delete[] matriz[i];
    }
    
    delete[] matriz;
}

void ingresarNumeros(int **matriz, int tamano){
    for (int i = 0; i < tamano; i++){
        for (int j = 0; j < tamano; j++){
            std::cout << "Ingrese un numero en la fila # " << i + 1 << " y la columna # " << j + 1 << '\n';
            std::cin >> matriz[i][j];
        }
    }
}
void mostrarMatriz(int **matriz, int tamano){
    for(int i = 0; i < tamano; i++){
        for (int j = 0; j < tamano; j++){
            std::cout << matriz[i][j] << '\t';
        }
        std::cout << '\n';
    }
}

void rotarNoventa(int **matriz, int tamano){
    // Crear una matriz temporal para almacenar la rotación
    int **matrizRotada = new int*[tamano];
    for (int i = 0; i < tamano; i++){
        matrizRotada[i] = new int[tamano];
    }

    // Rotar la matriz
    for (int i = 0; i < tamano; i++){
        for (int j = 0; j < tamano; j++){
            matrizRotada[j][tamano - 1 - i] = matriz[i][j];
        }
    }

    mostrarMatriz(matrizRotada, tamano);

    for(int i = 0; i < tamano; i++){
        delete[] matrizRotada[i];
    }
    delete[] matrizRotada;
}