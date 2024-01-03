#include <iostream>
#include <string>

struct Peliculas {
    std::string titulo;
    int anio;
    std::string genero;
    int duracion;
    std::string calificacion;
};

const int MAX_PELICULAS = 3;

void agregarPelicula(Peliculas pelicula[MAX_PELICULAS], int& peliculaCount);
void mostrarPeliculas(Peliculas pelicula[MAX_PELICULAS], int peliculaCount);
void ordenarPeliculas();
void buscarPelicula(Peliculas pelicula[MAX_PELICULAS], int peliculaCount);

int main(){
    int opcion;
    int peliculaCount = 0;

    Peliculas pelicula[3];

    do {
    std::cout << "\t MENU \n";
    std::cout << "1. Agregar pelicula\n";
    std::cout << "2. Mostrar las peliculas\n";
    std::cout << "3. Ordenar peliculas\n";
    std::cout << "4. Buscar pelicula por genero\n";
    std::cout << "5. Salir\n";
    std::cin >> opcion;

    switch (opcion) {
        case 1:
            agregarPelicula(pelicula, peliculaCount);
            break;
        case 2:
            mostrarPeliculas(pelicula, peliculaCount);
            break;
        case 3:
            ordenarPeliculas();
            break;
        case 4:
            buscarPelicula(pelicula, peliculaCount);
            break;
        case 5:
            "Gracias por usar!";
            break;
    }

    } while (opcion != 5);
}

void agregarPelicula(Peliculas pelicula[MAX_PELICULAS], int &peliculaCount){
    if (peliculaCount < MAX_PELICULAS){
        std::cin.ignore();
        std::cout << "Ingrese el Titulo de la pelicula:\n";
        std::getline(std::cin, pelicula[peliculaCount].titulo);
        std::cout << "Ingrese el Año de lanzamiento de la pelicula: \n";
        std::cin >> pelicula[peliculaCount].anio;
        std::cin.ignore();
        std::cout << "Ingrese el Genero de la pelicula:\n";
        std::getline(std::cin, pelicula[peliculaCount].genero);
        std::cout << "Ingrese la Duracion en minutos: \n";
        std::cin >> pelicula[peliculaCount].duracion;
        std::cin.ignore();
        std::string calificacion;
        do {
            std::cout << "Ingrese la Calificacion de la pelicula (G, PG, PG-13, R y NC-17)\n";
            std::getline(std::cin, calificacion);
        } while (calificacion != "G" && calificacion != "PG" && calificacion != "PG-13" && calificacion != "R" && calificacion != "NC-17");

        // Assign the entered calificacion to the corresponding field
        pelicula[peliculaCount].calificacion = calificacion;

        peliculaCount++;
    }
    else {
        std::cout << "Se ha ingresado el maximo de peliculas\n";
    }
}

void mostrarPeliculas(Peliculas pelicula[MAX_PELICULAS], int peliculaCount){
    for (int i = 0; i < peliculaCount; i++){
        std::cout << "Pelicula # " << i + 1 << '\n';
        std::cout << "Titulo: " << pelicula[i].titulo << '\n';
        std::cout << "Año de lanzamiento: " << pelicula[i].anio << '\n';
        std::cout << "Genero: " << pelicula[i].genero << '\n';
        std::cout << "Duracion: " << pelicula[i].duracion << '\n';
        std::cout << "Calificacion: " << pelicula[i].calificacion << '\n';
    }
}


void ordenarPeliculas(){

}

void buscarPelicula(Peliculas pelicula[MAX_PELICULAS], int peliculaCount){
    std::cin.ignore();
    std::string generoBuscar;
    std::cout << "Generos disponibles: \n";
    for (int i = 0; i < peliculaCount; i++){
        std::cout << pelicula[i].genero << '\n';
    }
    std::cout << "Que genero desea buscar: " << '\n';
    getline(std::cin, generoBuscar);
    for(int i = 0; i < peliculaCount; i++){
        if(generoBuscar == pelicula[i].genero){
            std::cout << "Peliculas con genero " << pelicula[i].genero << "\n";
            std::cout << "Titulo: " << pelicula[i].titulo << '\n';        
        }
    }
}