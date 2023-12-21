#include <iostream>
#include <iomanip>
#include <string>

struct Ciudad {
    std::string nombre;
    int codigoCiudad;
};

struct Proveedor {
    std::string nombre;
    std::string direccion;
    std::string telefono;
    int codigoProveedor;
    int codigoCiudad;
};

struct Articulo {
    std::string nombre;
    int stockMinimo;
    int stockActual;
    double precio;
    int codigoArticulo;
    int codigoProveedor;
};

const int MAX_CIUDADES = 10;
const int MAX_PROVEEDORES = 10;
const int MAX_ARTICULOS = 50;

void ingresarCiudad(Ciudad ciudades[MAX_CIUDADES], int &ciudadesCount);
void ingresarProveedores(Proveedor proveedores[MAX_PROVEEDORES], int &proveedoresCount, Ciudad ciudades[MAX_CIUDADES], int ciudadesCount);
void ingresarArticulo(Articulo articulos[MAX_ARTICULOS], int &articulosCount, Proveedor proveedores[MAX_PROVEEDORES], int proveedoresCount);
void registrarConsumo(Articulo articulos[MAX_ARTICULOS], int articulosCount);
void consultarArticulo(Articulo articulos[MAX_ARTICULOS], int articulosCount);
void listarArticulos(Articulo articulos[MAX_ARTICULOS], int articulosCount);
void listarArticulosPorProveedor(Articulo articulos[MAX_ARTICULOS], int articulosCount, Proveedor proveedores[MAX_PROVEEDORES], int proveedoresCount);
void calcularValorInventario(Articulo articulos[MAX_ARTICULOS], int articulosCount);

int main() {
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
        std::cout << "1. Ingresar Ciudad\n";
        std::cout << "2. Ingresar Proveedores\n";
        std::cout << "3. Ingresar Articulos\n";
        std::cout << "4. Registrar Consumo de un Articulo\n";
        std::cout << "5. Consultar Articulos\n";
        std::cout << "6. Listado de Articulos\n";
        std::cout << "7. Listado de Articulos por Proveedor\n";
        std::cout << "8. Valor del Inventario\n";
        std::cout << "9. Salir\n";

        std::cin >> opcion;

        switch (opcion) {
        case 1:
            ingresarCiudad(ciudades, ciudadesCount);
            break;
        case 2:
            ingresarProveedores(proveedores, proveedoresCount, ciudades, ciudadesCount);
            break;
        case 3:
            ingresarArticulo(articulos, articulosCount, proveedores, proveedoresCount);
            break;
        case 4:
            registrarConsumo(articulos, articulosCount);
            break;
        case 5:
            consultarArticulo(articulos, articulosCount);
            break;
        case 6:
            listarArticulos(articulos, articulosCount);
            break;
        case 7:
            listarArticulosPorProveedor(articulos, articulosCount, proveedores, proveedoresCount);
            break;
        case 8:
            calcularValorInventario(articulos, articulosCount);
            break;
        case 9:
            std::cout << "Gracias por haber utilizado el programa!\n";
            break;
        default:
            std::cout << "Ingrese una opcion valida!\n";
            break;
        }
    } while (opcion != 9);

    return 0;
}

// Implementación de las funciones

void ingresarCiudad(Ciudad ciudades[MAX_CIUDADES], int &ciudadesCount) {
    if (ciudadesCount < MAX_CIUDADES) {
        std::string nombreCiudad;
        std::cout << "Ingrese el nombre de la ciudad: \n";
        std::cin >> nombreCiudad;

        // Verificar si la ciudad ya existe
        bool ciudadExistente = false;
        for (int i = 0; i < ciudadesCount; ++i) {
            if (ciudades[i].nombre == nombreCiudad) {
                ciudadExistente = true;
                break;
            }
        }

        if (!ciudadExistente) {
            ciudades[ciudadesCount].nombre = nombreCiudad;
            ciudades[ciudadesCount].codigoCiudad = ciudadesCount;
            ++ciudadesCount;
        } else {
            std::cout << "La ciudad ya existe.\n";
        }
    } else {
        std::cout << "Se han ingresado el maximo de ciudades disponibles, " << MAX_CIUDADES << '\n';
    }
}

void ingresarProveedores(Proveedor proveedores[MAX_PROVEEDORES], int &proveedoresCount, Ciudad ciudades[MAX_CIUDADES], int ciudadesCount) {
    if (proveedoresCount < MAX_PROVEEDORES) {
        std::string nombreProveedor;
        std::cout << "Ingrese el nombre del proveedor:\n";
        std::cin >> nombreProveedor;

        // Verificar si el proveedor ya existe
        bool proveedorExistente = false;
        for (int i = 0; i < proveedoresCount; ++i) {
            if (proveedores[i].nombre == nombreProveedor) {
                proveedorExistente = true;
                break;
            }
        }

        if (!proveedorExistente) {
            proveedores[proveedoresCount].nombre = nombreProveedor;
            proveedores[proveedoresCount].codigoProveedor = proveedoresCount;
            // Seleccionar ciudad para el proveedor
            std::cout << "Ciudades Disponibles:\n";
            for (int i = 0; i < ciudadesCount; ++i) {
                std::cout << i << ". " << ciudades[i].nombre << '\n';
            }
            std::cout << "Seleccione el codigo de la ciudad del proveedor:\n";
            std::cin >> proveedores[proveedoresCount].codigoCiudad;
            ++proveedoresCount;
        } else {
            std::cout << "El proveedor ya existe.\n";
        }
    } else {
        std::cout << "Se han ingresado el maximo de proveedores disponibles, " << MAX_PROVEEDORES << '\n';
    }
}

void ingresarArticulo(Articulo articulos[MAX_ARTICULOS], int &articulosCount, Proveedor proveedores[MAX_PROVEEDORES], int proveedoresCount) {
    if (articulosCount < MAX_ARTICULOS) {
        std::string nombreArticulo;
        std::cout << "Ingrese el nombre del articulo: \n";
        std::cin >> nombreArticulo;

        // Verificar si el articulo ya existe
        bool articuloExistente = false;
        for (int i = 0; i < articulosCount; ++i) {
            if (articulos[i].nombre == nombreArticulo) {
                articuloExistente = true;
                break;
            }
        }

        if (!articuloExistente) {
            articulos[articulosCount].nombre = nombreArticulo;

            // Seleccionar proveedor para el articulo
            std::cout << "Proveedores Disponibles:\n";
            for (int i = 0; i < proveedoresCount; ++i) {
                std::cout << i << ". " << proveedores[i].nombre << '\n';
            }
            std::cout << "Seleccione el codigo del proveedor del articulo:\n";
            std::cin >> articulos[articulosCount].codigoProveedor;

            // Ingresar información adicional del articulo
            do {
                std::cout << "Ingrese el stock minimo del articulo: \n";
                std::cin >> articulos[articulosCount].stockMinimo;
                std::cout << "Ingrese el stock actual del articulo: \n";
                std::cin >> articulos[articulosCount].stockActual;
                std::cout << "Ingrese el precio del articulo: \n";
                std::cin >> articulos[articulosCount].precio;
            } while (articulos[articulosCount].stockMinimo < 0 || articulos[articulosCount].stockActual < 0 || articulos[articulosCount].precio < 0);

            articulos[articulosCount].codigoArticulo = articulosCount;
            ++articulosCount;
        } else {
            std::cout << "El articulo ya existe.\n";
        }
    } else {
        std::cout << "Se han ingresado el maximo de articulos disponibles, " << MAX_ARTICULOS << '\n';
    }
}

void registrarConsumo(Articulo articulos[MAX_ARTICULOS], int articulosCount) {
    int codigoArticulo;
    int cantidadConsumida;
    std::cout << "Ingrese el codigo del articulo: \n";
    std::cin >> codigoArticulo;

    // Buscar el articulo por su código
    int indiceArticulo = -1;
    for (int i = 0; i < articulosCount; ++i) {
        if (articulos[i].codigoArticulo == codigoArticulo) {
            indiceArticulo = i;
            break;
        }
    }

    if (indiceArticulo != -1) {
        std::cout << "Ingrese la cantidad consumida: \n";
        std::cin >> cantidadConsumida;

        // Validar que la cantidad consumida no supere el stock actual
        if (cantidadConsumida <= articulos[indiceArticulo].stockActual) {
            articulos[indiceArticulo].stockActual -= cantidadConsumida;
            std::cout << "Consumo registrado correctamente.\n";
        } else {
            std::cout << "La cantidad consumida supera el stock actual.\n";
        }
    } else {
        std::cout << "No se encontró un articulo con el codigo proporcionado.\n";
    }
}

void consultarArticulo(Articulo articulos[MAX_ARTICULOS], int articulosCount) {
    int codigoArticulo;
    std::cout << "Ingrese el codigo del articulo: \n";
    std::cin >> codigoArticulo;

    // Buscar el articulo por su código
    int indiceArticulo = -1;
    for (int i = 0; i < articulosCount; ++i) {
        if (articulos[i].codigoArticulo == codigoArticulo) {
            indiceArticulo = i;
            break;
        }
    }

    if (indiceArticulo != -1) {
        // Mostrar información del articulo
        std::cout << std::setw(20) << "NOMBRE: " << articulos[indiceArticulo].nombre << '\n';
        std::cout << std::setw(20) << "STOCK MINIMO: " << articulos[indiceArticulo].stockMinimo << '\n';
        std::cout << std::setw(20) << "STOCK ACTUAL: " << articulos[indiceArticulo].stockActual << '\n';
        std::cout << std::setw(20) << "PRECIO: " << articulos[indiceArticulo].precio << '\n';
        std::cout << std::setw(20) << "CODIGO DEL ARTICULO: " << articulos[indiceArticulo].codigoArticulo << '\n';
        std::cout << std::setw(20) << "CODIGO DEL PROVEEDOR: " << articulos[indiceArticulo].codigoProveedor << '\n';
    } else {
        std::cout << "No se encontró un articulo con el codigo proporcionado.\n";
    }
}

void listarArticulos(Articulo articulos[MAX_ARTICULOS], int articulosCount) {
    std::cout << "Listado de Articulos:\n";
    for (int i = 0; i < articulosCount; ++i) {
        std::cout << std::setw(20) << "NOMBRE: " << articulos[i].nombre << '\n';
        std::cout << std::setw(20) << "STOCK MINIMO: " << articulos[i].stockMinimo << '\n';
        std::cout << std::setw(20) << "STOCK ACTUAL: " << articulos[i].stockActual << '\n';
        std::cout << std::setw(20) << "PRECIO: " << articulos[i].precio << '\n';
        std::cout << std::setw(20) << "CODIGO DEL ARTICULO: " << articulos[i].codigoArticulo << '\n';
        std::cout << std::setw(20) << "CODIGO DEL PROVEEDOR: " << articulos[i].codigoProveedor << '\n';

        // Mostrar mensaje de "Requiere compra" si el stock actual es menor al stock mínimo
        if (articulos[i].stockActual < articulos[i].stockMinimo) {
            std::cout << std::setw(20) << "Requiere compra\n";
        }

        std::cout << "--------------------------------------------\n";
    }
}

void listarArticulosPorProveedor(Articulo articulos[MAX_ARTICULOS], int articulosCount, Proveedor proveedores[MAX_PROVEEDORES], int proveedoresCount) {
    std::cout << "Listado de Articulos por Proveedor:\n";
    for (int i = 0; i < proveedoresCount; ++i) {
        std::cout << "Proveedor: " << proveedores[i].nombre << '\n';

        for (int j = 0; j < articulosCount; ++j) {
            if (articulos[j].codigoProveedor == i) {
                std::cout << std::setw(20) << "NOMBRE: " << articulos[j].nombre << '\n';
                std::cout << std::setw(20) << "STOCK MINIMO: " << articulos[j].stockMinimo << '\n';
                std::cout << std::setw(20) << "STOCK ACTUAL: " << articulos[j].stockActual << '\n';
                std::cout << std::setw(20) << "PRECIO: " << articulos[j].precio << '\n';
                std::cout << std::setw(20) << "CODIGO DEL ARTICULO: " << articulos[j].codigoArticulo << '\n';
                std::cout << std::setw(20) << "CODIGO DEL PROVEEDOR: " << articulos[j].codigoProveedor << '\n';

                // Mostrar mensaje de "Requiere compra" si el stock actual es menor al stock mínimo
                if (articulos[j].stockActual < articulos[j].stockMinimo) {
                    std::cout << std::setw(20) << "Requiere compra\n";
                }

                std::cout << "--------------------------------------------\n";
            }
        }
    }
}

void calcularValorInventario(Articulo articulos[MAX_ARTICULOS], int articulosCount) {
    double valorTotal = 0.0;
    for (int i = 0; i < articulosCount; ++i) {
        valorTotal += articulos[i].stockActual * articulos[i].precio;
    }
    std::cout << "Valor del Inventario: $" << std::fixed << std::setprecision(2) << valorTotal << '\n';
}
