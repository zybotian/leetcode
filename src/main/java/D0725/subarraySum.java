package D0725;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

class subarraySum {

    public static void main(String[] args) {
        subarraySum subarraySum = new subarraySum();
        System.out.println(subarraySum.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum.subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            System.out.println(mp);
        }
        return count;
    }

}