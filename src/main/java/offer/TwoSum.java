package offer;

import util.PrintUtils;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        PrintUtils.printBeauty(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
        PrintUtils.printBeauty(twoSum.twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40));
    }

    public int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                return new int[]{nums[start], nums[end]};
            }
        }
        return new int[2];
    }

    public int[] twoSumV2(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                return new int[]{nums[i], target - nums[i]};
            } else {
                set.add(nums[i]);
            }
        }
        return new int[2];
    }
}
