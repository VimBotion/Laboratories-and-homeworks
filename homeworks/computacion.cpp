#include <iostream>

int main(){
    int A[7] = {16, 30, 35, 42, 7, 8, 9};
    int N = sizeof(A)/ sizeof(A[0]);

    for (int i = 1; i <= N - 1; i++){
        int menor = i;
        for (int j = i + 1; j < N; j++){
            if (A[j] < A[menor]){
                menor = j;
            }
        }
        if (i != menor){
            int aux = A[i];
            A[i] = A[menor];
            A[menor] = aux;
        }
    }

    for (int i = 1; i <= N - 1; i++){
        std::cout << A[i] << " ";
    }

    return 0;
}