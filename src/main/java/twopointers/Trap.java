package twopointers;

import java.util.Arrays;

class Trap {

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap.trap(height));

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap.trap(height2));
    }

    /**
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        int currentRow = 0;
        while (true) {
            int currentSum = trapOneLine(height, currentRow);
            if (currentSum == 0) {
                break;
            }
            sum += currentSum;
            currentRow++;
        }
        return sum;
    }

    private int trapOneLine(int[] height, int currentRow) {
        int[] newHeight = new int[height.length];
        for (int i = 0; i < newHeight.length; i++) {
            newHeight[i] = Math.max(0, height[i] - currentRow);
        }
        int result = 0;

        int left = 0, right = 0;
        while (right < newHeight.length) {
            while (left < newHeight.length - 1 && newHeight[left] == 0) {
                left++;
            }

            right = left + 1;
            while (right < newHeight.length && newHeight[right] == 0) {
                right++;
            }

            if (left < right && right < newHeight.length && newHeight[left] > 0 && newHeight[right] > 0) {
                result += (right - left - 1);
            }
            left = right;
            right++;
        }
        return result;
    }
}