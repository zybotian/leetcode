package D0725;

import java.util.Arrays;

class maxSubArray {
    public static void main(String[] args) {
        maxSubArray maxSubArray = new maxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(maxSubArray.maxSubArray(new int[]{1}));
        System.out.println(maxSubArray.maxSubArray(new int[]{-1}));

    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 第i个数结尾构成的数组的最大子数组和
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result[i] = Math.max(nums[i], result[i - 1] + nums[i]);
        }

        int max = result[0];
        for (int i = 1; i < result.length; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int currentMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                currentMax = Math.max(currentMax, currentSum);
            }
        }

        return currentMax;
    }


}
