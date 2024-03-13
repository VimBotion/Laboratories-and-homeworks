#include <iostream>
#include <string>

void formatDateString(int day, int month, std::string year);
std::string formatYear(std::string year);

int main()
{
    int day, month;
    std::string year;

    std::cout << "Enter the day: \n";
    std::cin >> day;
    std::cout << "Enter the month: \n";
    std::cin >> month;
    std::cout << "Enter the year: \n";
    std::cin >> year;
    formatDateString(day, month, year);
}

void formatDateString(int day, int month, std::string year)
{
    if (day < 1 || day > 31)
    {
        std::cout << "Enter a valid day number \n";
        return;
    }
    else if (month < 1 || month > 12)
    {
        std::cout << "Enter a valid month number \n";
        return;
    }

    std::string formattedYear = formatYear(year);

    std::cout << day << "/" << month << "/" << formattedYear << "\n";
}

std::string formatYear(std::string year)
{
    int yearLength = year.length() - 2;
    std::string formattedYear = year.substr(yearLength, 2);
    return formattedYear;
}
