#include <iostream>

using namespace std;

int main() 
{
    int num;

    do {
        cout << "Enter a positive number: " << endl;
        cin >> num;
    } while(num < 1);

    if (num % 2 == 0)
    {
        cout << "The number " << num << " is even." << endl;
    }
    else 
    {
        cout << "The number " << num << " is odd." << endl;
    }

    return 0;
}
