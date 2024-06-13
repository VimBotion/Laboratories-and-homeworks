/*
*   Campoverde Esteban, Apolo Juan
*   Arbol B de orden 4
*/
#include <iostream>
using namespace std;

// Un nodo del árbol B
struct NodoB
{
    // Array de claves de cada nodo
    int *claves; 
    // Grado mínimo (define el rango para el número de claves)
    int gradoMin;    
    // Array de puntos a los hijos
    NodoB **hijos;   
    // Numero actual de claves
    int numClaves;  
    // Es verdadero si el nodo es hoja. 
    bool hoja;       
};

// estructura del arbol
struct ArbolB
{
    // Puntero al nodo raíz
    NodoB *raiz;         // El grado es el numero de hijos que tiene el elemento con mas hijos dentro del arbol
    int gradoMin;    // Grado mínimo
};

NodoB *crearNodo(int gradoMin, bool hoja)
{
    NodoB *nodo = new NodoB;
    nodo->gradoMin = gradoMin;
    nodo->hoja = hoja;
    // 2*t - 1 = maximo numero de claves
    nodo->claves = new int[2 * gradoMin - 1];
    // 2*t = maximo numero de hijos
    nodo->hijos = new NodoB *[2 * gradoMin];
    nodo->numClaves = 0;
    return nodo;
}

ArbolB *crearArbol(int gradoMin)
{
    ArbolB *arbol = new ArbolB;
    arbol->raiz = NULL;
    arbol->gradoMin = gradoMin;
    return arbol;
}

void recorrerInorden(NodoB *nodo)
{
    if (nodo == NULL)
        return; 
    int i;
    for (i = 0; i < nodo->numClaves; i++)
    {
        // Si el nodo no es hoja, recorre sus hijos
        if (!nodo->hoja)             
        recorrerInorden(nodo->hijos[i]);
        cout << " " << nodo->claves[i]; 
    }

    if (!nodo->hoja) // Recorre el último hijo
        recorrerInorden(nodo->hijos[i]);
}

int encontrarClave(NodoB *nodo, int clave)
{
    int indice = 0;
    while (indice < nodo->numClaves && nodo->claves[indice] < clave)
        ++indice;
    return indice;
}

// Prototipos de funciones auxiliares
void insertarNoLleno(NodoB *nodo, int llave);
void dividirHijo(NodoB *nodo, int i, NodoB *nodoLleno);

void insertar(ArbolB *arbol, int clave)
{
    if (arbol->raiz == NULL)
    {
        // Si el árbol está vacío, crea la raíz
        arbol->raiz = crearNodo(arbol->gradoMin, true);
        arbol->raiz->claves[0] = clave;
        arbol->raiz->numClaves = 1;
    }
    else
    {
        // Division si esta lleno el nodo o la raiz 
        // 2t - 1
        if (arbol->raiz->numClaves == 2 * arbol->gradoMin - 1)
        {
            // s = nueva raiz del arbol o subarbol
            NodoB *s = crearNodo(arbol->gradoMin, false);
            // La raiz actual es el nuevo hijo
            s->hijos[0] = arbol->raiz;
            // divide el nodo lleno
            dividirHijo(s, 0, arbol->raiz);

            // Posicion de ingreso de los hijos de la nueva raiz de s
            int i = 0;
            // Nueva clave mayor que la primera clave de s, continuar a la derecha
            if (s->claves[0] < clave)
                i++;
            insertarNoLleno(s->hijos[i], clave);

            // Nueva raiz del arbol
            arbol->raiz = s;
        }
        else
        {
            // Insertar directamente si hay espcio en el arbol
            insertarNoLleno(arbol->raiz, clave);
        }
    }
}

void insertarNoLleno(NodoB *nodo, int llave)
{
    // Indice
    int i = nodo->numClaves - 1;

    if (nodo->hoja)
    {
        // Encuentra la posición para la nueva clave, recorriendo desde el fin hasta el inicio
        while (i >= 0 && nodo->claves[i] > llave)
        {
            // Orden las claves, moviendo las mayores a la derecha
            nodo->claves[i + 1] = nodo->claves[i];
            i--;
        }

        // Inserta la nueva clave en su posición correcta
        nodo->claves[i + 1] = llave;
        nodo->numClaves = nodo->numClaves + 1;
    }
    else
    {
        // Encuentra el hijo que tendra  nueva clave
        while (i >= 0 && nodo->claves[i] > llave)
            i--;

        // Dividir en caso de que este lleno
        if (nodo->hijos[i + 1]->numClaves == 2 * nodo->gradoMin - 1)
        {
            dividirHijo(nodo, i + 1, nodo->hijos[i + 1]);
            // Insertar en el hijo derecho
            if (nodo->claves[i + 1] < llave)
                i++;
        }
        insertarNoLleno(nodo->hijos[i + 1], llave);
    }
}

void dividirHijo(NodoB *nodo, int i, NodoB *nodoLleno)
{
    NodoB *nuevoNodo = crearNodo(nodoLleno->gradoMin, nodoLleno->hoja);
    nuevoNodo->numClaves = nodoLleno->gradoMin - 1;

    // Mover claves del nodo lleno al nodo minimo
    for (int j = 0; j < nodoLleno->gradoMin - 1; j++)
        nuevoNodo->claves[j] = nodoLleno->claves[j + nodoLleno->gradoMin];

    // Mover los hijos del nodoLleno al nuevo nodo
    if (!nodoLleno->hoja)
    {
        for (int j = 0; j < nodoLleno->gradoMin; j++)
            nuevoNodo->hijos[j] = nodoLleno->hijos[j + nodoLleno->gradoMin];
    }

    // Nuevo numero de claves del nodo lleno despues de moverlas al nodo nuevo
    nodoLleno->numClaves = nodoLleno->gradoMin - 1;

    // Cambiar los punteros del nodo padre para que apunten al nuevo nodo
    for (int j = nodo->numClaves; j >= i + 1; j--)
        // Desplazar a la derecha
        nodo->hijos[j + 1] = nodo->hijos[j];

    nodo->hijos[i + 1] = nuevoNodo;

// Ordenar claves
    for (int j = nodo->numClaves - 1; j >= i; j--)
        // Desplazar a la derecha
        nodo->claves[j + 1] = nodo->claves[j];

    // Insertar la clave en la posicion i    
    nodo->claves[i] = nodoLleno->claves[nodoLleno->gradoMin - 1];
    // Aumenta el numero de claves
    nodo->numClaves = nodo->numClaves + 1;
}

void eliminar(ArbolB *arbol, int llave);
void eliminar(NodoB *nodo, int llave);
void eliminarDeHoja(NodoB *nodo, int indice);
void eliminarDeNoHoja(NodoB *nodo, int indice);
int predecesor(NodoB *nodo, int indice);
int sucesor(NodoB *nodo, int indice);
void llenar(NodoB *nodo, int indice);
void pedirPrestadoDeAnterior(NodoB *nodo, int indice);
void pedirPrestadoDeSiguiente(NodoB *nodo, int indice);
void fusionar(NodoB *nodo, int indice);

// Función para eliminar una clave del árbol
void eliminar(ArbolB *arbol, int llave)
{
    // Arbol vavio
    if (!arbol->raiz)
    {
        cout << "El árbol está vacío\n";
        return;
    }

    // Funcion de eliminar nodo
    eliminar(arbol->raiz, llave);

    // Verificar si se elimino la ultima clave
    if (arbol->raiz->numClaves == 0)
    {
        NodoB *tmp = arbol->raiz;
        if (arbol->raiz->hoja) // Arbol vacio por que es hoja
            arbol->raiz = NULL;
        else
        // El primer hijo se convierte en la raiz
            arbol->raiz = arbol->raiz->hijos[0];

        delete tmp;
    }
}

// Función para eliminar una clave del nodo
void eliminar(NodoB *nodo, int llave)
{
    // Posicion de la clave
    int indice = encontrarClave(nodo, llave);

    // Clave en el nodo
    if (indice < nodo->numClaves && nodo->claves[indice] == llave)
   
    {
        // Nodo es una hoja
        if (nodo->hoja)
            eliminarDeHoja(nodo, indice);
        else
        // El nodo no es una hoja
            eliminarDeNoHoja(nodo, indice);
    }
    // Clave no en el nodo
    else
    {
        // Se esta en la hoja, por lo tanto no se puede bajar mas osea no hay 
        if (nodo->hoja)
        {
            cout << "La clave " << llave << " no existe en el árbol\n";
            return;
        }

        // Verificar clave en el ultimo hijo
        bool flag = ((indice == nodo->numClaves) ? true : false);

        // Verificar si se produce un desbalance de claves (menos del minimo)
        if (nodo->hijos[indice]->numClaves < nodo->gradoMin)
            // Concatenar para evitar el desbalance
            llenar(nodo, indice);

        if (flag && indice > nodo->numClaves)
            // Acceder al ultimo hijo
            eliminar(nodo->hijos[indice - 1], llave);
        else
            eliminar(nodo->hijos[indice], llave);
    }
}

// Función para eliminar una clave de un nodo hoja
void eliminarDeHoja(NodoB *nodo, int indice)
{
    for (int i = indice + 1; i < nodo->numClaves; ++i)
        // Desplazar las claves a la derecha de la posicion (indice) a la izquierda
        nodo->claves[i - 1] = nodo->claves[i];

    nodo->numClaves--;
}

// Función para eliminar una clave de un nodo que no es hoja
void eliminarDeNoHoja(NodoB *nodo, int indice)
{
    // Llame a eliminar
    int llave = nodo->claves[indice];

    // No se produce insuficiencia por parte del hijo izquierdo
    if (nodo->hijos[indice]->numClaves >= nodo->gradoMin)
    {
        int pred = predecesor(nodo, indice);
        // Sustituir la clave a eliminar por el predecesor
        nodo->claves[indice] = pred;
        // Eliminar el predecesor
        eliminar(nodo->hijos[indice], pred);
    }
    // No se produce insuficiente por parte del hijo derecho
    else if (nodo->hijos[indice + 1]->numClaves >= nodo->gradoMin)
    {
        int succ = sucesor(nodo, indice);
        // Sustituir la clave a eliminar por el sucesor
        nodo->claves[indice] = succ;
        // Eliminar el sucesor
        eliminar(nodo->hijos[indice + 1], succ);
    }
    // Los hermanos, hijo izquierdo, hijo derecho, no tienen el minimo numero de claves
    else
    {
        // concatenar ambos hijos
        fusionar(nodo, indice);
        // eliminar la clave porque se combinan
        eliminar(nodo->hijos[indice], llave);
    }
}

int predecesor(NodoB *nodo, int indice)
{
    // Posicion actual por el hijo izquierdo
    NodoB *cur = nodo->hijos[indice];
    // Mover hasta llegar a una hoja
    while (!cur->hoja)
        // Mueve a la derecha
        cur = cur->hijos[cur->numClaves];
    // Se devuelve el predecesor
    return cur->claves[cur->numClaves - 1];
}

int sucesor(NodoB *nodo, int indice)
{
    // Posicion actual por el hijo derecho
    NodoB *cur = nodo->hijos[indice + 1];
    // Mover hasta llegar a una hoja
    while (!cur->hoja)
    // Mover al hijo mas a la izquierda
        cur = cur->hijos[0];
    // sucesor = elemento mas a la izquierdo del arbol derecho
    return cur->claves[0];
}

// Función para llenar el nodo hijo que tiene menos del minimo
void llenar(NodoB *nodo, int indice)
{
    // Indice no es igual a 0 y el hijo anterior tiene el minimo requerido
    if (indice != 0 && nodo->hijos[indice - 1]->numClaves >= nodo->gradoMin)
        pedirPrestadoDeAnterior(nodo, indice);
    // Indice es diferente del total de claves y el hijo siguiente tiene el minimo requerido
    else if (indice != nodo->numClaves && nodo->hijos[indice + 1]->numClaves >= nodo->gradoMin)
        pedirPrestadoDeSiguiente(nodo, indice);
    else
    {
        // si no se puede pedir a los hermanos, concatenar con la raiz
        if (indice != nodo->numClaves)
            fusionar(nodo, indice);
        else
            fusionar(nodo, indice - 1);
    }
}

void pedirPrestadoDeAnterior(NodoB *nodo, int indice)
{
    // Hijo y hermano izquierdo
    NodoB *hijo = nodo->hijos[indice];
    NodoB *hermano = nodo->hijos[indice - 1];

    for (int i = hijo->numClaves - 1; i >= 0; --i)
        // Desplazar a la derecha para hacer espacio a la nueva clave a prestar
        hijo->claves[i + 1] = hijo->claves[i];

    if (!hijo->hoja)
    {
        // Si no es hoja, se desplazan los hijos a la derecha
        for (int i = hijo->numClaves; i >= 0; --i)
            hijo->hijos[i + 1] = hijo->hijos[i];
    }

    // Copia la clave del nodo actual al hijo
    hijo->claves[0] = nodo->claves[indice - 1];

    // El primer hijo apunta al ultimo hijo del hermano
    if (!hijo->hoja)
        hijo->hijos[0] = hermano->hijos[hermano->numClaves];

    // Se actualiza la clave con la clave a la derecha del hermano
    nodo->claves[indice - 1] = hermano->claves[hermano->numClaves - 1];


    // se incrementa el contador en las claves del hijo porque se aumento
    hijo->numClaves += 1;
    // Se decrementa el contador en las claves del hermano izquierdo porque se quito
    hermano->numClaves -= 1;
}

void pedirPrestadoDeSiguiente(NodoB *nodo, int indice)
{
    //  Hijo y hermano derecho
    NodoB *hijo = nodo->hijos[indice];
    NodoB *hermano = nodo->hijos[indice + 1];

    // Copia la clave del nodo actual al final del hijo
    hijo->claves[(hijo->numClaves)] = nodo->claves[indice];

    if (!(hijo->hoja))
        // El ultimo hijo apunte al primer hijo del hermano
        hijo->hijos[(hijo->numClaves) + 1] = hermano->hijos[0];

    // Actualiza la clave del nodo actual
    nodo->claves[indice] = hermano->claves[0];

    for (int i = 1; i < hermano->numClaves; ++i)
        // Se desplaza una posicion a la izquierda para llenar el espacio dejado
        hermano->claves[i - 1] = hermano->claves[i];

    if (!hermano->hoja)
    {
        //  Se desplaza los hijos a la izquierda
        for (int i = 1; i <= hermano->numClaves; ++i)
            hermano->hijos[i - 1] = hermano->hijos[i];
    }

    // Se incremente el contador en las claves del hijo porque aumento
    hijo->numClaves += 1;
    // Se decrementa el contador en las claves del hermano derecho porque se quito
    hermano->numClaves -= 1;
}

// Se fusiona el nodo hijo con el hermano derecho
void fusionar(NodoB *nodo, int indice)
{
    // Nodo y hermano derecho
    NodoB *hijo = nodo->hijos[indice];
    NodoB *hermano = nodo->hijos[indice + 1];

    // Mover la clave del nodo actual al hijo
    hijo->claves[nodo->gradoMin - 1] = nodo->claves[indice];

    // Mover las claves del hermano al hijo de la posicion nodo->gradoMin concatenando las claves del hermano al final
    for (int i = 0; i < hermano->numClaves; ++i)
        hijo->claves[i + nodo->gradoMin] = hermano->claves[i];

    if (!hijo->hoja)
    {
        for (int i = 0; i <= hermano->numClaves; ++i)
        // Transferir los hijos del hermano al hijo para ajustarlos
            hijo->hijos[i + nodo->gradoMin] = hermano->hijos[i];
    }

    // Desplazar claves hacia la izquierda eliminando la clave transferida
    for (int i = indice + 1; i < nodo->numClaves; ++i)
        nodo->claves[i - 1] = nodo->claves[i];

    // Desplazar los hijos hacia la izquierda para ajustarlos
    for (int i = indice + 2; i <= nodo->numClaves; ++i)
        nodo->hijos[i - 1] = nodo->hijos[i];

    // Se actualiza el numero de claves del hijo con las claves que se anadieron del hermano mas la clave transferida de la
    // raiz del arbol o subarbol
    hijo->numClaves += hermano->numClaves + 1;
    // Se disminuye el numero de claves dentro de la raiz (nodo) del arbol o subarbol
    nodo->numClaves--;

    // Se borra la pagina derecha
    delete(hermano);
}

int main()
{
    char opcion;
    ArbolB* arbol = crearArbol(4);
    do{
        cout << "\t\nMenu\n";
        cout << "1. Insertar llave de tipo numerico\n";
        cout << "2. Eliminar llave\n";
        cout << "3. Recorrer arbol en INORDEN\n";
        cout << "4. Salir\n";
        cout << "Elija una opcion\n";
        cin >> opcion;

        switch(opcion){
            case '1':
                int llave;
                do{
                    cout << "Inserte una llave:\n";
                    cin >> llave;
                }while(llave < 0);
                insertar(arbol, llave);
                break;
            case '2':
                int llaveEliminar;
                do{
                    cout << "Inserte una llave:\n";
                    cin >> llaveEliminar;
                }while(llaveEliminar < 0);
                eliminar(arbol, llaveEliminar);
                break;
            case '3':
                recorrerInorden(arbol->raiz);
                break;
            case '4':
                cout << "Fin del programa\n";
                break;
            default:
                cout << "Opcion invalida\n";
        }
    }while(opcion != '4');
    return 0;
}
