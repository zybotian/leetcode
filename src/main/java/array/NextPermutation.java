package array;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{1, 2, 3, 4};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = new int[]{3, 2, 1};
        nextPermutation.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = new int[]{1, 1, 5};
        nextPermutation.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
