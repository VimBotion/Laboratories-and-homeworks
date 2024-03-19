#include <iostream>
#include <string>
#include <iomanip>

const int NUM_STUDENTS = 50;
const int NUM_SUBJECTS = 6;

void sort(std::string *names, int numStudents, double grades[][NUM_SUBJECTS]);
void enterStudents(std::string *names, int numStudents);
void enterGrades(double grades[][NUM_SUBJECTS], std::string *names, int numStudents);
void displayTable(double grades[][NUM_SUBJECTS], std::string *names, int numStudents);

int main(){
    std::string names[NUM_STUDENTS];

    int numStudents;
    do{
        std::cout << "Enter the number of students, at most " << NUM_STUDENTS << '\n';
        std::cin >> numStudents;
    } while (numStudents <= 0 || numStudents > NUM_STUDENTS);

    std::cin.ignore();
    
    enterStudents(names, numStudents);

    double grades[numStudents][NUM_SUBJECTS];

    enterGrades(grades, names, numStudents);

    sort(names, numStudents, grades);
    
    displayTable(grades, names, numStudents);
}

void enterStudents(std::string *names, int numStudents){
    std::cout << "Enter the names of the students: \n";
    for (int i = 0; i < numStudents; i++){
        std::cout << "Student:\n";
        getline(std::cin, names[i]);
    }
}

void enterGrades(double grades[][NUM_SUBJECTS], std::string *names, int numStudents){
    for (int i = 0; i < numStudents; i++){
        std::cout << "Enter the grades for student " << names[i] << '\n';
        for (int j = 0; j < NUM_SUBJECTS; j++){
            std::cout << "Grade for subject " << j + 1 << '\n';
            std::cin >> grades[i][j];
        }
    }
}

void displayTable(double grades[][NUM_SUBJECTS], std::string *names, int numStudents) {
    std::cout << "\nStudents Table:\n";
    std::cout << std::left << std::setw(20) << "Name";
    for (int j = 0; j < NUM_SUBJECTS; ++j) {
        std::cout << std::setw(15) << "Subject ";
    }
    std::cout << std::setw(10) << "AVERAGE" << '\n';

    for (int i = 0; i < numStudents; ++i) {
        double sumGrades = 0;
        std::cout << std::left << std::setw(20) << names[i];
        for (int j = 0; j < NUM_SUBJECTS; ++j) {
            std::cout << std::fixed << std::setprecision(2) << std::setw(15) << grades[i][j];
            sumGrades += grades[i][j];
        }
        double average = sumGrades / NUM_SUBJECTS;
        std::cout << std::fixed << std::setprecision(2) << std::setw(10) << average << '\n';
    }
}

void sort(std::string *names, int numStudents, double grades[][NUM_SUBJECTS]){
    for (int i = 0; i < numStudents - 1; i++) {
        for (int j = 0; j < numStudents - i - 1; j++) {
            if (names[j] > names[j + 1]) {
                std::swap(names[j], names[j + 1]);

                for (int k = 0; k < NUM_SUBJECTS; k++) {
                    std::swap(grades[j][k], grades[j + 1][k]);
                }
            }
        }
    }
}
