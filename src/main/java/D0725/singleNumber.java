package D0725;

class singleNumber {

    public static void main(String[] args) {
        singleNumber singleNumber = new singleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{1, 2, 3, 2, 1, 3, 51, 51, 5}));
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int res = 0;
        while (i < nums.length) {
            res ^= nums[i];
            i++;
        }
        return res;
    }
}