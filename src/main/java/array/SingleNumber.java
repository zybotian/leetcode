package array;

public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{1, 3, 1}));
        System.out.println(singleNumber.singleNumber(new int[]{1, 1, 3}));
        System.out.println(singleNumber.singleNumber(new int[]{1, 2, 1, 2, 3}));
        System.out.println(singleNumber.singleNumber(new int[]{1, 2, 1, 2, 3, 3, 4}));

    }

    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
