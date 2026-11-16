package y2006;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class findKthLargest {
    public static void main(String[] args) {
        findKthLargest findKthLargest = new findKthLargest();
        System.out.println(findKthLargest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(findKthLargest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 1)); // 6
        System.out.println(findKthLargest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 3)); // 4
    }

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.naturalOrder());
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(nums[i]);
            } else {
                if (priorityQueue.peek() < nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.add(nums[i]);
                }
            }
        }
        return priorityQueue.peek();
    }
}
