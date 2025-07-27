package test;

import D0725.MinStack;

public class MinStackTest {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());// -3
        minStack.pop();
        System.out.println(minStack.top());//0
        System.out.println(minStack.getMin());//-2
        minStack.push(-4);
        System.out.println(minStack.getMin());//-4
        minStack.pop();
        System.out.println(minStack.getMin());// -2
        minStack.pop();
        System.out.println(minStack.getMin());//0
    }
}
