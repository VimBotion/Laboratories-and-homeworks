#include <iostream>

using namespace std;

int main(){
    float salary = 40000;
    float increase = 0;
    int time;

    cout << "Enter the time the employee has been with the company: " << endl;
    cin >> time;

    if (time < 0)
    {
        cout << "Enter a valid value" << endl;
        return 1;
    }

    if (time > 10)
    {
        increase = salary + (salary * 10/100);
    }
    else if (time > 5)
    {
        increase = salary + (salary * 7/100);
    }
    else if (time > 3)
    {
        increase = salary + (salary * 5/100);
    }
    else
    {
        increase = salary + (salary * 3/100);
    }
    
    salary += increase;
    cout << "The increase is: " << increase << " the total salary will be: " << salary << endl;
}
