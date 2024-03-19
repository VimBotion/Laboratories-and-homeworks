#include <iostream>

int main() {
    int choice;
    std::cout << "Choose a beverage: \n";
    std::cout << "1. Coca-Cola\n";
    std::cout << "2. Water\n";
    std::cout << "3. Sprite\n";
    std::cout << "4. Juice\n";
    std::cout << "5. Milk\n";
    std::cin >> choice;

    switch (choice) {
        case 1:
            std::cout << "You chose: Coca-Cola\n";
            break;
        case 2:
            std::cout << "You chose: Water\n";
            break;
        case 3:
            std::cout << "You chose: Sprite\n";
            break;
        case 4:
            std::cout << "You chose: Juice\n";
            break;
        case 5:
            std::cout << "You chose: Milk\n";
            break;
        default:
            std::cout << "Error. The choice was not valid!\n";
            break;
    }

    return 0;
}
