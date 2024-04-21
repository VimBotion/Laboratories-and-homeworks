#include <iostream>

struct Nodo {
  int dato;
  Nodo *izquierda;
  Nodo *derecha;
};

Nodo *crearNodo(int valor) {
  Nodo *newNode = new Nodo;
  newNode->dato = valor;
  newNode->izquierda = nullptr;
  newNode->derecha = nullptr;
  return newNode;
}

void insertar(Nodo *cabeza, int valor) {
  if (cabeza == nullptr) {
    crearNodo(valor);
  }

  if (valor < cabeza->dato) {
    insertar(cabeza->izquierda, valor);
  }

  if (valor > cabeza->dato) {
    insertar(cabeza->derecha, valor);
  }
}

void inOrden(Nodo *cabeza) {
  if (cabeza == nullptr) {
    std::cout << cabeza->dato << '\n';
  }

  inOrden(cabeza->izquierda);
  inOrden(cabeza->derecha);
}

int main() {
  Nodo *root = nullptr;
  insertar(root, 5);
  insertar(root, 8);
  insertar(root, 1);
  insertar(root, 10);
  insertar(root, 4);
  insertar(root, 51);

  // inOrden(root);
  delete root;

  return 0;
}
