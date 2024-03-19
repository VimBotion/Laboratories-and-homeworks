#include <iostream>

float power(float base, int exponent);

int main()
{
    float base;
    int exponent;
    std::cout << "Enter the base: \n";
    std::cin >> base;
    std::cout << "Enter the exponent: \n";
    std::cin >> exponent;

    float result = power(base, exponent);
    std::cout << "The result is: " << result << "\n";
}

float power(float base, int exponent)
{
    float result = 1;
    for (int i = 1; i <= exponent; i++)
    {
        result *= base;
    }
    return result;
}
