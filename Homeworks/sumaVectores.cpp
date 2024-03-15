#include <iostream>
#include <cmath>

class Vector {
public:
    double componenteX;
    double componenteY;
    double modulo;

    Vector(double x, double y){
        componenteX = x; 
        componenteY = y;
        calcularModulo();
    }

    void calcularModulo() {
        modulo = std::sqrt(componenteX * componenteX + componenteY * componenteY);
    }
};

int main() {
    Vector vectorA(3, 4);
    Vector vectorB(20, 30);

    std::cout << "Modulo of vectorA: " << vectorA.modulo << std::endl;
    std::cout << "Modulo of vectorB: " << vectorB.modulo << std::endl;

    return 0;
}
