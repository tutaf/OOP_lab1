package lab4.implementations.queue;

import lab4.exceptions.QueueEmptyException;
import lab4.exceptions.QueueFullException;
import lab4.interfaces.Queue;

public class ArrayQueue<T> implements Queue<T> {
    private static final int CAPACITY = 5;
    private T[] queue;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public ArrayQueue() {
        queue = (T[]) new Object[CAPACITY];
    }

    @Override
    public void enqueue(T element) {
        if (isFull()) {
            throw new QueueFullException();
        }
        queue[rear] = element;
        rear = (rear + 1) % CAPACITY;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        T element = queue[front];
        queue[front] = null;
        front = (front + 1) % CAPACITY;
        size--;
        return element;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == CAPACITY;
    }
}