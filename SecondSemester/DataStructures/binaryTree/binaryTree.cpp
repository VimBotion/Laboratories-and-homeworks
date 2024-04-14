#include <iostream>

struct Nodo {
    int dato;
    Nodo* izquierda;
    Nodo* right;
};

Nodo* crearNodo(int valor) {
    Nodo* newNode = new Nodo;
    newNode->dato = valor;
    newNode->izquierda = nullptr;
    newNode->right = nullptr;
    return newNode;
}

Nodo* insertarNodo(Nodo* root, int valor) {
    if (root == nullptr) {
        return crearNodo(valor);
    }

    if (valor < root->dato) {
        root->izquierda = insertarNodo(root->izquierda, valor);
    } else if (valor > root->dato) {
        root->right = insertarNodo(root->right, valor);
    }

    return root;
}

int main() {
    Nodo* root = nullptr;

    root = insertarNodo(root, 5);
    insertarNodo(root, 3);
    insertarNodo(root, 7);
    insertarNodo(root, 1);
    insertarNodo(root, 4);
    insertarNodo(root, 6);
    insertarNodo(root, 8);

    delete root;

    return 0;
}
