package D0725;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

class rotate {

    public static void main(String[] args) {
        rotate rotate = new rotate();
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(ints, 3);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = {-1};
        rotate.rotate(ints2, 2);
        System.out.println(Arrays.toString(ints2));

        int[] ints3 = {1, 2};
        rotate.rotate(ints3, 7);
        System.out.println(Arrays.toString(ints3));
    }







    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        k = k % nums.length;
        int[] result = new int[nums.length];

        int start = nums.length - k;
        System.arraycopy(nums, start, result, 0, k);
        System.arraycopy(nums, 0, result, k, start);
        System.arraycopy(result, 0, nums, 0, result.length);
    }
}