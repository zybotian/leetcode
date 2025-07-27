package D0725;

import java.util.Arrays;

class findKthLargest {
    public static void main(String[] args) {
        findKthLargest findKthLargest = new findKthLargest();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest.findKthLargest(nums, 1));
        System.out.println(findKthLargest.findKthLargest(nums, 2));
        System.out.println(findKthLargest.findKthLargest(nums, 3));
        System.out.println(findKthLargest.findKthLargest(nums, 4));
        System.out.println(findKthLargest.findKthLargest(nums, 5));
        System.out.println(findKthLargest.findKthLargest(nums, 6));
        System.out.println(findKthLargest.findKthLargest(nums, 7));
        System.out.println(findKthLargest.findKthLargest(nums, 8));
        System.out.println(findKthLargest.findKthLargest(nums, 9));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}