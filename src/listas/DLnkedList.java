package listas;

import nodo.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLnkedList <T> implements Lists<T> {
    private Node<T> root;
    private Node<T> tail;
    private long index;

    public DLnkedList(Node<T> node) {
        this.root = new Node<>();
        this.tail = new Node<>();
        this.index = 0;
        if (node != null) {
            root.setRight(node);
            tail.setLeft(node);
            index++;
        }

    }

    public DLnkedList(DLnkedList<T> set) {
        this.root = new Node<>();
        if (set.root.getRight() != null) {
            Iterator<T> iterator = set.Right();
            if (iterator.hasNext()) {
                Node<T> _new = new Node<>(iterator.next());
                this.root.setRight(_new);
                Node<T> newTail = _new;

                while (iterator.hasNext()) {
                    Node<T> newNode = new Node<>(iterator.next());
                    newTail.setRight(newNode);
                    newNode.setLeft(newTail);
                    newTail = newNode;
                }

                this.tail = newTail;
                this.index = set.index;
            }
        } else {
            this.tail = new Node<>();
            this.index = 0;
        }
    }


    public DLnkedList() {
        this((Node<T>) null);
    }

    public DLnkedList(T element) {

        this(new Node<T>(element));
    }

    @Override
    public boolean IsEmpty() throws NoSuchElementException {

        if (root.getRight() == null && tail.getLeft() == null) {
            throw new NoSuchElementException("La lista esta vacia");
        }
        return false;
    }


    @Override
    public Node<T> getLastElement() {

        return getLastElement(root);
    }

    private Node<T> getLastElement(Node<T> head) {
        if (head.getRight() == null)
            return head;
        return getLastElement(head.getRight());
    }


    public Node<T> getPrevElement(T elemento) {
        Node<T> prev = null;
        if (elemento != null) {

            try {
                IsEmpty();
                prev = getPrevElement(root, elemento);

            } catch (Exception e) {
                System.out.println("No jalo");
            }

        }
        return prev;
    }

    private Node<T> getPrevElement(Node<T> root, T element) {
        if (root.getRight() == null) return null;


        if (root.getRight().getElement().equals(element)) {
            return root;
        }

        return getPrevElement(root.getRight(), element);
    }

    @Override
    public long getElement(T element) {
        return 0;
    }

    @Override
    public T getElementAt(long index) {
        return null;
    }

    @Override
    public boolean isThere(T element) {
        return false;
    }

    @Override
    public void add(Node<T> node) {

        if (node != null) {
            if (node.getElement() != null) {
                add(node.getElement());
            }
        }

    }

    @Override
    public void add(T element) {
        Node<T> _new = new Node<>(element);
        try {
            IsEmpty();
            Node<T> tmp = getLastElement();
            tmp.setRight(_new);
            _new.setLeft(tmp);
            tail.setLeft(_new);
        } catch (NoSuchElementException e) {
            root.setRight(_new);
            tail.setLeft(_new);
        } finally {
            index++;
        }

    }

    @Override
    public void remove(Node<T> node) {
    if (node != null) {
        if (node.getElement() != null) {
            remove(node.getElement());
        }
    }

    }

    @Override
    public void remove(T element) {
    try{
        IsEmpty();
        Node<T> tmp = getPrevElement(element);
        if (tmp!=null){
            if(tmp.getRight().getLeft() == null){
            Node<T> next = tmp.getRight().getRight();
                tmp.setRight(next);
            if (next!=null){
                next.setLeft(null);
            }else {
                tail.setLeft(next);
            }
            root.setRight(next);

            }else{


                if (tmp.getRight().getRight() == null){
                    tail.setLeft(tmp);
                    tmp.setRight(null);
                }else {
                    Node<T> last = tmp.getRight().getRight();
                    tmp.setRight(tmp.getRight().getRight());
                    last.setLeft(tmp);
                }
            }


        }
    }catch (NoSuchElementException e){
        System.out.printf(" %s ",e.getMessage());
    }
    index--;
    System.gc();
    }

    @Override
    public void addAt(long index, Node<T> node) {

    }

    @Override
    public void addAt(long index, T element) {

    }

    @Override
    public void addAfter(long index, Node<T> node) {

    }

    @Override
    public void addAfter(long index, T element) {

    }

    @Override
    public void addBefore(long index, Node<T> node) {
        if (node != null) {
            if (node.getElement() != null) {
                addBefore(index,node.getElement());
            }
        }
    }

    @Override
    public void addBefore(long index, T element) {
        if (index >this.index) {

            throw new NoSuchElementException("No hay suficientes elementos");
        }
        if (this.index == 0) {
            this.add(element);

        }else {

    Node<T> _new =root.getRight();
            Node<T> tmp = new Node<>(element);
        for (int i = 0; i < index; i++) {
            _new = _new.getRight();
        }
        
            tmp.setRight(_new);
            tmp.setLeft(_new.getLeft());

            if (_new.getLeft() != null) {
                _new.getLeft().setRight(tmp);
            }
        _new.setLeft(tmp);
            if (index == 0) {
                root.setRight(tmp);
            }
        this.index++;
    }

    }

    @Override
    public void removeAfter(long index, Node<T> node) {

    }

    @Override
    public void removeAfter(long index, T element) {

    }

    @Override
    public void removeBefore(long index, Node<T> node) {

    }

    @Override
    public void removeBefore(long index, T element) {

    }

    @Override
    public void addStart(Node<T> node) {

    }

    @Override
    public void addStart(T element) {

    }

    @Override
    public long Length() {
        return index;
    }

    @Override
    public void removeAll(Node<T> node) {

    }

    @Override
    public void removeAll(T element) {

    }

    public Iterator<T> left() {
        return new Iterator<T>() {
            Node<T> cpy = tail.getLeft(), sub;

            @Override
            public boolean hasNext() {
                if (cpy == null) {
                    return false;
                } else {
                    sub = cpy;
                    cpy = cpy.getLeft();
                    return true;
                }

            }

            @Override
            public T next() {
                return sub.getElement();
            }
        };
    }
    public Iterator<T> Right() {
        return new Iterator<T>() {
            Node<T> cpy = root.getRight(), sub;

            @Override
            public boolean hasNext() {
                if (cpy == null) {
                    return false;
                } else {
                    sub = cpy;
                    cpy = cpy.getRight();
                    return true;
                }

            }


            @Override
            public T next() {
                return sub.getElement();
            }
        };
    }

    public Node<T> getRoot() {
        return root;
    }
}