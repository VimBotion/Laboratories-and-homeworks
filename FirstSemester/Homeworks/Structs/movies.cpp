#include <iostream>
#include <string>

struct Movie {
    std::string title;
    int year;
    std::string genre;
    int duration;
    std::string rating;
};

const int MAX_MOVIES = 50;

void addMovie(Movie movies[MAX_MOVIES], int& movieCount);
void displayMovies(Movie movies[MAX_MOVIES], int movieCount);
void sortMoviesByYear(Movie movies[MAX_MOVIES], int movieCount);
void searchMovieByGenre(Movie movies[MAX_MOVIES], int movieCount);

int main() {
    int option;
    int movieCount = 0;

    Movie movies[MAX_MOVIES];

    do {
        std::cout << "\t MENU \n";
        std::cout << "1. Add Movie\n";
        std::cout << "2. Display Movies\n";
        std::cout << "3. Sort Movies by Year\n";
        std::cout << "4. Search Movie by Genre\n";
        std::cout << "5. Exit\n";
        std::cin >> option;

        switch (option) {
            case 1:
                addMovie(movies, movieCount);
                break;
            case 2:
                displayMovies(movies, movieCount);
                break;
            case 3:
                sortMoviesByYear(movies, movieCount);
                break;
            case 4:
                searchMovieByGenre(movies, movieCount);
                break;
            case 5:
                std::cout << "Thank you for using!\n";
                break;
        }

    } while (option != 5);
}

void addMovie(Movie movies[MAX_MOVIES], int &movieCount) {
    if (movieCount < MAX_MOVIES) {
        std::cin.ignore();
        std::cout << "Enter the Title of the movie:\n";
        std::getline(std::cin, movies[movieCount].title);
        std::cout << "Enter the Release Year of the movie: \n";
        std::cin >> movies[movieCount].year;
        std::cin.ignore();
        std::cout << "Enter the Genre of the movie:\n";
        std::getline(std::cin, movies[movieCount].genre);
        std::cout << "Enter the Duration in minutes: \n";
        std::cin >> movies[movieCount].duration;
        std::cin.ignore();
        std::string rating;
        do {
            std::cout << "Enter the Rating of the movie (G, PG, PG-13, R, and NC-17)\n";
            std::getline(std::cin, rating);
        } while (rating != "G" && rating != "PG" && rating != "PG-13" && rating != "R" && rating != "NC-17");

        movies[movieCount].rating = rating;

        movieCount++;
    } else {
        std::cout << "Maximum number of movies has been reached\n";
    }
}

void displayMovies(Movie movies[MAX_MOVIES], int movieCount) {
    for (int i = 0; i < movieCount; i++) {
        std::cout << "Movie # " << i + 1 << '\n';
        std::cout << "Title: " << movies[i].title << '\n';
        std::cout << "Release Year: " << movies[i].year << '\n';
        std::cout << "Genre: " << movies[i].genre << '\n';
        std::cout << "Duration: " << movies[i].duration << '\n';
        std::cout << "Rating: " << movies[i].rating << '\n';
        std::cout << '\n';
    }
}

void sortMoviesByYear(Movie movies[MAX_MOVIES], int movieCount) {
    for (int i = 0; i < movieCount - 1; i++) {
        for (int j = 0; j < movieCount - i - 1; j++) {
            if (movies[j].year > movies[j + 1].year) {
                Movie temp = movies[j];
                movies[j] = movies[j + 1];
                movies[j + 1] = temp;
            }
        }
    }

    for (int i = 0; i < movieCount; i++) {
        std::cout << "Movie: " << movies[i].title << '\n';
        std::cout << "Release Year: " << movies[i].year << '\n';
        std::cout << '\n';
    }
}

void searchMovieByGenre(Movie movies[MAX_MOVIES], int movieCount) {
    std::cin.ignore();
    std::string genreToSearch;
    std::cout << "Available Genres: \n";
    for (int i = 0; i < movieCount; i++) {
        std::cout << "- " << movies[i].genre << '\n';
    }
    std::cout << "Enter the genre you want to search: " << '\n';
    getline(std::cin, genreToSearch);
    for (int i = 0; i < movieCount; i++) {
        if (genreToSearch == movies[i].genre) {
            std::cout << "Movies with genre: " << movies[i].genre << "!\n";
            std::cout << "Title: " << movies[i].title << '\n';
            break;
        }
    }
}
