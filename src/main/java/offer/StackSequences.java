package offer;

import java.util.LinkedList;
import java.util.Stack;

public class StackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed != null && popped != null && pushed.length == 0 && popped.length == 0) {
            return true;
        }

        if (popped == null || popped.length == 0 || pushed == null || pushed.length == 0) {
            return false;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.addFirst(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pollFirst();
                index++;
            }
        }

        return stack.isEmpty();
    }
}
