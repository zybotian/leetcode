package D0725;

import java.util.Arrays;

class moveZeroes {

    public static void main(String[] args) {
        moveZeroes moveZeroes = new moveZeroes();
        int[][] data = {{0, 1, 0, 3, 12}, {0}, {1, 0, 2, 0, 3}, {0, 1, 0, 3, 0}};
        for (int i = 0; i < data.length; i++) {
            moveZeroes.moveZeroes(data[i]);
            System.out.println(Arrays.toString(data[i]));
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int lastNone0Index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[lastNone0Index] = nums[i];
            lastNone0Index++;
        }

        for (int i = lastNone0Index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}