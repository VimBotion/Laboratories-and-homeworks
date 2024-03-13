#include <iostream>
#include <cmath>

using namespace std;

int main() {
    // For the square root of 16.0
    float expression1 = sqrt(16.0);
    cout << "The result of the square root of 16.0 is: " << expression1 << endl;

    // For the square root of 16
    int expression2 = sqrt(16);
    cout << "The result of the square root of 16 is: " << expression2 << endl;

    // For the expression (7 + square root of 4) / 3.0
    float expression3 = (7 + sqrt(4)) / 3.0;
    cout << "The result of (7 + square root of 4) / 3.0: " << expression3 << endl;

    // For 2 ^ 3
    int expression4 = pow(2, 3);
    cout << "The result of 2 ^ 3 is: " << expression4 << endl;

    // For the absolute value of -45
    int expression5 = abs(-45);
    cout << "The result of the absolute value of -45 is: " << expression5 << endl;

    return 0;
}
