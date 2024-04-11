#include <iostream>
#include <stdlib.h>
using namespace std;

struct nodo {
   int dato;
   nodo *siguiente;
};

nodo *cabecera;

void InsertarFinal(int valor) {
   nodo *nuevo;
   nuevo=(nodo *)malloc(sizeof(nodo));
   nuevo->dato=valor;
   nuevo->siguiente=NULL;

   nodo *ultimo;
   ultimo = cabecera;
   
   if (cabecera == NULL)
   {
    cabecera=nuevo;
   }
   else
   {
    while (ultimo->siguiente!=NULL)
    {
     ultimo=ultimo->siguiente;  
    }  
    ultimo->siguiente = nuevo;
   }
}

void InsertarInicio(int valor){
   nodo *nuevo;
   nuevo=(nodo *)malloc(sizeof(nodo));
   nuevo->dato = valor;
   nuevo->siguiente = cabecera;
   cabecera = nuevo; 
}

void Mostrar(){
  nodo *actual;
  actual=cabecera;
  
  while (actual!=NULL)
  {
  	cout << actual->dato << endl;
  	actual=actual->siguiente;
  } 	
}

void EliminarFinal(){
   if(cabecera == NULL){
      std::cout << "La lista esta vacia\n";
   }
   else {
      nodo* ultimo = cabecera;
      nodo* penultimo = nullptr;
      while(ultimo->siguiente != nullptr){
         penultimo = ultimo;
         ultimo = ultimo->siguiente;
      }
      penultimo->siguiente = nullptr;
      free(ultimo);
   }
}

void EliminarInicio(){
   if(cabecera == NULL){
      std::cout << "La lista esta vacia\n";
   }
   else {
      nodo* siguiente = (nodo *)malloc(sizeof(nodo));
      siguiente = cabecera;
      cabecera = cabecera->siguiente;
      free(siguiente);
   }
}

int main() {
   cabecera=NULL;
   InsertarFinal(5);
   InsertarFinal(9);
   InsertarFinal(12);
   std::cout << "La lista antes de insertar al inicio\n";
   Mostrar();
   std::cout << "La lista despues de insertar al inicio\n";
   InsertarInicio(1);
   Mostrar();
   std::cout << "La lista despues de eliminar el primer valor\n";
   EliminarInicio();
   Mostrar(); 
   std::cout << "La lista despues de eliminar el ultimo valor \n";
   EliminarFinal();
   Mostrar();
   return 0;
}