package y2006;

import java.util.Arrays;

public class rotate {
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start, right = end;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        rotate rotate = new rotate();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
        rotate.rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
    }
}
