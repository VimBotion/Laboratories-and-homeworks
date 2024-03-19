#include <iostream>

int main() {
    int num;
    std::cout << "Enter a number: \n";
    std::cin >> num;

    for (int i = 1; i <= 10; i++) {
        int result = num * i;
        std::cout << num << " * " << i << " = " << result << "\n";
    }
}
