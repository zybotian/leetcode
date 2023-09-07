package array;

import java.util.Arrays;
import java.util.TreeMap;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {1, 3, 12, 0};
        moveZeroes.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {0, 1, 0};
        moveZeroes.moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = {0, 0, 1};
        moveZeroes.moveZeroes(nums4);
        System.out.println(Arrays.toString(nums4));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 输入: nums = [0,1,0,3,12] 输出: [1,3,12,0,0]
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[last++] = nums[i];
            }
        }
        while (last < nums.length) {
            nums[last++] = 0;
        }
    }

    private void move(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            nums[i - 1] = nums[i];
        }
        nums[end] = 0;
    }
}
