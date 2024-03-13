#include <iostream>

bool isDigit(char character);

int main()
{
    char digit;
    std::cout << "Enter a character: \n";
    std::cin >> digit;
    
    if (isDigit(digit))
    {
        std::cout << "The character is a digit between 0 and 9\n";
    }
    else
    {
        std::cout << "It is not a digit between 0 and 9\n";
    }
}

bool isDigit(char character)
{
    return (character >= '0' && character <= '9');    
}
