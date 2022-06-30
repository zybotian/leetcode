package design;

import java.util.Stack;

class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int lastMin = minStack.peek();
            if (x < lastMin) {
                minStack.push(x);
            } else {
                minStack.push(lastMin);
            }
        }
    }

    public void pop() {
        if (!dataStack.isEmpty()) {
            dataStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (dataStack.isEmpty()) {
            return -1;
        }
        return dataStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}