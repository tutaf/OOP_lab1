package lab4.exceptions;

public class StackEmptyException extends RuntimeException {
    public StackEmptyException() {
        super("The stack is empty!");
    }
}
