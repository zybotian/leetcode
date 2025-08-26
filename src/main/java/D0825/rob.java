package D0825;

class rob {

    public static void main(String[] args) {
        rob rob = new rob();
        int[] array1 = {1, 2, 3, 1};
        int[] array2 = {2, 7, 9, 3, 1};
        System.out.println(rob.rob(array1));
        System.out.println(rob.rob(array2));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] result = new int[nums.length + 1];
        result[0] = 0;
        result[1] = nums[0];
        result[2] = Math.max(nums[1], nums[0]);

        for (int i = 3; i <= nums.length; i++) {
            result[i] = Math.max(result[i - 1], result[i - 2] + nums[i - 1]);
        }

        return result[nums.length];
    }
}