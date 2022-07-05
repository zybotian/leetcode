package offer;

import util.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberI {
    public static void main(String[] args) {
        SingleNumberI singleNumber = new SingleNumberI();
        PrintUtils.printBeauty(singleNumber.singleNumbers(new int[]{1, 2, 4, 3, 1, 2, 3, 5}));
    }

    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[2];
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }

        if (res == 0) {
            return new int[2];
        }

        int data = 1;
        while ((data & res) == 0) {
            data <<= 1;
        }

        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & data) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[]{a, b};
    }

    public int[] singleNumbersV2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result[index++] = entry.getKey();
            }
        }
        return result;
    }
}
