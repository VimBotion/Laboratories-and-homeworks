/*
/   HOW IT WORKS: The user should enter the premise with spaces, use the operators -> and v, and the negation sign is -
/   EXAMPLE: 1. p -> q
/            2. p
/               q
/               The rule of inference is: Modus Ponendo Tollens
/
/           1. -p -> -q
/           2.  q
/               p
/              The rule of inference is: Modus Tollendo Tollens
/
/          1. p v q
/          2. -q
/              p
/              The rule of inference is: Modus Tollendo Ponens
*/

#include <iostream>

void checkMPP(std::string premise1, std::string premise2);
void checkMTT(std::string premise1, std::string premise2);
void checkMTP(std::string premise1, std::string premise2);

int main()
{
    // Ask for two premises
    std::string premise1, premise2;

    std::cout << "Ingrese la primera premisa: ";
    getline(std::cin, premise1);
    std::cout << "Ingrese la segunda premisa: ";
    getline(std::cin, premise2);

    // Check that the second premise is only a term
    if (premise2.length() > 2)
    {
        std::cout << "La segunda premisa debe ser solo un termino. \n";
        return -1;
    }

    checkMPP(premise1, premise2);
    checkMTT(premise1, premise2);
    checkMTP(premise1, premise2);

    return 0;
}

void checkMTP(std::string premise1, std::string premise2)
{
    // Check if the OR operator exists
    if (premise1.find("v") != std::string::npos)
    {
        if (premise1.substr(0, 1) == "-" && premise2.substr(0, 1) != "-" && premise2.substr(0, 1) == premise1.substr(1, 1))
        {
            std::cout << premise1.substr(5, 2) << "\n";
            std::cout << "The rule of inference is: Modus Tollendo Ponens\n";
        }
        else if (premise1.substr(4, 1) == "-" && premise2.substr(0, 1) != "-" && premise2.substr(0, 1) == premise1.substr(5, 1))
        {
            std::cout << premise1.substr(0, 1) << "\n";
            std::cout << "The rule of inference is: Modus Tollendo Ponens\n";
        }
        else if (premise1.substr(0, 1) == "-" && premise1.substr(5, 1) == "-" && premise2.substr(0, 1) != "-" && premise2.substr(0, 1) == premise1.substr(1, 1))
        {
            std::cout << premise1.substr(5, 2) << "\n";
            std::cout << "The rule of inference is: Modus Tollendo Ponens\n";
        }
        else if (premise1.substr(0, 1) == "-" && premise1.substr(5, 1) == "-" && premise2.substr(0, 1) != "-" && premise2.substr(0, 1) == premise1.substr(6, 1))
        {
            std::cout << premise1.substr(0, 2) << "\n";
            std::cout << "The rule of inference is: Modus Tollendo Ponens\n";
        }
        else if (premise1.substr(0, 1) != "-" && premise2.substr(0, 1) == "-" && premise2.substr(1, 1) == premise1.substr(0, 1))
        {
            std::cout << premise1.substr(4, 2) << "\n";
            std::cout << "The rule of inference is: Modus Tollendo Ponens\n";
        }
        else if (premise1.substr(0, 1) == "-" && premise1.substr(5, 1) != "-" && premise2.substr(0, 1) == "-" && premise2.substr(1, 1) == premise1.substr(5, 1))
        {
            std::cout << premise1.substr(0, 2) << "\n";
            std::cout << "The rule of inference is: Modus Tollendo Ponens\n";
        }
        else if (premise1.substr(0, 1) != "-" && premise1.substr(4, 1) != "-" && premise2.substr(0, 1) == "-" && premise2.substr(1, 1) == premise1.substr(4, 1))
        {
            std::cout << premise1.substr(0, 1) << "\n";
            std::cout << "The rule of inference is: Modus Tollendo Ponens\n";
        }            

    }
}

void checkMPP(std::string premise1, std::string premise2)
{
    // Check if the -> operator exists
    if (premise1.find("->") != std::string::npos)
    {
        if (premise1.substr(0, 1) == "-" && premise2.substr(0, 1) == "-" && premise1.substr(1, 1) == premise2.substr(1, 1))
        {
            std::cout << premise1.substr(6, 2) << "\n";
            std::cout << "The rule of inference is: Modus Ponendo Ponens\n";
        }
        else if (premise1.substr(0, 1) != "-" && premise2.substr(0, 1) != "-" && premise1.substr(0, 1) == premise2.substr(0, 1))
        {
            std::cout << premise1.substr(5, 2) << '\n';
            std::cout << "The rule of inference is: Modus Ponendo Ponens\n";
        }
    }
}

void checkMTT(std::string premise1, std::string premise2)
{
    // Check if the -> operator exists
    if (premise1.find("->") != std::string::npos)
    {
        if (premise1.substr(6, 1) == "-" && premise2.substr(0, 1) != "-" && premise1.substr(7, 1) == premise2.substr(0, 1) && premise1.substr(0, 1) == "-")
        {
            std::cout << premise1.substr(1, 1) << "\n";
            std::cout << "The rule of inference is: Modus Tollendo Tollens\n";
        }
        else if (premise1.substr(5, 1) == "-" && premise2.substr(0, 1) != "-" && premise1.substr(6, 1) == premise2.substr(0, 1) && premise1.substr(0, 1) != "-")
        {
            std::cout << "-" + premise1.substr(0, 1) << '\n';
            std::cout << "The rule of inference is: Modus Tollendo Tollens\n";
        }
        else if (premise1.substr(6, 1) != "-" && premise2.substr(0, 1) == "-" && premise1.substr(6, 1) == premise2.substr(1, 1) && premise1.substr(0, 1) == "-")
        {
            std::cout << premise1.substr(1, 1) << '\n';
            std::cout << "The rule of inference is: Modus Tollendo Tollens\n";
        }
        else if (premise1.substr(5, 1) != "-" && premise2.substr(0, 1) == "-" && premise1.substr(5, 1) == premise2.substr(1, 1) && premise1.substr(0, 1) != "-")
        {
            std::cout << "-" + premise1.substr(0, 1) << '\n';
            std::cout << "The rule of inference is: Modus Tollendo Tollens\n";
        }
    }
}
