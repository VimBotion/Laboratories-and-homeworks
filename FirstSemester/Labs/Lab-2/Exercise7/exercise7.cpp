#include <iostream>
#include <string>

int main() {
    std::string idNumber;
    int evenDigit, oddDigit, sumDigits = 0;

    std::cout << "Enter your ID number: \n";
    std::cin >> idNumber;

    if (idNumber.length() != 10) {
        std::cout << "Error. The ID number must have 10 digits\n";
    }

    // Subtracting one because the index starts at 0
    for (int i = (idNumber.length() - 1); i >= 0; i--) {
        if (i % 2 == 0) {
            // Subtracting the character '0' to convert the number (char) to int according to the ASCII table
            evenDigit = (idNumber[i] - '0') * 2;

            if (evenDigit > 9) {
                evenDigit -= 9;
            }
            sumDigits += evenDigit;
        } else {
            oddDigit = (idNumber[i] - '0');
            sumDigits += oddDigit;
        }
    }

    if (sumDigits % 10 == 0) {
        std::cout << "The ID number is valid according to the Luhn formula\n";
    } else {
        std::cout << "The ID number is invalid according to the Luhn formula\n";
    }
}
