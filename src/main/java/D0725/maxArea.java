package D0725;

class maxArea {

    public static void main(String[] args) {
        maxArea maxArea = new maxArea();
        int[] array1 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea.maxArea(array1));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int max = 0;
        while (left <= right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}