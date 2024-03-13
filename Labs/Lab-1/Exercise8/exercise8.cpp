#include <iostream>
#include <cctype>

using namespace std;

int main(){
    char isVowel;

    cout << "Enter a letter: " << endl;
    cin >> isVowel;
    isVowel = tolower(isVowel);

    if (isVowel == 'a' || isVowel == 'e' || isVowel == 'i' || isVowel == 'o' || isVowel == 'u')
    {
        cout << "The letter is a vowel: " << isVowel << endl;
    }
    else 
    {
        cout << "It is not a vowel" << endl;
    }
}
