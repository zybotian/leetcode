package greedy;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.jump(new int[]{4, 3, 1, 1, 4}));
        System.out.println(solution.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(solution.jump(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution.jump(new int[]{0}));
        System.out.println(solution.jump(new int[]{1}));
        System.out.println(solution.jump(new int[]{1, 2, 1, 1, 1}));
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4, 2, 1}));
        System.out.println(solution.jump(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}));

    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= nums[0]; i++) {
            queue.offer(i);
        }

        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int position = queue.poll();
                if (position >= nums.length - 1) {
                    return depth;
                }

                for (int j = 1; j <= nums[position]; j++) {
                    if (queue.contains(position + j)) {
                        continue;
                    }
                    queue.offer(position + j);
                }
            }
            depth++;

        }
        return 0;
    }
}