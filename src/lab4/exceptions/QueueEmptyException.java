package lab4.exceptions;

public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException() {
        super("The queue is empty!");
    }
}
