#include <iostream>

using namespace std;

int main(){
    int num1, num2, num3;

    cout << "Enter the first number: " << endl;
    cin >> num1;

    cout << "Enter the second number: " << endl;
    cin >> num2;

    cout << "Enter the third number: " << endl;
    cin >> num3;

    if (num1 > num2)
    {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
    if (num1 > num3)
    {
        int temp = num1;
        num1 = num3;
        num3 = temp;
    }
    if (num2 > num3)
    {
        int temp = num2;
        num2 = num3;
        num3 = temp;
    }

    cout << "Sorted numbers: " << num1 << " " << num2 << " " << num3 << endl;

    return 0;
}
