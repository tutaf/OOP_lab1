package lab4;

import lab4.implementations.queue.ArrayListQueue;
import lab4.implementations.queue.ArrayQueue;
import lab4.implementations.queue.LinkedListQueue;
import lab4.implementations.stack.ArrayListStack;
import lab4.implementations.stack.ArrayStack;
import lab4.implementations.stack.LinkedListStack;
import lab4.interfaces.Queue;
import lab4.interfaces.Stack;

public class Main {
    public static void main(String[] args) {
//        Stack<Integer> stack = new ArrayListStack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.pop();
//        stack.push(4);
//        stack.push(5);
//        stack.push(6);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        Queue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());


    }
}
