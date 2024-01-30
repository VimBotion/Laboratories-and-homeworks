// Exercise 1. 2024
#include <iostream>

void readData(int arrayA[], int arrayB[], int& size);
void swapArrays(int arrayA[], int arrayB[], int size);
void multiplyArrays(int arrayA[], int arrayB[], int size);
void displayArrays(int arrayA[], int arrayB[], int size);

int main() {
    int choice;
    int size = 0;
    int* arrayA = nullptr;
    int* arrayB = nullptr;

    do {
        std::cout << "\tMenu\n";
        std::cout << "1. Read Data\n";
        std::cout << "2. Swap Elements\n";
        std::cout << "3. Calculate Multiplication\n";
        std::cout << "4. Exit\n";
        std::cin >> choice;

        switch (choice) {
            case 1:
                readData(arrayA, arrayB, size);
                displayArrays(arrayA, arrayB, size);
                break;
            case 2:
                swapArrays(arrayA, arrayB, size);
                displayArrays(arrayA, arrayB, size);
                break;
            case 3:
                multiplyArrays(arrayA, arrayB, size);
                displayArrays(arrayA, arrayB, size);
                break;
            case 4:
                delete[] arrayA;
                delete[] arrayB;
                break;
            default:
                std::cout << "Enter a valid option!\n";
                break;
        }
    } while (choice != 4);

    return 0;
}

void readData(int arrayA[], int arrayB[], int& size) {
    std::cout << "Enter the size of the arrays:\n";
    std::cin >> size;
    arrayA = new int[size];
    arrayB = new int[size];

    std::cout << "Data for Array A:\n";
    for (int i = 0; i < size; i++) {
        std::cin >> arrayA[i];
    }

    std::cout << "Data for Array B:\n";
    for (int i = 0; i < size; i++) {
        std::cin >> arrayB[i];
    }
}

void swapArrays(int arrayA[], int arrayB[], int size) {
    int j = size - 1;
    for (int i = 0; i < size; i++) {
        int tmp = arrayA[i];
        arrayA[i] = arrayB[j];
        arrayB[j] = tmp;
        j--;
    }
}

void multiplyArrays(int arrayA[], int arrayB[], int size) {
    int j = size - 1;
    int arrayC[size];
    for (int i = 0; i < size; i++) {
        arrayC[i] = arrayA[i] * arrayB[j];
        j--;
    }

    std::cout << "Array C:\n";
    for (int i = 0; i < size; i++) {
        std::cout << "\t" << arrayC[i];
    }
    std::cout << "\n";
}

void displayArrays(int arrayA[], int arrayB[], int size) {
    std::cout << "Array A:\n";
    for (int i = 0; i < size; i++) {
        std::cout << "\t" << arrayA[i];
    }
    std::cout << "\n";

    std::cout << "Array B:\n";
    for (int i = 0; i < size; i++) {
        std::cout << "\t" << arrayB[i];
    }
    std::cout << "\n";
}
