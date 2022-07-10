package offer;

import util.PrintUtils;

public class ConstructArr {

    public static void main(String[] args) {
        ConstructArr constructArr = new ConstructArr();
        int[] ints = constructArr.constructArr(new int[]{1, 2, 3, 4, 5});
        PrintUtils.printBeauty(ints);
    }

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }

        int[] left = new int[a.length];
        int[] right = new int[a.length];

        left[0] = 1;
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        right[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }


}
