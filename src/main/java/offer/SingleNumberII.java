package offer;

import java.util.*;

public class SingleNumberII {
    public static void main(String[] args) {
        SingleNumberII singleNumber = new SingleNumberII();
        System.out.println(singleNumber.singleNumber(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 5}));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
