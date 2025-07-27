package D0725;

import java.util.Arrays;

class productExceptSelf {

    public static void main(String[] args) {
        productExceptSelf productExceptSelf = new productExceptSelf();
        int[] ints = productExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
        int[] ints1 = productExceptSelf.productExceptSelf(new int[]{0, 0});
        System.out.println(Arrays.toString(ints1));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] beforeProduct = new int[nums.length];
        int[] afterProduct = new int[nums.length];

        beforeProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            beforeProduct[i] = beforeProduct[i - 1] * nums[i - 1];
        }

        afterProduct[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            afterProduct[i] = afterProduct[i + 1] * nums[i + 1];
        }


        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = beforeProduct[i] * afterProduct[i];
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tmpResult = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    tmpResult *= nums[j];
                }
            }
            result[i] = tmpResult;
        }
        return result;
    }
}