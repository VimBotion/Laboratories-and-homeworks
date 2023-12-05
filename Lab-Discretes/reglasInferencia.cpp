#include <iostream>
#include <string>

std::string removeWhiteSpaces(const std::string& str);
bool checkMPP(const std::string& firstMember, const std::string& secondMember, const std::string& premise2);
bool checkMTT(const std::string& firstMember, const std::string& secondMember, const std::string& premise2);
bool checkMTP(const std::string& firstMember, const std::string& secondMember, const std::string& premise2);
void printResult(const std::string& result, const std::string& rule);

int main()
{
    std::cout << "Enter the first premise: \n";
    std::string premise1;
    std::getline(std::cin, premise1);

    std::cout << "Enter the second premise: \n";
    std::string premise2;
    std::getline(std::cin, premise2);

    premise1 = removeWhiteSpaces(premise1);

    size_t checkConditional = premise1.find("->");
    size_t checkDisyuntion = premise1.find("v");

    if (checkConditional != std::string::npos)
    {
        std::string firstMember = premise1.substr(0, checkConditional);
        std::string secondMember = premise1.substr(checkConditional + 2);

        if (checkMPP(firstMember, secondMember, premise2) || checkMTT(firstMember, secondMember, premise2))
        {
            return 0;
        }
    }
    else if (checkDisyuntion != std::string::npos)
    {
        std::string firstMember = premise1.substr(0, checkDisyuntion);
        std::string secondMember = premise1.substr(checkDisyuntion + 1);

        if (checkMTP(firstMember, secondMember, premise2))
        {
            return 0;
        }
    }
    else
    {
        std::cout << "Error, no Conditional or Disjunction found in the first premise\n";
    }

    return 0;
}

std::string removeWhiteSpaces(const std::string& str)
{
    std::string noSpacesString;
    for (char character : str)
    {
        if (!isspace(character))
        {
            noSpacesString += character;
        }
    }
    return noSpacesString;
}

bool checkMPP(const std::string& firstMember, const std::string& secondMember, const std::string& premise2)
{
    return (firstMember == premise2) ? (printResult(secondMember, "modus ponendo ponens"), true) : false;
}

bool checkMTT(const std::string& firstMember, const std::string& secondMember, const std::string& premise2)
{
    std::string firstMemberWithoutSign = (firstMember[0] == '~') ? firstMember.substr(1) : "~" + firstMember;
    std::string secondMemberWithoutSign = (secondMember[0] == '~') ? secondMember.substr(1) : "~" + secondMember;

    return (secondMemberWithoutSign == premise2 || firstMemberWithoutSign == premise2)
               ? (printResult(firstMemberWithoutSign, "modus tollendo tollens"), true)
               : false;
}

bool checkMTP(const std::string& firstMember, const std::string& secondMember, const std::string& premise2)
{
    return (firstMember != premise2 && secondMember != premise2 || "~" + firstMember == premise2)
               ? (printResult(secondMember, "modus tollendo ponens"), true)
               : false;
}

void printResult(const std::string& result, const std::string& rule)
{
    std::cout << "Result: " << result << "\n";
    std::cout << "The inference rules is: " << rule << "\n";
}
