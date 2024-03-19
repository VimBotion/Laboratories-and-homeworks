#include <iostream>

int absoluteValue(int num);

int main()
{
    int num = 0;
    std::cout << "Enter a number: \n";
    std::cin >> num;

    int absoluteNumber = absoluteValue(num);
    std::cout << "The absolute value of the number is: " << absoluteValue(num) << "\n";
}

int absoluteValue(int num)
{
    if (num < 0)
    {
        return num * (-1);
    }
    else
    {
        return num;
    }
}
