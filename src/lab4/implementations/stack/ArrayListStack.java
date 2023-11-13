package lab4.implementations.stack;

import lab4.exceptions.StackEmptyException;
import lab4.exceptions.StackFullException;
import lab4.interfaces.Stack;

import java.util.ArrayList;

public class ArrayListStack<T> implements Stack<T> {
    private ArrayList<T> list;
    private static final int CAPACITY = 5;

    public ArrayListStack() {
        list = new ArrayList<>(CAPACITY);
    }

    @Override
    public void push(T element) {
        if (isFull()) {
            throw new StackFullException();
        }
        list.add(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return list.remove(list.size() - 1);
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return list.get(list.size() - 1);
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

