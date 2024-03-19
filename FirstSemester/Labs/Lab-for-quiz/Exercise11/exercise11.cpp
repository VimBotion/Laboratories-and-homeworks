#include <iostream>

void division(int dividend, int divisor);

int main()
{
    int dividend, divisor;
    std::cout << "Enter the dividend: \n";
    std::cin >> dividend;
    std::cout << "Enter the divisor: \n";
    std::cin >> divisor;

    division(dividend, divisor);
}

void division(int dividend, int divisor)
{
    int quotient = 0;
    while(dividend >= divisor)
    {
        dividend -= divisor;
        quotient++;
    }

    std::cout << "The quotient is: " << quotient << "\n";
    std::cout << "The remainder is: " << dividend << "\n";
}
