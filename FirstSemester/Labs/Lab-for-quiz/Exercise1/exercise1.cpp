#include <iostream>
#include <iomanip>

float sum(float num1, float num2, float num3);
float division(float num1, float num2, float num3);

int main()
{
    float num1 = 0, num2 = 0, num3 = 0, result = 0;
    std::cout << "Enter the first number: \n";
    std::cin >> num1;
    std::cout << "Enter the second number: \n";
    std::cin >> num2;
    std::cout << "Enter the third number: \n";
    std::cin >> num3;

    result = division(num1, num2, num3);
    std::cout << "The mean is: " << std::setprecision(4) << result << "\n";
}

float sum(float num1, float num2, float num3)
{
    return num1 + num2 + num3;
}

float division(float num1, float num2, float num3)
{
    float result = sum(num1, num2, num3);
    return result / 3;
}
