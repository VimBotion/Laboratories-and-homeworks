#include <iostream>

void enterNumbers(int **matrix, int size);
void rotateMatrixNinety(int **matrix, int size);
void drawArray(int **matrix, int size);

int main(){
    int size;
    std::cout << "Enter the size of the matrix: ";
    std::cin >> size;

    int **matrix = new int*[size];
    for (int i = 0; i < size; i++){
        matrix[i] = new int[size];
    }

    enterNumbers(matrix, size);
    std::cout << '\n';
    drawArray(matrix, size);
    std::cout << "The matrix rotated ninety degrees:\n";
    rotateMatrixNinety(matrix, size);

    for(int i = 0; i < size; i++){
        delete[] matrix[i];
    }
    
    delete[] matrix;
}

void enterNumbers(int **matrix, int size){
    for (int i = 0; i < size; i++){
        for (int j = 0; j < size; j++){
            std::cout << "Enter a number in row " << i + 1 << " and column " << j + 1 << '\n';
            std::cin >> matrix[i][j];
        }
    }
}

void drawArray(int **matrix, int size){
    for(int i = 0; i < size; i++){
        for (int j = 0; j < size; j++){
            std::cout << matrix[i][j] << '\t';
        }
        std::cout << '\n';
    }
}

void rotateMatrixNinety(int **matrix, int size){
    int **rotatedMatrix = new int*[size];
    for (int i = 0; i < size; i++){
        rotatedMatrix[i] = new int[size];
    }

    for (int i = 0; i < size; i++){
        for (int j = 0; j < size; j++){
            rotatedMatrix[j][size - 1 - i] = matrix[i][j];
        }
    }

    drawArray(rotatedMatrix, size);

    for(int i = 0; i < size; i++){
        delete[] rotatedMatrix[i];
    }
    delete[] rotatedMatrix;
}
