package lab4.implementations.queue;

import lab4.interfaces.Queue;
import lab4.exceptions.QueueFullException;
import lab4.exceptions.QueueEmptyException;

public class LinkedListQueue<T> implements Queue<T> {
    private static final int CAPACITY = 5;
    private Node front, rear;
    private int size;

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    @Override
    public void enqueue(T element) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException();
        }
        Node newNode = new Node(element);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        return size == CAPACITY;
    }
}
