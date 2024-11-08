package queue_DL;


import exceptions.EmptyException;
import exceptions.FullException;
import listas.DLnkedList;
import nodo.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue_DL<T> implements IQueue<T>, Iterable<T> {
    private DLnkedList<T> _queue;
    private int _size;
    private final static int SIZE = 10;

    public Queue_DL() {
        this(SIZE);
    }

    public Queue_DL(int size) {
        _queue = new DLnkedList<>();
        _size = size <= 0 ? SIZE : size;
    }

    @Override
    public T dequeue() throws EmptyException {
        try {
            isEmpty();
            // Obtener el primer elemento
            Node<T> firstNode = _queue.getRoot().getRight();
            T element = firstNode.getElement();
            _queue.remove(element);
            return element;
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean queue(T elemento) throws FullException {
        try {
            isFull();
            _queue.add(elemento);
            return true;
        } catch (FullException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removeAll() throws EmptyException {
        try {
            isEmpty();
            while (_queue.Length() > 0) {
                T element = _queue.getRoot().getRight().getElement();
                _queue.remove(element);
            }
            return true;
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean isEmpty() throws EmptyException {
        if (_queue.Length() == 0) {
            throw new EmptyException("La cola está vacía");
        }
        return false;
    }

    @Override
    public boolean isFull() throws FullException {
        if (_queue.Length() >= _size) {
            throw new FullException("La cola está llena");
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<T> iterator = _queue.Right();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        for (T value : this) {
            cadena.append(value).append(" ");
        }
        return "Queue [ " + cadena + " ]";
    }
}

