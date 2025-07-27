package D0725;

import java.util.*;

class threeSum {

    public static void main(String[] args) {
        threeSum threeSum = new threeSum();
        int[] nums1 = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum.threeSum(nums1));

        int[] nums2 = new int[]{0, 1, 1};
        System.out.println(threeSum.threeSum(nums2));


        int[] nums3 = new int[]{0, 0, 0};
        System.out.println(threeSum.threeSum(nums3));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            // i指针去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到一组解
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // left去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // right去重
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 左边小了，需要找左边元素的后一个元素
                    left++;
                } else {
                    // 右边大了，需要找右边元素的前一个元素
                    right--;
                }
            }
        }

        return result;
    }
}