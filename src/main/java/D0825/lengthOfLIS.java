package D0825;

import java.util.Arrays;

class lengthOfLIS {

    public static void main(String[] args) {
        int[] data1 = {7, 7, 7, 7, 7, 7};//1
        int[] data2 = {10, 9, 2, 5, 3, 7, 101, 18};//4
        int[] data3 = {0, 1, 0, 3, 2, 3};//4
        int[] data4 = {0, 1, 2, 3, 4, 5};//6
        int[] data5 = {5, 4, 3, 2, 1};//1
        int[] data6 = {5, 4, 6, 3, 7, 2, 8, 1};// 4
        int[] data7 = {4, 10, 4, 3, 8, 9};// 3
        // [4]
        // [4,10]
        // [4,10]
        // [4,10]
        // [4,10] [4,8] [4,8] [3,8]
        // [4,8,9] [3,8,9]

        lengthOfLIS lengthOfLIS = new lengthOfLIS();

        System.out.println(lengthOfLIS.lengthOfLIS(data1));
        System.out.println(lengthOfLIS.lengthOfLIS(data2));
        System.out.println(lengthOfLIS.lengthOfLIS(data3));
        System.out.println(lengthOfLIS.lengthOfLIS(data4));
        System.out.println(lengthOfLIS.lengthOfLIS(data5));
        System.out.println(lengthOfLIS.lengthOfLIS(data6));
        System.out.println(lengthOfLIS.lengthOfLIS(data7));
    }

    public int lengthOfLIS(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);


        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
            max = Math.max(max, result[i]);
        }

        return max;
    }
}