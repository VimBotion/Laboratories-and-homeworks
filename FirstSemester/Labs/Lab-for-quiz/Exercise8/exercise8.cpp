#include <iostream>

float calculateOvertimeSalary(int overtimeHours, int hourlyWage);
float calculateSalary(int hoursWorked, int hourlyWage);

int main()
{
    int hoursWorked, hourlyWage;
    std::cout << "Enter the hours worked: \n";
    std::cin >> hoursWorked;
    std::cout << "Enter the hourly wage: \n";
    std::cin >> hourlyWage;

    std::cout << "The final salary is: " << calculateSalary(hoursWorked, hourlyWage) << "\n";
}

float calculateOvertimeSalary(int overtimeHours, int hourlyWage)
{
    float overtimeHourlyWage = hourlyWage * 1.5;
    return overtimeHours * overtimeHourlyWage;
}

float calculateSalary(int hours, int hourlyWage)
{
    int overtimeSalary, finalSalary;
    finalSalary = 40 * hourlyWage;
    if (hours > 40)
    {
        int overtimeHours = hours - 40;
        overtimeSalary = calculateOvertimeSalary(overtimeHours, hourlyWage);
        finalSalary += overtimeSalary;
    }
    return finalSalary;
}
