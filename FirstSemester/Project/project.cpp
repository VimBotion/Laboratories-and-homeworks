#include <iostream>
#include <fstream>
#include <string>

struct Student {
    std::string name;
    int age;
    std::string major;
};

void registerStudent() {
    std::ofstream file("students.txt", std::ios::app);
    if (!file) {
        std::cerr << "Error opening the file." << std::endl;
        return;
    }

    Student newStudent;

    std::cout << "Enter the student's name: ";
    std::getline(std::cin, newStudent.name);
    std::cout << "Enter the student's age: ";
    std::cin >> newStudent.age;
    std::cin.ignore(); // Clear the input buffer
    std::cout << "Enter the student's major: ";
    std::getline(std::cin, newStudent.major);

    file << newStudent.name << "," << newStudent.age << "," << newStudent.major << std::endl;

    std::cout << "Student registered successfully." << std::endl;

    file.close();
}

void showStudents() {
    std::ifstream file("students.txt");

    if (!file) {
        std::cerr << "No students registered." << std::endl;
        return;
    }

    Student student;

    std::cout << "List of Registered Students:" << std::endl;

    while (std::getline(file, student.name, ',') &&
           file >> student.age &&
           std::getline(file >> std::ws, student.major)) {
        std::cout << "Name: " << student.name << ", Age: " << student.age << ", Major: " << student.major << std::endl;
    }

    file.close();
}

int main() {
    int option;
    do {
        std::cout << "\nMenu:\n";
        std::cout << "1. Register Student\n";
        std::cout << "2. Show Registered Students\n";
        std::cout << "3. Exit\n";
        std::cout << "Select an option: ";
        std::cin >> option;
        std::cin.ignore(); // Clear the input buffer

        switch (option) {
            case 1:
                registerStudent();
                break;
            case 2:
                showStudents();
                break;
            case 3:
                std::cout << "Exiting the program. Goodbye!" << std::endl;
                break;
            default:
                std::cout << "Invalid option. Please try again." << std::endl;
                break;
        }
    } while (option != 3);

    return 0;
}
