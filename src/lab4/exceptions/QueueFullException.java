package lab4.exceptions;

public class QueueFullException extends RuntimeException {
    public QueueFullException() {
        super("The queue is full!");
    }
}
