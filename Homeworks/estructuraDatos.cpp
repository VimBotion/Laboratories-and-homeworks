#include <iostream>
#include <string>

struct Pelicula {
    std::string titulo;
    int anio;
    std::string genero;
    int duracion;
    std::string clasificacion;
};

const int MAX_PELICULAS = 50;

void agregarPelicula(Pelicula peliculas[MAX_PELICULAS], int& cantidadPeliculas);
void mostrarPeliculas(Pelicula peliculas[MAX_PELICULAS], int cantidadPeliculas);
void ordenarPeliculasPorAnio(Pelicula peliculas[MAX_PELICULAS], int cantidadPeliculas);
void buscarPeliculaPorGenero(Pelicula peliculas[MAX_PELICULAS], int cantidadPeliculas);
void modificarPelicula(Pelicula peliculas[MAX_PELICULAS], int cantidadPeliculas);
void eliminarPelicula(Pelicula peliculas[MAX_PELICULAS], int& cantidadPeliculas);

int main() {
    int opcion;
    int cantidadPeliculas = 0;

    Pelicula peliculas[MAX_PELICULAS];

    do {
        std::cout << "\t MENÚ \n";
        std::cout << "1. Agregar Película\n";
        std::cout << "2. Mostrar Películas\n";
        std::cout << "3. Ordenar Películas por Año\n";
        std::cout << "4. Buscar Película por Género\n";
        std::cout << "5. Modificar Película\n";
        std::cout << "6. Eliminar Película\n";
        std::cout << "7. Salir\n";
        std::cin >> opcion;

        switch (opcion) {
            case 1:
                agregarPelicula(peliculas, cantidadPeliculas);
                break;
            case 2:
                mostrarPeliculas(peliculas, cantidadPeliculas);
                break;
            case 3:
                ordenarPeliculasPorAnio(peliculas, cantidadPeliculas);
                break;
            case 4:
                buscarPeliculaPorGenero(peliculas, cantidadPeliculas);
                break;
            case 5:
                modificarPelicula(peliculas, cantidadPeliculas);
                break;
            case 6:
                eliminarPelicula(peliculas, cantidadPeliculas);
                break;
            case 7:
                std::cout << "Gracias por usar!\n";
                break;
        }

    } while (opcion != 7);
}

void agregarPelicula(Pelicula peliculas[MAX_PELICULAS], int &cantidadPeliculas) {
    if (cantidadPeliculas < MAX_PELICULAS) {
        std::cin.ignore();
        std::cout << "Ingrese el título de la película:\n";
        std::getline(std::cin, peliculas[cantidadPeliculas].titulo);
        std::cout << "Ingrese el año de lanzamiento de la película: \n";
        std::cin >> peliculas[cantidadPeliculas].anio;
        std::cin.ignore();
        std::cout << "Ingrese el género de la película:\n";
        std::getline(std::cin, peliculas[cantidadPeliculas].genero);
        std::cout << "Ingrese la duración en minutos: \n";
        std::cin >> peliculas[cantidadPeliculas].duracion;
        std::cin.ignore();
        std::string clasificacion;
        do {
            std::cout << "Ingrese la clasificación de la película (G, PG, PG-13, R, y NC-17)\n";
            std::getline(std::cin, clasificacion);
        } while (clasificacion != "G" && clasificacion != "PG" && clasificacion != "PG-13" && clasificacion != "R" && clasificacion != "NC-17");

        peliculas[cantidadPeliculas].clasificacion = clasificacion;

        cantidadPeliculas++;
    } else {
        std::cout << "Se ha alcanzado el número máximo de películas\n";
    }
}

void mostrarPeliculas(Pelicula peliculas[MAX_PELICULAS], int cantidadPeliculas) {
    for (int i = 0; i < cantidadPeliculas; i++) {
        std::cout << "Película # " << i + 1 << '\n';
        std::cout << "Título: " << peliculas[i].titulo << '\n';
        std::cout << "Año de lanzamiento: " << peliculas[i].anio << '\n';
        std::cout << "Género: " << peliculas[i].genero << '\n';
        std::cout << "Duración: " << peliculas[i].duracion << '\n';
        std::cout << "Clasificación: " << peliculas[i].clasificacion << '\n';
        std::cout << '\n';
    }
}

void ordenarPeliculasPorAnio(Pelicula peliculas[MAX_PELICULAS], int cantidadPeliculas) {
    for (int i = 0; i < cantidadPeliculas - 1; i++) {
        for (int j = 0; j < cantidadPeliculas - i - 1; j++) {
            if (peliculas[j].anio > peliculas[j + 1].anio) {
                Pelicula temp = peliculas[j];
                peliculas[j] = peliculas[j + 1];
                peliculas[j + 1] = temp;
            }
        }
    }

    for (int i = 0; i < cantidadPeliculas; i++) {
        std::cout << "Película: " << peliculas[i].titulo << '\n';
        std::cout << "Año de lanzamiento: " << peliculas[i].anio << '\n';
        std::cout << '\n';
    }
}

void buscarPeliculaPorGenero(Pelicula peliculas[MAX_PELICULAS], int cantidadPeliculas) {
    std::cin.ignore();
    std::string generoABuscar;
    std::cout << "Géneros disponibles: \n";
    for (int i = 0; i < cantidadPeliculas; i++) {
        std::cout << "- " << peliculas[i].genero << '\n';
    }
    std::cout << "Ingrese el género que desea buscar: " << '\n';
    getline(std::cin, generoABuscar);
    for (int i = 0; i < cantidadPeliculas; i++) {
        if (generoABuscar == peliculas[i].genero) {
            std::cout << "Películas con género: " << peliculas[i].genero << "!\n";
            std::cout << "Título: " << peliculas[i].titulo << '\n';
            break;
        }
    }
}

void modificarPelicula(Pelicula peliculas[MAX_PELICULAS], int cantidadPeliculas) {
    std::cin.ignore();
    std::string tituloAModificar;
    std::cout << "Ingrese el título de la película que desea modificar: \n";
    std::getline(std::cin, tituloAModificar);

    for (int i = 0; i < cantidadPeliculas; i++) {
        if (tituloAModificar == peliculas[i].titulo) {
            std::cout << "Ingrese nueva información para la película:\n";
            agregarPelicula(peliculas, i);
            std::cout << "Película modificada exitosamente!\n";
            return;
        }
    }

    std::cout << "Película no encontrada!\n";
}

void eliminarPelicula(Pelicula peliculas[MAX_PELICULAS], int& cantidadPeliculas) {
    std::cin.ignore();
    std::string tituloAEliminar;
    std::cout << "Ingrese el título de la película que desea eliminar: \n";
    std::getline(std::cin, tituloAEliminar);

    for (int i = 0; i < cantidadPeliculas; i++) {
        if (tituloAEliminar == peliculas[i].titulo) {
            for (int j = i; j < cantidadPeliculas - 1; j++) {
                peliculas[j] = peliculas[j + 1];
            }

            cantidadPeliculas--;
            std::cout << "Película eliminada exitosamente!\n";
            return;
        }
    }

    std::cout << "Película no encontrada!\n";
}

