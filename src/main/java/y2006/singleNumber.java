package y2006;

public class singleNumber {
    public static void main(String[] args) {
        singleNumber singleNumber = new singleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(singleNumber.singleNumber(new int[]{2, 1, 2}));
        System.out.println(singleNumber.singleNumber(new int[]{1}));
    }

    public int singleNumber(int[] nums) {
        // 0与任何整数按位异或运算结果为数字本身，任何数与自身按位异或结果为0
        int result = 0;
        for (int data : nums) {
            result ^= data;
        }
        return result;
    }
}
