#include <iostream>

void ingresarCiudad(Ciudad ciudades[MAX_CIUDADES], int &ciudadesCount);
void ingresarProveedores(Proveedor proveedores[MAX_PROVEEDORES], int &proveedoresCount);

struct Ciudad{
    std::string nombre;
    int codigoCiudad;
};

struct Proveedor{
    std::string nombre;
    std::string direccion;
    std::string telefono;
    int codigoProveedor;
    int codigoCiudad;
};

struct Articulo{
    std::string nombre;
    int stockMinimo = 0;
    int stockActual;
    double precio;
    int codigoArticulo;
    int codigoProveedor;
};

const int MAX_CIUDADES = 3;
const int MAX_PROVEEDORES = 3;
const int MAX_ARTICULOS = 3;
int main(){
    // Contadores del numero de ciudades, proveedores y articulos ingresados
    int ciudadesCount = 0;
    int proveedoresCount = 0;
    int articulosCount = 0;

    // Arrays para cada struct
    Ciudad ciudades[MAX_CIUDADES];
    Proveedor proveedores[MAX_PROVEEDORES];
    Articulo articulos[MAX_ARTICULOS];

    int opcion;
    do {
        std::cout << "\t MENU\n";
        std::cout << "1. Ingresar ciudad\n";
        std::cout << "2. Ingresar proveedores\n";
        std::cout << "3. Ingresar Articulos\n";
        std::cout << "4. Registrar Consumo de un Articulo\n";
        std::cout << "5. Consultar Articulos\n";
        std::cout << "6. Listado de Articulos\n";
        std::cout << "7. Listado de Articulos por Proveedor\n";
        std::cout << "8. Valor del Inventario\n";
        std::cout << "9. Salir\n";

        std::cin >> opcion;

        switch (opcion){
        case 1:
            std::cout << "Hola\n";
            break;
        case 2:
            std::cout << "Hola\n";
            break;
        case 3:
            std::cout << "Hola\n";
            break;
        case 4:
            std::cout << "Hola\n";
            break;
        case 5:
            std::cout << "Hola\n";
            break;
        case 6:
            std::cout << "Hola\n";
            break;
        case 7:
            std::cout << "Hola\n";
            break;
        case 8:
            std::cout << "Hola\n";
            break;
        case 9:
            std::cout << "Hola\n";
            break;
        default:
            std::cout << "Ingrese una opcion valida!\n";
            break;
        }
    } while (opcion != 9);
}

void ingresarCiudad(Ciudad ciudades[MAX_CIUDADES], int &ciudadesCount){
    if (ciudadesCount < MAX_CIUDADES){
        std::cout << "Ingrese el nombre de la ciudad: \n";
        std::cin >> ciudades[ciudadesCount].nombre;
        ciudades[ciudadesCount].codigoCiudad = ciudadesCount;
    }
    else{
        std::cout << "Se han ingresado el maximo de ciudades disponibles, " << MAX_CIUDADES << '\n';
    }
}

void ingresarProveedores(Proveedor proveedores[MAX_PROVEEDORES], int &proveedoresCount){
    if (proveedoresCount < MAX_PROVEEDORES){
        std::cout << "Ingrese el nombre del proveedor:\n";
        std::cin >> proveedores[proveedoresCount].nombre; 
        std::cout << "Ingrese la dirreccion del proveedor:\n";
        std::cin >> proveedores[proveedoresCount].direccion;
        std::cout << "Ingrese el numero de telefono del proveedor: \n";
        std::cin >> proveedores[proveedoresCount].telefono;
        std::cout << "Ingrese el codigo de Ciudad del proveedor: \n";
        std::cin >> proveedores[proveedoresCount].codigoCiudad;
        proveedores[proveedoresCount].codigoProveedor = proveedoresCount;
    }
    else {
        std::cout << "Se han ingreado el maximo de proveedores disponibles, " << MAX_PROVEEDORES << '\n';
    }
}

void ingresarArticulo(Articulo articulos[MAX_ARTICULOS]){

}