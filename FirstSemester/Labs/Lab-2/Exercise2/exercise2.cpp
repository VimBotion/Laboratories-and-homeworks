#include <iostream>

int main() {
    int enteredNumber = 0;
    int count = 0;

    std::cout << "Enter a positive number: \n";
    std::cin >> enteredNumber;
    int number = enteredNumber;

    if (number <= 0) {
        std::cout << "You must enter a positive number! \n";
        return 1;
    }

    while (number > 0) {
        number = number / 10;
        count++;
    }

    std::cout << "The number " << enteredNumber << " contains: " << count << " digits\n";
    return 0;
}
