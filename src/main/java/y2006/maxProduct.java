package y2006;

public class maxProduct {
    public static void main(String[] args) {
        maxProduct maxProduct = new maxProduct();
        System.out.println(maxProduct.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct.maxProduct(new int[]{2, -1, -3}));
        System.out.println(maxProduct.maxProduct(new int[]{2, -1, -3, 0}));
    }

    public int maxProduct(int[] nums) {
        // maxResult[i] 表示以nums[i]结尾的子数组最大乘积
        int[] maxResult = new int[nums.length];
        // minResult[i] 表示以nums[i]结尾的子数组最小乘积
        int[] minResult = new int[nums.length];

        maxResult[0] = nums[0];
        minResult[0] = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxResult[i] = Math.max(nums[i], Math.max(nums[i] * maxResult[i - 1], nums[i] * minResult[i - 1]));
            minResult[i] = Math.min(nums[i], Math.min(nums[i] * minResult[i - 1], nums[i] * maxResult[i - 1]));
            answer = Math.max(answer, maxResult[i]);
        }

        return answer;
    }
}
