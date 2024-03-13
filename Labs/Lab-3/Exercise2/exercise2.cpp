#include <iostream>

int factorial(int num);
int main()
{
    int num;
    std::cout << "Ingrese un numero:\n";
    std::cin >> num;
    int resultado = factorial(num);

    std::cout << "El factorial es: " << num << "\n";
}

int factorial(int num)
{
    if (num == 0)
    {
        num = 1;
        return num;
    }

    return num * factorial(num -1);
}