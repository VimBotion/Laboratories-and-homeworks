#include <iostream>

void enterNumbers(int **matrix, int rows, int columns);
void literalA(int **matrix, int rows, int columns);
void literalB(int **matrix, int rows, int columns);
void literalC(int **matrix, int rows, int columns);

int main(){
    int rows, columns;

    std::cout << "Enter the number of rows: \n";
    std::cin >> rows;
    std::cout << "Enter the number of columns: \n";
    std::cin >> columns;

    // Create the two-dimensional array
    int **matrix = new int *[rows];
    for (int i = 0; i < rows; i++){
        matrix[i] = new int [columns];
    }   

    enterNumbers(matrix, rows, columns);
    std::cout << "Literal A:  \n";
    literalA(matrix, rows, columns);
    std::cout << "Literal B:  \n";
    literalB(matrix, rows, columns);
    std::cout << "Literal C: \n";
    literalC(matrix, rows, columns);

    // Free the memory to prevent memory leaks
    for (int i = 0; i < rows; i++){
        delete[] matrix[i];
    } 

    delete[] matrix;
}

void enterNumbers(int **matrix, int rows, int columns){
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < columns; j++){
            std::cout << "Enter a number in row # " << i + 1 << " and in column # " << j + 1 << '\n';
            std::cin >> matrix[i][j];
        }
    }
}

void literalA(int **matrix, int rows, int columns){
    for (int i = 0; i < rows; i++){
        for (int j = columns - 1; j >= 0; j--){
            std::cout << matrix[i][j] << '\t';
        }
        std::cout << '\n';
    }
}

void literalB(int **matrix, int rows, int columns){
    for (int i = rows - 1; i >= 0; i--){
        for (int j = 0; j < columns; j++){
            std::cout << matrix[i][j] << '\t';
        }
        std::cout << '\n';
    }
}

void literalC(int **matrix, int rows, int columns){
    int **matrixLiteralC = new int *[columns];
    for (int i = 0; i < columns; i++){
        matrixLiteralC[i] = new int [rows];
    }

    for (int i = 0; i < rows; i++){
        for (int j = 0; j < columns; j++){
            matrixLiteralC[j][columns - i - 1] = matrix[i][j];
        }
    }

    for (int i = 0; i < rows; i++){
        for (int j = 0; j < columns; j++){
            std::cout << matrixLiteralC[i][j] << '\t';
        }
        std::cout << '\n';
    }

    for (int i = 0; i < columns; i++){
        delete[] matrixLiteralC[i];
    } 

    delete[] matrixLiteralC;
}