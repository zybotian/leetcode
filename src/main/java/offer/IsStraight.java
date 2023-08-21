package offer;

import java.util.HashSet;
import java.util.Set;

public class IsStraight {

    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(isStraight(new int[]{1, 3, 5, 0, 0}));
        System.out.println(isStraight(new int[]{1, 6, 7, 0, 0}));
        System.out.println(isStraight(new int[]{1, 3, 6, 0, 0}));
    }

    public static boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int max = 0, min = 14;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else if (set.contains(nums[i])) {
                return false;
            } else {
                set.add(nums[i]);
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
        }
        return max - min < 5;
    }
}
