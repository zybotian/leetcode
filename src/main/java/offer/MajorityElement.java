package offer;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(majorityElement.majorityElement(new int[]{1, 2, 1}));
        System.out.println(majorityElement.majorityElement(new int[]{1, 1, 1}));
        System.out.println(majorityElement.majorityElement(new int[]{1, 1, 2}));
        System.out.println(majorityElement.majorityElement(new int[]{1, 1, 2, 2, 1}));
    }

    // 1 2 3 2 2 2 5 4 2
    // 1: res=1, count=1
    // 2: res=1, count=0
    // 3: res=3, count=1
    // 2: res=3, count=0
    // 2: res=2, count=1
    // 2: res=2, count=2
    // 5: res=2, count=1
    // 4: res=2, count=0
    // 2: res=2, count=1
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
            } else if (result == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }


    public int majorityElementV3(int[] nums) {
        int mid = nums.length >> 1;

        int start = 0, end = nums.length - 1;

        int index = partition(nums, start, end);

        while (index != mid) {
            if (index < mid) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int low = start, high = end;

        while (low < high) {
            // 快排的partition函数先操作right 再操作left
            while (low < high && array[high] > pivot) {
                high--;
            }

            while (low < high && array[low] <= pivot) {
                low++;
            }

            if (low < high) {
                int tmp = array[low];
                array[low] = array[high];
                array[high] = tmp;
            }
        }

        int tmp = array[start];
        array[start] = array[low];
        array[low] = tmp;
        return low;
    }

    public int majorityElementV2(int[] nums) {
        int halfSize = nums.length >> 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1 + calc(map.get(nums[i])));

            if (map.get(nums[i]) > halfSize) {
                return nums[i];
            }
        }
        return -1;
    }

    private int calc(Integer integer) {
        return integer != null ? integer : 0;
    }
}
