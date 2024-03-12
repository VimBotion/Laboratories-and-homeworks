#include <iostream>

struct Pelicula {
  std::string titulo;
  int anio;
  std::string genero;
  int duracion;
  std::string clasificacion;
};

const int MAX_PELICULAS = 50;

int main(){
  int opcion;
  int peliculas_count = 0;
  Pelicula peliculas[MAX_PELICULAS]
  
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

