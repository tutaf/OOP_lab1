package lab4.implementations.stack;

import lab4.exceptions.StackEmptyException;
import lab4.exceptions.StackFullException;
import lab4.interfaces.Stack;

public class ArrayStack<T> implements Stack<T> {
    private static final int CAPACITY = 5;
    private T[] array;
    private int top = -1;

    public ArrayStack() {
        array = (T[]) new Object[CAPACITY];
    }

    @Override
    public void push(T element) throws StackFullException {
        if (isFull()) {
            throw new StackFullException();
        }
        array[++top] = element;
    }

    @Override
    public T pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        T element = array[top];
        array[top] = null;
        top--;
        return element;
    }

    @Override
    public T top() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException();
        }
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public boolean isFull() {
        return (top == CAPACITY-1);
    }
}

