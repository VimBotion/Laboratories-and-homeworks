#include <iostream>
#include <string>

void isPalindrome(std::string word) {
    for (int i = 0; i < word.length() / 2; i++) {
        if (word[i] != word[word.length() - 1 - i]) {
            std::cout << "IT IS NOT A PALINDROME\n";
            return;
        }
    }
    std::cout << "THE WORD IS A PALINDROME!\n";
}

int main() {
    std::string word;
    do {
        std::cout << "Enter the word:\n";
        std::cin >> word;
    } while (word.length() > 20);

    isPalindrome(word);
}
