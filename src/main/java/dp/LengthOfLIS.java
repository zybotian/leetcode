package dp;


import java.util.Arrays;

public class LengthOfLIS {

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] result = new int[nums.length];

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
