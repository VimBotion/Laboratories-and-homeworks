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

void Mostrar(){
  nodo *actual;
  actual=cabecera;
  
  while (actual!=NULL)
  {
  	cout << actual->dato << endl;
  	actual=actual->siguiente;
  } 	
}

int main() {
   cabecera=NULL;
   InsertarFinal(5);
   InsertarFinal(9);
   InsertarFinal(12);
   Mostrar();
   
   return 0;
}