package twopointers;


class Trap2 {

    public static void main(String[] args) {
        Trap2 trap = new Trap2();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap.trap(height));

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap.trap(height2));

        int[] height3 = {4, 2, 3};
        System.out.println(trap.trap(height3));
    }

    /**
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int maxHeight = 0;
        int maxHeightIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }

        int sum = 0;
        for (int i = 0; i < maxHeightIndex - 1; i++) {
            if (height[i] > height[i + 1]) {
                sum += (height[i] - height[i + 1]);
                height[i + 1] = height[i];
            }
        }

        for (int i = height.length - 1; i > maxHeightIndex + 1; i--) {
            if (height[i] > height[i - 1]) {
                sum += (height[i] - height[i - 1]);
                height[i - 1] = height[i];
            }
        }

        return sum;
    }
}