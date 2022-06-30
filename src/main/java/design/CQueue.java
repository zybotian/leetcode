package design;

import java.util.Stack;

class CQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public CQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        if (!popStack.isEmpty()) {
            return popStack.pop();
        }
        return -1;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */