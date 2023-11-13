package lab4.implementations.stack;

import lab4.exceptions.StackEmptyException;
import lab4.exceptions.StackFullException;
import lab4.interfaces.Stack;

import java.util.LinkedList;


public class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> list = new LinkedList<>();
    private static final int CAPACITY = 5;

    @Override
    public void push(T element) {
        if (isFull()) {
            throw new StackFullException();
        }
        list.addFirst(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return list.removeFirst();
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return list.size() == CAPACITY;
    }
}
