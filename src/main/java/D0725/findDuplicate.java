package D0725;

import java.util.HashSet;
import java.util.Set;

class findDuplicate {

    public static void main(String[] args) {
        findDuplicate findDuplicate = new findDuplicate();
        System.out.println(findDuplicate.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}