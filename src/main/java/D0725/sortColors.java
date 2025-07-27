package D0725;

import java.util.Arrays;

class sortColors {

    public static void main(String[] args) {
        sortColors sortColors = new sortColors();
        int[] nums = {2, 0, 2, 1, 1, 0, 2, 2, 1};
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int redCount = 0, whiteCount = 0, blueCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redCount++;
            }
            if (nums[i] == 1) {
                whiteCount++;
            }
            if (nums[i] == 2) {
                blueCount++;
            }
        }
        int k = 0;
        for (int i = 0; i < redCount; i++) {
            nums[k++] = 0;
        }
        for (int i = 0; i < whiteCount; i++) {
            nums[k++] = 1;
        }
        for (int i = 0; i < blueCount; i++) {
            nums[k++] = 2;
        }
    }

    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}