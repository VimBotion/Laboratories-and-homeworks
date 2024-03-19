#include <iostream>
#include <cmath>

int main() {
    // The variable i is the exponent by which the remainder should be multiplied
    int num, remainder = 0, decimalNum = 0, i = 0;
    std::cout << "Enter a binary number: \n";
    std::cin >> num;

    while (num != 0) {
        remainder = num % 10;
        decimalNum = decimalNum + (remainder * pow(2, i));
        i++;
        num = num / 10;
    }

    std::cout << "The decimal number is: " << decimalNum << "\n";
}
