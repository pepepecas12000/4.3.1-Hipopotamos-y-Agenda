package stack_DL;

import exceptions.EmptyException;
import exceptions.FullException;
import listas.DLnkedList;
import nodo.Node;

import java.util.Arrays;
import java.util.Iterator;

public class Stack_DL<T> implements IStacks<T>, Iterable<T> {

        private DLnkedList<T> _stack;
        private int _top;
        private int _size;
        private static final int SIZE = 10;

        public Stack_DL() {
            this(SIZE);
        }

        public Stack_DL(int size) {
            _stack = new DLnkedList<>();
            _size = size <= 0 ? SIZE : size;
            _top = -1;
        }
    public Stack_DL(Stack_DL<T> stack) {
        _stack = new DLnkedList<>(stack.get_stack());
        _size = stack._size;
        _top = stack._top;
    }



        @Override
        public boolean isEmpty() throws EmptyException {
            if (_top == -1) {
                return true;
            }
            return false;
        }

        @Override
        public boolean isFull() throws FullException {
            if (_top == _size - 1) {
                throw new FullException("La pila está llena");
            }
            return false;
        }

        @Override
        public boolean push(T element) throws FullException {
            try {
                isFull();
                _stack.add(element);
                _top++;
                return true;
            } catch (FullException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }

        @Override
        public T pop() throws EmptyException {
            try {
                isEmpty();
                T element = _stack.getLastElement().getElement();
                _stack.remove(element);
                _top--;
                return element;
            } catch (EmptyException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

        @Override
        public T peek() throws EmptyException {
            try {
                isEmpty();
                return _stack.getLastElement().getElement();
            } catch (EmptyException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

        @Override
        public int search(T element) throws EmptyException {
            int count = 0;
            try {
                isEmpty();
                for (T value : this) {
                    if (value.equals(element)) {
                        return count;
                    }
                    count++;
                }
            } catch (EmptyException e) {
                System.out.println(e.getMessage());
            }
            return -1;
        }




    public DLnkedList<T> get_stack() {
        return _stack;
    }



    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
