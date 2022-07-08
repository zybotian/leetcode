package offer;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = result[0];

        for (int i = 1; i < nums.length; i++) {
            result[i] = Math.max(0, result[i - 1]) + nums[i];
            max = Math.max(max, result[i]);
        }

        return max;
    }
}
