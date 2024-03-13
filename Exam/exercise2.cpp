// EXERCISE 2

#include <iostream>
#include <string>
#include <fstream>

struct Subject {
    int subjectCode;
    std::string subjectName;
};

struct Teacher {
    int teacherCode;
    std::string teacherName;
    std::string teacherID;
};

struct Grade {
    int gradeTeacherCode;
    int gradeSubjectCode;
    double studentGrade;
};

const int MAX_SUBJECTS = 20;
const int MAX_TEACHERS = 50;
const int MAX_GRADES = 50;

void enterSubject(Subject subjects[], int &subjectCount);
void listSubjects(Subject subjects[], int subjectCount);
void enterTeacher(Teacher teachers[], int &teacherCount);
void listTeachers(Teacher teachers[], int teacherCount);
void enterGrade(Grade grades[], int &gradeCount, Subject subjects[], int subjectCount, Teacher teachers[], int teacherCount);
void listGrades(Grade grades[], int gradeCount);
void consultTeacher(Grade grades[], int &gradeCount, Subject subjects[], int subjectCount, Teacher teachers[], int teacherCount);

int main() {
    int option;
    int subjectCount = 0;
    int teacherCount = 0;
    int gradeCount = 0;

    Subject subjects[MAX_SUBJECTS];
    Teacher teachers[MAX_TEACHERS];
    Grade grades[MAX_GRADES];

    do {
        std::cout << "\tMenu\n";
        std::cout << "1. Enter Subject\n";
        std::cout << "2. Enter Teacher \n";
        std::cout << "3. Enter Grade\n";
        std::cout << "4. List Subjects\n";
        std::cout << "5. List Teachers\n";
        std::cout << "6. List Grades \n";
        std::cout << "7. Consult Teacher\n";
        std::cout << "8. Export Teachers\n";
        std::cout << "9. Exit\n";
        std::cin >> option;

        switch (option) {
            case 1:
                enterSubject(subjects, subjectCount);
                break;
            case 2:
                enterTeacher(teachers, teacherCount);
                break;
            case 3:
                enterGrade(grades, gradeCount, subjects, subjectCount, teachers, teacherCount);
                break;
            case 4:
                listSubjects(subjects, subjectCount);
                break;
            case 5:
                listTeachers(teachers, teacherCount);
                break;
            case 6:
                listGrades(grades, gradeCount);
                break;
            case 7:
                consultTeacher(grades, gradeCount, subjects, subjectCount, teachers, teacherCount);
                break;
            case 8:

                break;
            case 9:
                std::cout << "Thank you for using the program, goodbye!\n";
                break;
            default:
                std::cout << "Enter a valid option!\n";
                break;
        }
    } while (option != 9);

    return 0;
}

void enterSubject(Subject subjects[], int &subjectCount) {
    if (subjectCount < MAX_SUBJECTS) {
        std::cin.ignore();
        subjects[subjectCount].subjectCode = subjectCount;
        std::cout << "Enter the name of the subject: \n";
        std::getline(std::cin, subjects[subjectCount].subjectName);
        subjectCount++;
    } else {
        std::cout << "Maximum number of subjects entered!\n";
    }
}

void listSubjects(Subject subjects[], int subjectCount) {
    for (int i = 0; i < subjectCount; i++) {
        std::cout << "Subject Code: " << subjects[i].subjectCode << "\n";
        std::cout << "Subject Name: " << subjects[i].subjectName << "\n";
    }
}

void enterTeacher(Teacher teachers[], int &teacherCount) {
    std::string idNumber;
    int idLength;
    if (teacherCount < MAX_TEACHERS) {
        std::cin.ignore();
        teachers[teacherCount].teacherCode = teacherCount;
        std::cout << "Enter the name of the teacher: \n";
        std::getline(std::cin, teachers[teacherCount].teacherName);

        do {
            std::cout << "Enter the ID of the teacher: \n";
            std::cin >> idNumber;
            idLength = idNumber.length();
        } while (idLength != 10);
        teachers[teacherCount].teacherID = idNumber;
        teacherCount++;
    } else {
        std::cout << "Maximum number of teachers entered!\n";
    }
}

void listTeachers(Teacher teachers[], int teacherCount) {
    for (int i = 0; i < teacherCount; i++) {
        std::cout << "Teacher Code: " << teachers[i].teacherCode << "\n";
        std::cout << "Teacher Name: " << teachers[i].teacherName << "\n";
        std::cout << "Teacher ID: " << teachers[i].teacherID << "\n";
    }
}

void enterGrade(Grade grades[], int &gradeCount, Subject subjects[], int subjectCount, Teacher teachers[], int teacherCount) {
    double grade;
    if (gradeCount < MAX_GRADES) {
        if (teacherCount == 0) {
            std::cout << "No teacher code found, please enter a teacher first\n";
            return;
        }

        if (subjectCount == 0) {
            std::cout << "No subject code found, please enter a subject first\n";
            return;
        }

        std::cout << "Available teacher codes: \n";
        for (int i = 0; i < teacherCount; i++) {
            std::cout << "Teacher Code: " << teachers[i].teacherCode << "\n";
        }

        std::cout << "Enter the teacher code to choose: \n";
        std::cin >> grades[gradeCount].gradeTeacherCode;

        std::cout << "Available subject codes: \n";
        for (int i = 0; i < subjectCount; i++) {
            std::cout << "Subject Code: " << subjects[i].subjectCode << "\n";
        }

        std::cout << "Enter the subject code to choose: \n";
        std::cin >> grades[gradeCount].gradeSubjectCode;

        do {
            std::cout << "Enter the grade out of 10: \n";
            std::cin >> grade;
        } while (grade < 0 || grade > 10);

        grades[gradeCount].studentGrade = grade;
        gradeCount++;
    } else {
        std::cout << "Maximum number of grades entered!\n";
    }
}

void listGrades(Grade grades[], int gradeCount) {
    for (int i = 0; i < gradeCount; i++) {
        std::cout << "Teacher Code: " << grades[i].gradeTeacherCode << "\n";
        std::cout << "Subject Code: " << grades[i].gradeSubjectCode << "\n";
        std::cout << "Grade: " << grades[i].studentGrade << "\n";
    }
}

void consultTeacher(Grade grades[], int &gradeCount, Subject subjects[], int subjectCount, Teacher teachers[], int teacherCount) {
    if (teacherCount == 0) {
        std::cout << "No teacher code found, please enter a teacher first\n";
        return;
    }

    std::cout << "Available teacher codes: \n";
    for (int i = 0; i < teacherCount; i++) {
        std::cout << "Teacher Code: " << teachers[i].teacherCode << "\n";
    }

    std::cout << "Enter the teacher code to choose: \n";
    int chosenCode;
    std::cin >> chosenCode;

    std::cout << "Teacher: " << teachers[chosenCode].teacherCode
              << " " << teachers[chosenCode].teacherName << " - " << teachers[chosenCode].teacherID << "\n";
    std::cout << "Grade: \n";
}
