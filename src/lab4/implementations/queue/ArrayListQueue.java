package lab4.implementations.queue;

import lab4.interfaces.Queue;
import lab4.exceptions.QueueFullException;
import lab4.exceptions.QueueEmptyException;
import java.util.ArrayList;

public class ArrayListQueue<T> implements Queue<T> {
    private static final int CAPACITY = 5;
    private ArrayList<T> queue;

    public ArrayListQueue() {
        queue = new ArrayList<>(CAPACITY);
    }

    @Override
    public void enqueue(T element) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException();
        }
        queue.add(element);
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return queue.remove(0);
    }

    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return queue.get(0);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return queue.size() == CAPACITY;
    }
}
