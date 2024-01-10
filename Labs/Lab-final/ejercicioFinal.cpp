#include <iostream>
#include <string>

// AUTOR: Esteban Campoverde
void esPalindromo(std::string palabra){
    for (int i = 0; i < palabra.length() / 2; i++){
        if (palabra[i] != palabra[palabra.length() - 1 - i]) {
            std::cout << "NO ES PALINDROMO\n";
            return;
        }
    }
    std::cout << "LA PALABRA ES PALINDROMO!\n";
}

int main(){
    std::string palabra;
    do {
        std::cout << "Ingrese la palabra:\n";
        std::cin >> palabra;
    } while (palabra.length() > 20);
    
    esPalindromo(palabra);
}