package lab4;

import lab4.implementations.stack.ArrayStack;
import lab4.interfaces.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<Integer>();
        stack.push(1);
        stack.push(3);
        stack.push(8);
        stack.push(8);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
