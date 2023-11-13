package lab4.exceptions;

public class StackFullException extends RuntimeException {
    public StackFullException() {
        super("The stack is full!");
    }
}
