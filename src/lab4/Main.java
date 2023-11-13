package lab4;

import lab4.implementations.stack.ArrayListStack;
import lab4.implementations.stack.ArrayStack;
import lab4.implementations.stack.LinkedListStack;
import lab4.interfaces.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayListStack<>();
        stack.push(1);
        stack.push(3);
        stack.push(8);
        stack.pop();
        stack.push(8);
        stack.push(2);
        stack.push(0);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
