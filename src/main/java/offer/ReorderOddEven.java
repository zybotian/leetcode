package offer;

import java.util.Arrays;

/**
 * @author tianbo
 * @date 2019-07-17
 */
public class ReorderOddEven {

    // 奇数移动到数组左边, 偶数移动到数组右边

    public static void main(String[] args) {
        int[] data = {1, 8, 6, 11, 24, 35, 90};
        System.out.println(Arrays.toString(reorder(data)));
    }

    public static int[] reorder(int[] data) {
        int i = 0, j = data.length - 1;
        while (i < j) {
            while (i < j && (data[i] & 1) == 1) {
                i++;
            }
            while (j > i && (data[j] & 1) == 0) {
                j--;
            }
            if (i < j) {
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }
        }
        return data;
    }
}
