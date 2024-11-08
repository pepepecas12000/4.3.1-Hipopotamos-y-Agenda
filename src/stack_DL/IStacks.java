package stack_DL;

import exceptions.EmptyException;
import exceptions.FullException;
import listas.DLnkedList;

import java.util.Iterator;

public interface IStacks<T>{
     boolean isEmpty() throws EmptyException;
     boolean isFull() throws FullException;


     boolean push(T element) throws FullException;

     T pop() throws EmptyException;
     T peek() throws EmptyException;
     int search(T element) throws EmptyException;


}
