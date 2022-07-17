package offer;

import java.util.LinkedList;

class MaxQueue {

    private LinkedList<Integer> data;
    private LinkedList<Integer> max;

    public MaxQueue() {
        data = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (max.isEmpty()) {
            return -1;
        }

        return max.peekFirst();
    }

    public void push_back(int value) {
        data.addLast(value);
        while (!max.isEmpty() && max.peekLast() < value) {
            max.removeLast();
        }
        max.addLast(value);
    }

    public int pop_front() {
        if (data.isEmpty()) {
            return -1;
        }

        int result = data.pollFirst();
        if (result == max.peekFirst()) {
            max.pollFirst();
        }
        return result;
    }
}