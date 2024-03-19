#include <iostream>

double factorial(double num);

int main()
{
    int num = 0;
    double result = 0;
    do 
    {
        std::cout << "Enter the number: \n";
        std::cin >> num;
    } while (num < 1 || num > 100);
    result = factorial(num);
    std::cout << "The factorial is: " << result << "\n";
}

double factorial(double num)
{
    if (num == 1)
    {
        return 1;
    }

    return num * factorial(num - 1);
}
