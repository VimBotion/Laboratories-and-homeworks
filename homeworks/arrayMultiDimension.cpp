#include <iostream>

const int SIZE = 10;

void dibujarTabla(int array[][SIZE]);
void multiplicarFilaColumna(int array[][SIZE]);

int main(){
    int array[SIZE][SIZE] = {{0}};
    multiplicarFilaColumna(array);
    dibujarTabla(array);

    return 0;
}

void dibujarTabla(int array[][SIZE]){
    std::cout << " | ";
    for (int i = 1; i <= SIZE; i++){
        std::cout << i << "|";
    }
    std::cout << '\n';

    for (int i = 0; i < SIZE; i++){
        std::cout << i + 1 << "| ";
        for (int j = 0; j < SIZE; j++){
            std::cout << array[i][j] << " ";
        }
        std::cout << '\n';
    }
}

void multiplicarFilaColumna(int array[][SIZE]){
    for (int i = 0; i < SIZE; i++){
        for (int j = 0; j < SIZE; j++){
            array[i][j] = (i + 1) * (j + 1);
        }
    }
}


