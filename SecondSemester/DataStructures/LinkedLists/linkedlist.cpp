#include <iostream>

struct Nodo {
    int data;
    Nodo* next;
};

Nodo* crearNodo(int value) {
    Nodo* nuevoNodo = new Nodo;
    nuevoNodo->data = value;
    nuevoNodo->next = nullptr;
    return nuevoNodo;
}

Nodo* insertarInicio(Nodo* head, int value) {
    Nodo* nuevoNodo = crearNodo(value);
    nuevoNodo->next = head;
    return nuevoNodo;
}

void printList(Nodo* head) {
    Nodo* current = head;
    while (current != nullptr) {
        std::cout << current->data << " ";
        current = current->next;
    }
    std::cout << std::endl;
}

int main() {
    Nodo* head = nullptr;

    head = insertarInicio(head, 10);
    head = insertarInicio(head, 2);
    head = insertarInicio(head, 4);

    std::cout << "Linked list despues de insertar: ";
    printList(head);

    while (head != nullptr) {
        Nodo* temp = head;
        head = head->next;
        delete temp;
    }

    return 0;
}
