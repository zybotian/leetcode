package y2006;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class majorityElement {

    public int majorityElement3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int data : nums) {
            Integer value = map.get(data);
            if (value == null) {
                map.put(data, 1);
            } else {
                map.put(data, map.get(data) + 1);
            }
        }
        int res = 0;
        int resCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > resCount) {
                resCount = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int candicate = 0, count = 0;
        for (int data : nums) {
            if (count == 0) {
                candicate = data;
                count++;
            } else {
                count += (data == candicate ? 1 : -1);
            }
        }
        return candicate;
    }

    public static void main(String[] args) {
        majorityElement majorityElement = new majorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement.majorityElement(new int[]{3, 2, 3}));
    }
}
