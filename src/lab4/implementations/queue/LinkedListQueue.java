package lab4.implementations.queue;

import lab4.interfaces.Queue;
import lab4.exceptions.QueueFullException;
import lab4.exceptions.QueueEmptyException;
import java.util.LinkedList;

public class LinkedListQueue<T> implements Queue<T> {
    private static final int CAPACITY = 5;
    private LinkedList<T> queue;

    public LinkedListQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public void enqueue(T element) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException();
        }
        queue.addLast(element);
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return queue.removeFirst();
    }

    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return queue.peekFirst();
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
