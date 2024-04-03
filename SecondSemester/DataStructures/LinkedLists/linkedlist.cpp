#include <iostream>

// Define a struct for the nodes of the linked list
struct Node {
    int data;
    Node* next;
};

// Function to insert a node at the end of the linked list
void insert(Node*& head, int data) {
    Node* newNode = (Node *)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = nullptr;

    if (head == nullptr) {
        head = newNode;
    } else {
        Node* temp = head;
        while (temp->next != nullptr) {
            temp = temp->next;
        }
        temp->next = newNode;
    }
}

// Function to print the linked list
void printList(Node* head) {
    Node* temp = head;
    while (temp != nullptr) {
        std::cout << temp->data << " ";
        std::cout << "Siguiente direccion " << temp->next << " ";
        std::cout << '\n';
        temp = temp->next;
    }
    std::cout << std::endl;
}

// Function to delete the entire linked list
void deleteList(Node*& head) {
    while (head != nullptr) {
        Node* temp = head;
        head = head->next;
        delete temp;
    }
}

int main() {
    Node* head = nullptr;

    // Insert some elements into the linked list
    insert(head, 1);
    insert(head, 2);
    insert(head, 3);
    insert(head, 4);
    insert(head, 5);

    // Print the linked list
    std::cout << "Linked List: \n";
    printList(head);

    // Delete the linked list
    deleteList(head);

    return 0;
}
