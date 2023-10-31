package array;

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(maxSubArray.maxSubArray(new int[]{1}));

    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] < 0) {
                sum = 0;
            } else {
                sum += nums[i];
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}
