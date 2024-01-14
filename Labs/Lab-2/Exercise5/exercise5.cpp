#include <iostream>

int main() {
    // The variable i is used to multiply the remainder by 10 so that the remainder is stored in the correct position
    int num, remainder = 0, binaryNum = 0, i = 1;
    std::cout << "Enter a decimal number: \n";
    std::cin >> num;

    while (num != 0) {
        remainder = num % 2;
        binaryNum = binaryNum + (remainder * i);
        i = i * 10;
        num = num / 2;
    }
    std::cout << "The binary number is: " << binaryNum << "\n";
}
