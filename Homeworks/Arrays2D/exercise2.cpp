#include <iostream>
#include <cstdlib>

void enterNumbers(int** matrix, int rows, int cols);
void displayMatrix(int **matrix, int rows, int cols);
void flipRows(int **matrix, int rows, int cols);
void flipColumns(int **matrix, int rows, int cols);

int main(){
    int rows, cols;

    std::cout << "Enter the number of rows in the matrix: ";
    std::cin >> rows;
    std::cout << "Enter the number of columns in the matrix: ";
    std::cin >> cols;

    int **matrix = new int*[rows];
    for (int i = 0; i < rows; i++){
        matrix[i] = new int[cols];
    }

    enterNumbers(matrix, rows, cols);
    system("CLS");
    std::cout << "The matrix with flipped rows is: \n";
    flipRows(matrix, rows, cols);

    std::cout << "The matrix with flipped columns is: \n";
    flipColumns(matrix, rows, cols);

    for (int i = 0; i < rows; i++){
        delete[] matrix[i];
    }

    delete[] matrix;
}

void enterNumbers(int** matrix, int rows, int cols){
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
            std::cout << "Enter a number in row # " << i + 1 << " and column # " << j + 1 << ": \n";
            std::cin >> matrix[i][j];
        }
    }
}

void displayMatrix(int **matrix, int rows, int cols){
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
            std::cout << matrix[i][j] << '\t';
        }
        std::cout << '\n';
    }
}

void flipRows(int **matrix, int rows, int cols){
    for (int i = rows - 1; i >= 0; i--){
        for (int j = 0; j < cols; j++){
            std::cout << matrix[i][j] << '\t';
        }
        std::cout << '\n';
    }
}

void flipColumns(int **matrix, int rows, int cols){
    for (int i = 0; i < rows; i++){
        for (int j = cols - 1; j >= 0; j--){
            std::cout << matrix[i][j] << '\t';
        }
        std::cout << '\n';
    }
}