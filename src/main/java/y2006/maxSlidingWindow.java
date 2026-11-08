package y2006;

import java.util.*;

public class maxSlidingWindow {
    public static void main(String[] args) {
        maxSlidingWindow maxSlidingWindow = new maxSlidingWindow();
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        // 单调递减队列，存下标，队首始终是当前窗口的最大值下标
        Deque<Integer> deque = new ArrayDeque<>();
        // [0,2] [1,3] [2,4] [i-k+1,i]
        for (int i = 0; i < n; i++) {
            // 队首元素滑出窗口，移除
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 维护单调性：队尾比新元素小的不可能再成为最大值，移除
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 窗口形成后记录队首最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
