#include <iostream>

int main() {
    float age1, age2, age3, age4, age5, age6;

    std::cout << "Enter the father's age: \n";
    std::cin >> age1;
    std::cout << "Enter the mother's age: \n";
    std::cin >> age2;
    std::cout << "Enter the first child's age: \n";
    std::cin >> age3;
    std::cout << "Enter the second child's age: \n";
    std::cin >> age4;
    std::cout << "Enter the third child's age: \n";
    std::cin >> age5;
    std::cout << "Enter the fourth child's age: \n";
    std::cin >> age6;

    float averageAges = (age1 + age2 + age3 + age4 + age5 + age6) / 6;
    std::cout << "The average of ages is: " << averageAges << "\n";

    return 0;
}
