package array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = 0;
        int count = 0;
        Map<Integer, Integer> preSumCountMap = new HashMap<>();
        preSumCountMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (preSumCountMap.containsKey(preSum - k)) {
                count += preSumCountMap.get(preSum - k);
            }
            preSumCountMap.put(preSum, preSumCountMap.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
