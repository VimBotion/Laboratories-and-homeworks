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

    Vector sumarVectores(const Vector& otroVector) {
        double sumaX = componenteX + otroVector.componenteX;
        double sumaY = componenteY + otroVector.componenteY;
        return Vector(sumaX, sumaY);
    }
};

Vector pedirComponentes(char vectorName){
    double x, y;
    std::cout << "Ingrese la componente X del vector " << vectorName << ":\n";
    std::cin >> x;
    std::cout << "Ingrese la componente Y del vector " << vectorName << ":\n";
    std::cin >> y;
    
    return Vector(x,y);
}

int main() {
    Vector vectorA = pedirComponentes('A');
    Vector vectorB = pedirComponentes('B');

    std::cout << "Modulo del vectorA: " << vectorA.modulo << std::endl;
    std::cout << "Modulo del vectorB: " << vectorB.modulo << std::endl;

    Vector vectorResultante = vectorA.sumarVectores(vectorB);
    std::cout << "El modulo de la suma de vectorA y vectorB: " << vectorResultante.modulo << std::endl;

    return 0;
}
