#include <iostream>

using namespace std;

int main(){
    int num;
    cout << "Enter a number: " << endl;
    cin >> num;

    if (num > 0)
    {
        cout << "The number is positive" << endl;
    }
    else if (num < 0)
    {
        cout << "The number is negative" << endl;
    }
    else {
        cout << "0 is neither positive nor negative" << endl;
    }
}
