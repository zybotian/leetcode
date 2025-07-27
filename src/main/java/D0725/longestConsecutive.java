package D0725;

import java.util.HashSet;
import java.util.Set;

class longestConsecutive {

    public static void main(String[] args) {
        longestConsecutive longestConsecutive = new longestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive.longestConsecutive(new int[]{1, 0, 1, 2}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 1;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int data : set) {
            if (set.contains(data - 1)) {
                continue;
            }

            int thisStart = data;
            int thisMax = 1;
            while (set.contains(thisStart + 1)) {
                thisStart++;
                thisMax++;
            }
            max = Math.max(max, thisMax);
        }
        return max;
    }
}