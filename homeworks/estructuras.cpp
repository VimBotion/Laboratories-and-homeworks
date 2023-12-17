#include <iostream>

void MPP(std::string premisa1, std::string premisa2);
void MTP(std::string premisa1, std::string premisa2);
void MTT(std::string premisa1, std::string premisa2);

int main() {

    std::string premisa1, premisa2;

    std::cout << "Ingrese la primera premisa: ";
    getline(std::cin, premisa1);
    std::cout << "Ingrese la segunda premisa: ";
    getline(std::cin, premisa2);

    MTP(premisa1, premisa2);
    MPP(premisa1, premisa2);
    MTT(premisa1, premisa2);

    return 0;
}

void MTP(std::string premisa1, std::string premisa2)
{
    if (premisa1.find("v") != std::string::npos)
    {
        if (premisa1.substr(0, 1) == "-" && premisa2.substr(0, 1) != "-" && premisa2.substr(0, 1) == premisa1.substr(1, 1))
        {
            std::cout << premisa1.substr(5, 2) << "\n";
        }
        else if (premisa1.substr(4, 1) == "-" && premisa2.substr(0, 1) != "-" && premisa2.substr(0, 1) == premisa1.substr(5, 1))
        {
            std::cout << premisa1.substr(0, 1) << "\n";
        }
        else if (premisa1.substr(0, 1) == "-" && premisa1.substr(5, 1) == "-" && premisa2.substr(0, 1) != "-" && premisa2.substr(0, 1) == premisa1.substr(1, 1))
        {
            std::cout << premisa1.substr(5, 2);
        }
        else if (premisa1.substr(0, 1) == "-" && premisa1.substr(5, 1) == "-" && premisa2.substr(0, 1) != "-" && premisa2.substr(0, 1) == premisa1.substr(6, 1))
        {
            std::cout << premisa1.substr(0, 2);
        }
        else if (premisa1.substr(0, 1) != "-" && premisa2.substr(0, 1) == "-" && premisa2.substr(1, 1) == premisa1.substr(0, 1))
        {
            std::cout << premisa1.substr(4, 2);
        }
        else if (premisa1.substr(0, 1) == "-" && premisa1.substr(5, 1) != "-" && premisa2.substr(0, 1) == "-" && premisa2.substr(1, 1) == premisa1.substr(5, 1))
        {
            std::cout << premisa1.substr(0, 2);
        }
    }
}

void MPP(std::string premisa1, std::string premisa2)
{
    if (premisa1.find("->") != std::string::npos){
        if (premisa1.substr(0, 1) == "-" && premisa2.substr(0, 1) == "-" && premisa1.substr(1, 1) == premisa2.substr(1, 1))
        {
            std::cout << premisa1.substr(6, 2) << "\n";
        }
        else if (premisa1.substr(0, 1) != "-" && premisa2.substr(0, 1) != "-" && premisa1.substr(0, 1) == premisa2.substr(0, 1) ){
            std::cout << premisa1.substr(5, 2) << '\n';
        }
    }
}

void MTT(std::string premisa1, std::string premisa2){
    if (premisa1.find("->") != std::string::npos){
        if (premisa1.substr(6,1) == "-" && premisa2.substr(0, 1) != "-" && premisa1.substr(7, 1) == premisa2.substr(0, 1) && premisa1.substr(0, 1) == "-"){
            std::cout << premisa1.substr(1, 1) << "\n";
        }
        else if (premisa1.substr(5,1) == "-" && premisa2.substr(0, 1) != "-" && premisa1.substr(6, 1) == premisa2.substr(0, 1) && premisa1.substr(0, 1) != "-"){
            std::cout << "-" + premisa1.substr(0, 1) << '\n';
        }
        else if (premisa1.substr(6,1) != "-" && premisa2.substr(0, 1) == "-" && premisa1.substr(6, 1) == premisa2.substr(1, 1) && premisa1.substr(0, 1) == "-"){
            std::cout << premisa1.substr(1, 1) << '\n';
        }
        else if (premisa1.substr(5,1) != "-" && premisa2.substr(0, 1) == "-" && premisa1.substr(5, 1) == premisa2.substr(1, 1) && premisa1.substr(0, 1) != "-"){
            std::cout << "-" + premisa1.substr(0, 1) << '\n';
        }
    }
}