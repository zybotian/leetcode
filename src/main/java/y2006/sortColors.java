package y2006;

import java.util.Arrays;

public class sortColors {
    public void sortColors(int[] nums) {
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

    public static void main(String[] args) {
        sortColors sortColors = new sortColors();
        int[] data1 = {2, 0, 2, 1, 2, 1, 2, 0, 1, 2, 2, 1};
        sortColors.sortColors(data1);
        System.out.println(Arrays.toString(data1));
    }
}
