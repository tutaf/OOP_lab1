package lab4.interfaces;

import lab4.exceptions.StackEmptyException;
import lab4.exceptions.StackFullException;

public interface Stack<T> {
    void push(T element) throws StackFullException;
    T pop() throws StackEmptyException;
    T top() throws StackEmptyException;
    boolean isEmpty();
    boolean isFull();
}

