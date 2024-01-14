#include <iostream>

using namespace std;

int main()
{
    float celsiusTemperature;
    float fahrenheitTemperature;

    cout << "Enter the temperature in Celsius: " << endl;
    cin >> celsiusTemperature;

    fahrenheitTemperature = (float) 9/5 * celsiusTemperature + 32;

    cout << "The temperature in Fahrenheit is: " << fahrenheitTemperature << endl;

    return 0;
}
