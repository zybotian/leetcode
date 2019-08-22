package offer;

import java.util.Arrays;

/**
 * @author tianbo
 * @date 2019-08-22
 */
public class ReorderArray {

    // 双向指针, 将所有的奇数移动到所有的偶数前面
    public static void reorder(int[] array) {
        int start = 0, end = array.length - 1;
        while (start < end) {
            // 从左往右找到第一个偶数
            while (start < end && array[start] % 2 == 1) {
                start++;
            }

            // 从右往左找到第一个奇数
            while (start < end && array[end] % 2 == 0) {
                end--;
            }

            if (start < end) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 13, 14, 56, 87, 90, 99, 7, 34};
        reorder(array);
        System.out.println(Arrays.toString(array));
    }
}
