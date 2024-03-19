#include <iostream>

int greatestCommonDivisor(int num1, int num2);

int main()
{
    int num1 = 0, num2 = 0, result = 0;
    std::cout << "Enter the first number: \n";
    std::cin >> num1;
    std::cout << "Enter the second number: \n";
    std::cin >> num2;

    result = greatestCommonDivisor(num1, num2);

    std::cout << "The greatest common divisor is: " << result << "\n";
}

int greatestCommonDivisor(int num1, int num2)
{
    int remainder = num1 % num2;
    while (remainder != 0)
    {
        num1 = num2;
        num2 = remainder;
        remainder = num1 % num2;
    }

    return num2;
}
