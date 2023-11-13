package lab4.interfaces;

public interface Stack<T> {
    void push(T element);
    T pop();
    T top();
    boolean isEmpty();
    boolean isFull();
}

