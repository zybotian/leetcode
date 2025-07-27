package D0725;

import java.util.Arrays;

class majorityElement {

    public static void main(String[] args) {
        majorityElement majorityElement = new majorityElement();
        int i = majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}