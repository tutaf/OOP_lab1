package lab4.interfaces;

public interface Queue<T> {
    void enqueue(T element);
    T dequeue();
    T front();
    boolean isEmpty();
    boolean isFull();
}