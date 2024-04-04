#include <iostream>

struct Nodo {
    int dato;
    Nodo* next;
};

void insertar(Nodo*& head, int dato) {
    Nodo* nuevo = (Nodo *)malloc(sizeof(Nodo));
    nuevo->dato = dato;
    nuevo->next = nullptr;

    if (head == nullptr) {
        head = nuevo;
    } else {
        Nodo* temp = head;
        while (temp->next != nullptr) {
            temp = temp->next;
        }
        temp->next = nuevo;
    }
}

void imprimir(Nodo* head) {
    Nodo* temp = head;
    while (temp != nullptr) {
        std::cout << temp->dato << " ";
        std::cout << "Siguiente direccion " << temp->next << " ";
        std::cout << '\n';
        temp = temp->next;
    }
    std::cout << std::endl;
}

int main() {
    Nodo* head = nullptr;

    insertar(head, 1);
    insertar(head, 2);
    insertar(head, 3);
    insertar(head, 4);
    insertar(head, 5);
    std::cout << "Linked List: \n";
    imprimir(head);

    return 0;
}
