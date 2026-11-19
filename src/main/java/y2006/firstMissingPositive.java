package y2006;

import java.util.HashSet;
import java.util.Set;

public class firstMissingPositive {
    public static void main(String[] args) {
        firstMissingPositive firstMissingPositive = new firstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{0, 2, 2, 1, 1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1, 2, 3}));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int firstMissingPositive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }
}
