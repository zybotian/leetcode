package dp;

public class MaxProduct {
    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct.maxProduct(new int[]{2, 3, 4, 5}));
        System.out.println(maxProduct.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct.maxProduct(new int[]{2, -1, -3}));
        System.out.println(maxProduct.maxProduct(new int[]{2, -1, -3, 0}));

    }

    public int maxProduct(int[] nums) {
        // result[i]: 表示截止到第i数字的数组中的子数组最大乘积即「0，i-1」
        int[] maxResult = new int[nums.length];
        int[] minResult = new int[nums.length];
        maxResult[0] = nums[0];
        minResult[0] = nums[0];

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxResult[i] = Math.max(minResult[i - 1] * nums[i], Math.max(nums[i], nums[i] * maxResult[i - 1]));
            minResult[i] = Math.min(minResult[i - 1] * nums[i], Math.min(nums[i], nums[i] * maxResult[i - 1]));
            max = Math.max(max, maxResult[i]);
        }
        return max;
    }
}
