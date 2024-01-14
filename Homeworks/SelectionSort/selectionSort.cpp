#include <iostream>

int main(){
    int A[7] = {16, 30, 35, 42, 7, 8, 9};
    int N = sizeof(A) / sizeof(A[0]);

    for (int i = 0; i < N - 1; i++) {
        int smallest = i;
        for (int j = i + 1; j < N; j++) {
            if (A[j] < A[smallest]) {
                smallest = j;
            }
        }
        if (i != smallest) {
            // Swap A[i] and A[smallest]
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;
        }
    }

    std::cout << "Sorted Array: ";
    for (int i = 0; i < N; i++) {
        std::cout << A[i] << " ";
    }

    return 0;
}
