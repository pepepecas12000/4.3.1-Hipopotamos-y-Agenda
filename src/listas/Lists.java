package listas;

import nodo.Node;

import java.util.NoSuchElementException;

public interface Lists<T> {
   boolean IsEmpty()throws NoSuchElementException;
   Node<T> getLastElement();
    //getPrevElement: Retornara el elemento previo al que estamos buscando
    Node<T> getPrevElement(T element);
   // getElement: Retornara el elemento que estamos buscando
    long getElement(T element);
   // getElementAt: retornara el elemento que se encuentra en la posición x de la lista
   T getElementAt(long index);

    //isThere: Método que devuelve un valor si se encuentra o no un valor en la lista
   boolean isThere(T element);

    //add: Método que agrega un elemento en la lista
   void add(Node<T> node);
   void add(T element);

    //remove: elemento que elimina un elemento de la lista
    void remove(Node<T> node);
    void remove(T element);
    //AddAt: Método que agrega un elemento en una posición determinada de la lista.
 void addAt(long index, Node<T> node);
 void addAt(long index, T element);

    //addAfter: Método que agrega un valor enseguida de un valor especificado
    void addAfter(long index, Node<T> node);
    void addAfter(long index, T element);

    //addBefore: Método que agrega un valor antes de un valor especificado.
    void addBefore(long index, Node<T> node);
    void addBefore(long index, T element);

    //removeAfter: Método que borra un valor después de un elemento especifico
    void removeAfter(long index, Node<T> node);
    void removeAfter(long index, T element);

    //removeBefore: Método que borra un valor antes de un elemento especifico.
    void removeBefore(long index, Node<T> node);
    void removeBefore(long index, T element);

    //addStart: Método que agrega un elemento al inicio de la lista.
    void addStart(Node<T> node);
    void addStart(T element);

    //Length: Método que retorna la cantidad de nodos en la lista, puede ser un getter
long Length();
    //removeAll: Método que elimina todos los elementos iguales de una lista.
void removeAll(Node<T> node);
void removeAll(T element);
    //toString: Método que convierte la lista a una cadena.


}
