#include <iostream>
#include <cmath>

void polarToCartesian(float r, float theta);

int main()
{
    float r, theta;
    std::cout << "Enter the polar coordinate r: \n";
    std::cin >> r;
    std::cout << "Enter the polar coordinate theta: \n";
    std::cin >> theta;
    polarToCartesian(r, theta);
}

void polarToCartesian(float r, float theta)
{
    float x, y;
    x = r * cos(theta);
    y = r * sin(theta);

    std::cout << "The Cartesian coordinates for r are: \n"
              << "x: " << x << "\n";
    std::cout << "The Cartesian coordinates for theta are: \n"
              << "y: " << y << "\n";
}
