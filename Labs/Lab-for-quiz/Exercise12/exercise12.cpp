#include <iostream>
#include <string>

std::string ValidDate(int day, int month, int year);

int main() {
    int day, month, year;

    std::cout << "Enter the day: ";
    std::cin >> day;
    std::cout << "Enter the month: ";
    std::cin >> month;
    std::cout << "Enter the year: ";
    std::cin >> year;

    std::string isValid = ValidDate(day, month, year);
    std::cout << isValid << "\n";
}

std::string ValidDate(int day, int month, int year) {
    if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1) {
        return "The date is not valid.";
    }

    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            if (day > 31) {
                return "The date is not valid.";
            }
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            if (day > 30) {
                return "The date is not valid.";
            }
            break;
        case 2:
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                if (day > 29) {
                    return "The date is not valid.";
                }
            } else {
                if (day > 28) {
                    return "The date is not valid.";
                }
            }
            break;
    }

    return "The date is valid.";
}
