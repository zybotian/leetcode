package y2006;

import java.util.Arrays;

public class productExceptSelf {
    public static void main(String[] args) {
        productExceptSelf productExceptSelf = new productExceptSelf();

        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(new int[]{0, 0})));
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(new int[]{0, 1})));
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(new int[]{1, 0})));
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));

    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, beforeProduct = 1; i < nums.length; i++) {
            result[i] = beforeProduct;
            beforeProduct *= nums[i];
        }

        for (int i = nums.length - 1, afterProduct = 1; i >= 0; i--) {
            result[i] *= afterProduct;
            afterProduct *= nums[i];
        }
        return result;
    }
}
