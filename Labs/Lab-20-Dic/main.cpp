#include <iostream>

struct Proveedor{
    std::string nombre;
    std::string direccion;
    std::string telefono;
    int codigoProveedor;
    int codigoCiudad;
};

struct Ciudad{
    std::string nombre;
    int codigoCiudad;
};

struct Articulo{
    std::string nombre;
    int stockMinimo;
    int stockActual;
    int codigoArticulo;
    int codigoProveedor;
};


int menu();
void ingresarCiudad(Ciudad ciudades[], int &ciudadesCount);
void mostrarCiudades(const Ciudad ciudades[], int ciudadesCount);


const int MAX_CIUDADES = 3;
const int MAX_PROVEEDOR = 3;
const int MAX_ARTICULOS = 3;

int main(){
    int opcion;
    int ciudadesCount = 0;
    Ciudad ciudades[MAX_CIUDADES];

    do
    {
        opcion = menu();

        switch (opcion)
        {
        case 1:
            ingresarCiudad(ciudades, ciudadesCount);
            std::cout << "Holaaaa\n";
            mostrarCiudades(ciudades, ciudadesCount);
            break;
        case 2:
            std::cout << "Holaaaa\n";
            break;
        case 3:
            std::cout << "Holaaaa23223\n";
            break;
        case 4:
            std::cout << "Holaaaa\n";
            break;
        case 5:
            std::cout << "Holaaaa\n";
            break;
        case 6:
            std::cout << "Holaaaa\n";
            break;
        case 7:
            std::cout << "Holaaaa\n";
            break;
        case 8:
            std::cout << "Holaaaa\n";
            break;
        case 9:
            std::cout << "Gracias por usar!\n";
            break;
        default:
            std::cout << "La opcion ingresada no es valida!\n";
            break;
        }
    } while (opcion != 9);

    return 0;
}

int menu(){
    int opcion;
    do{
        std::cout << "######################\n";
        std::cout << "\tMENU" << '\n';
        std::cout << "######################\n";
        std::cout << "1. Ingresar ciudad\n";
        std::cout << "2. Ingresar Proveedores\n";
        std::cout << "3. Ingresar Articulos\n";
        std::cout << "4. Registrar Consumo de un Articulo\n";
        std::cout << "5. Consultar Articulo\n";
        std::cout << "6. Listado de Articulos\n";
        std::cout << "7. Listado de Articulos por Proveedor\n";
        std::cout << "8. Valor del inventario\n";
        std::cout << "9. Salir!\n";
        std::cin >> opcion;

    } while (opcion < 1 || opcion > 9);
    return opcion;
}

void ingresarCiudad(Ciudad ciudades[], int &ciudadesCount) {
    if (ciudadesCount < MAX_CIUDADES) {
        std::cout << "Ingrese el nombre de la ciudad: \n";
        std::cin >> ciudades[ciudadesCount].nombre;
        std::cout << "Ingrese el codigo de la ciudad: \n";
        std::cin >> ciudades[ciudadesCount].codigoCiudad;
        ciudadesCount++;
    } else {
        std::cout << "No se pueden agregar más ciudades. Límite alcanzado.\n";
    }
}

void ingresarProveedores(Proveedor proveedores[], int &proveedorCount){
    if (proveedorCount < MAX_PROVEEDOR){
        std::cout << "Ingrese el nombre del proveedor: \n";
        std::cin >> proveedores[proveedorCount].nombre;
        std::cout << "Ingrese la direccion del proveedor: \n";
        std::cin >> proveedores[proveedorCount].direccion;
    }
}

void mostrarCiudades(const Ciudad ciudades[], int ciudadesCount) {
    for (int i = 0; i < ciudadesCount; i++) {
        std::cout << "NOMBRE: " << ciudades[i].nombre << '\n';
        std::cout << "CODIGO: " << ciudades[i].codigoCiudad << '\n';
    }
}