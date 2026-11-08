package y2006;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class subarraySum {
    public static void main(String[] args) {
        subarraySum subarraySum = new subarraySum();
        System.out.println(subarraySum.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum.subarraySum(new int[]{1, 2, 3}, 5));
        System.out.println(subarraySum.subarraySum(new int[]{1, 2, 3, 0, 0, 0}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int countResult = 0;

        int sum = 0;
        // [1,3,6,6,6,6]
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                countResult++;
            }

            if (sumCountMap.containsKey(sum - k)) {
                countResult += sumCountMap.get(sum - k);
            }
            sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
        }
        return countResult;
    }

    public int subarraySum2(int[] nums, int k) {
        int countResult = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    countResult++;
                }
            }
        }
        return countResult;
    }
}
