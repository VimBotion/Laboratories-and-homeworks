#include <iostream>

void decimalToRoman(int num);

int main() {
    int num;
    do {
        std::cout << "Enter a number between 0 and 3000: \n";
        std::cin >> num;
    } while (num < 0 || num > 3000);

    decimalToRoman(num);
}

void decimalToRoman(int num) {
    int u, d, c, m;

    u = num % 10;
    num /= 10;
    d = num % 10;
    num /= 10;
    c = num % 10;
    num /= 10;
    m = num % 10;
    num /= 10;

    switch (m) {
        case 1:
            std::cout << "M";
            break;
        case 2:
            std::cout << "MM";
            break;
        case 3:
            std::cout << "MMM";
            break;
    }

    switch (c) {
        case 1:
            std::cout << "C";
            break;
        case 2:
            std::cout << "CC";
            break;
        case 3:
            std::cout << "CCC";
            break;
        case 4:
            std::cout << "CD";
            break;
        case 5:
            std::cout << "D";
            break;
        case 6:
            std::cout << "DC";
            break;
        case 7:
            std::cout << "DCC";
            break;
        case 8:
            std::cout << "DCCC";
            break;
        case 9:
            std::cout << "CM";
            break;
    }

    switch (d) {
        case 1:
            std::cout << "X";
            break;
        case 2:
            std::cout << "XX";
            break;
        case 3:
            std::cout << "XXX";
            break;
        case 4:
            std::cout << "XL";
            break;
        case 5:
            std::cout << "L";
            break;
        case 6:
            std::cout << "LX";
            break;
        case 7:
            std::cout << "LXX";
            break;
        case 8:
            std::cout << "LXXX";
            break;
        case 9:
            std::cout << "XC";
            break;
    }

    switch (u) {
        case 1:
            std::cout << "I";
            break;
        case 2:
            std::cout << "II";
            break;
        case 3:
            std::cout << "III";
            break;
        case 4:
            std::cout << "IV";
            break;
        case 5:
            std::cout << "V";
            break;
        case 6:
            std::cout << "VI";
            break;
        case 7:
            std::cout << "VII";
            break;
        case 8:
            std::cout << "VIII";
            break;
        case 9:
            std::cout << "IX";
            break;
    }
}
