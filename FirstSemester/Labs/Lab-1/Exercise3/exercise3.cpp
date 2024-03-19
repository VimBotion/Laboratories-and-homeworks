#include <iostream>

using namespace std;

int main() {
    int num;
    bool isPrime = true;

    do {
        cout << "Enter a number between 1-5: " << endl;
        cin >> num;
    } while (num < 1 || num > 5);

    if (num == 1) {
        isPrime = false;
    } else {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
    }

    if (isPrime) {
        cout << "The number is prime." << endl;
    } else {
        cout << "The number is not prime." << endl;
    }

    return 0;
}
