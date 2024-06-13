// Mantenimiento utilizando listas doblemente ligadas, la entidad a mantener son materias cuya llave es el codigo de materia
// Campoverde Esteban y Apolo Juan
#include <iostream>
#include <cstdlib> 

struct Materia{
    int dato; 
    Materia* siguiente;
    Materia* anterior;
};

Materia* crearNodo(int codigo){
    // asigna espacio para un nuevo nodo
    Materia* nuevo = (Materia *)malloc(sizeof(Materia));
    nuevo->dato = codigo;
    nuevo->siguiente = nullptr;
    nuevo->anterior = nullptr;

    return nuevo;
}

void insertarOrden(Materia*& cabecera, int codigo){
    Materia* nuevo = crearNodo(codigo);
    // si la lista esta vacia
    if(cabecera == nullptr){
        cabecera = nuevo;
    } else {
        if(codigo < cabecera->dato){
            nuevo->siguiente = cabecera;
            cabecera->anterior = nuevo;
            cabecera = nuevo;
        } else {
            // mantiene el seguimiento de los nodos a comparar
            Materia* temp = cabecera;
            while(temp->siguiente != nullptr && codigo > temp->siguiente->dato){
                // sigue al siguiente nodo
                temp = temp->siguiente;
            }
            nuevo->siguiente = temp->siguiente;
            if(temp->siguiente != nullptr){
                // el apuntador anterior del nodo mayor apunta al nuevo nodo 
                temp->siguiente->anterior = nuevo;
            }
            nuevo->anterior = temp;
            temp->siguiente = nuevo;
        }     
    }
}   

Materia* buscarNodo(Materia* cabecera, int codigo){
    Materia* temp = cabecera;
    while(temp != nullptr){
        if(temp->dato == codigo){
            return temp;
        }
        temp = temp->siguiente;
    }
    return nullptr;
}

void bubbleSort(Materia *cabeza) {
    bool intercambiar;
    Materia *recorrer;
    Materia *ultimo = nullptr;

    do {
        intercambiar = false;
        recorrer = cabeza;
        while (recorrer != ultimo && recorrer->siguiente != nullptr) {
            if (recorrer->dato > recorrer->siguiente->dato) {
                std::swap(recorrer->dato, recorrer->siguiente->dato);
                intercambiar = true;
            }
            recorrer = recorrer->siguiente;
        }
        // Retrocede una posicion
        ultimo = recorrer;
    } while (intercambiar);
}

void Modificar(Materia *cabeza, int dato) {
    Materia *temp = buscarNodo(cabeza, dato);
    if (temp != nullptr) {
        int nuevoDato;
        do {
            std::cout << "Ingrese el nuevo valor del codigo de materia: ";
            std::cin >> nuevoDato;
            if (nuevoDato <= 0) {
                std::cout << "Ingrese un codigo de materia mayor a 0\n";
            }
            if (buscarNodo(cabeza, nuevoDato) != nullptr) {
                std::cout << "Codigo de materia existente, ingrese otro valor\n";
            }
        } while (nuevoDato <= 0 || buscarNodo(cabeza, nuevoDato) != nullptr);
        temp->dato = nuevoDato;
        bubbleSort(cabeza);
    } else {
        std::cout << "Codigo de materia no existente\n";
    }
}

bool eliminarNodo(Materia*& cabecera, int codigo){
    Materia* temp = buscarNodo(cabecera, codigo);
    if(temp != nullptr){
        if(temp->siguiente != nullptr){
            temp->siguiente->anterior = temp->anterior;
        }else {
            if (temp->anterior != nullptr) {
                temp->anterior->siguiente = nullptr;
            } else {
                cabecera = nullptr;
            }
        }
        if(temp->anterior != nullptr){
            temp->anterior->siguiente = temp->siguiente;
        } else {
            cabecera = temp->siguiente;
            if (cabecera != nullptr) {
                cabecera->anterior = nullptr;
            }
        }
        free(temp);     
        return true;
    }
    return false;
}

void mostrarAscendente(Materia* cabecera){
    if(cabecera == nullptr){
      std::cout << "La lista esta vacia\n";
      return;
    }
    Materia* temp = cabecera;
    while(temp != nullptr){
        std::cout << temp->dato << " ";
        temp = temp->siguiente;
    }
    std::cout << "\n";
}


void mostrarDescendente(Materia* cabecera){
    if(cabecera == nullptr){
      std::cout << "La lista esta vacia\n";
      return;
    }
    Materia* temp = cabecera;
    while(temp->siguiente != nullptr){
        temp = temp->siguiente;
    }
    while(temp != nullptr){
        std::cout << temp->dato << " ";
        temp = temp->anterior;
    }
    std::cout << "\n";
}

int main(){
    char opcion;
    Materia* cabecera = nullptr;
    Materia* nodoEncontrado;
    int codigo;

    do {
        std::cout << "\tMenu\n";
        std::cout << "1. Insertar Materia\n";
        std::cout << "2. Eliminar Materia\n";
        std::cout << "3. Modificar Materia\n";
        std::cout << "4. Buscar Materia\n";
        std::cout << "5. Mostrar Materias en Orden Ascendente\n";
        std::cout << "6. Mostrar Materias en Orden Descendente\n";
        std::cout << "7. Salir\n";
        std::cout << "Elige una opcion (1-7): ";
        std::cin >> opcion;

        switch (opcion) {
            case '1':   
                do{
                    std::cout << "Ingrese codigo de materia: ";
                    std::cin >> codigo;
                    if (codigo <= 0) {
                        std::cout << "El codigo de la materia tiene que ser mayor a 0\n";
                    }
                    if(buscarNodo(cabecera, codigo) != nullptr){
                        std::cout << "Este codigo ya existe.\n";
                    }
                }while(codigo <= 0 || buscarNodo(cabecera, codigo) != nullptr);   
                insertarOrden(cabecera, codigo);
                break;
            case '2':
                std::cout << "Ingrese el codigo a eliminar: ";
                std::cin >> codigo;
                if(eliminarNodo(cabecera, codigo)){
                    std::cout << "Se elimino con exito.\n";
                }else {
                    std::cout << "No se encontreo codigo a eliminar.\n";
                }
                break;
            case '3':
                std::cout << "Ingrese el codigo de materia a modificar: ";
                std::cin >> codigo;
                Modificar(cabecera, codigo);
                break;
                break;
            case '4':
                std::cout << "Ingrese el codigo a buscar: ";
                std::cin >> codigo;
                nodoEncontrado = buscarNodo(cabecera, codigo);
                if(nodoEncontrado != nullptr){
                    std::cout << "Codigo de materia " << nodoEncontrado->dato << " encontrado en la direccion: " << nodoEncontrado << "\n";
                }else {
                    std::cout << "Codigo no encontrado.\n";
                }
                break;
            case '5':
                mostrarAscendente(cabecera);
                break;
            case '6':
                mostrarDescendente(cabecera);
                break;
            case '7':
                std::cout << "Saliendo del programa...\n";
                break;
            default:
                std::cout << "Seleccione una opcion valida.\n";
        }

    } while (opcion != '7');
    return 0;
}