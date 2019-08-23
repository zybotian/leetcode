package offer;

import java.util.Arrays;

/**
 * @author tianbo
 * @date 2019-08-23
 */
public class HelanGuoqi {

    public static void sort(int[] data) {
        int begin = 0;
        int current = 0;
        int end = data.length - 1;

        while (current <= end) {
            if (data[current] == 0) {
                swap(data, current, begin);
                current++;
                begin++;
            } else if (data[current] == 1) {
                current++;
            } else if (data[current] == 2) {
                swap(data, current, end);
                end--;
            }
        }
    }

    private static void swap(int[] data, int current, int begin) {
        int tmp = data[current];
        data[current] = data[begin];
        data[begin] = tmp;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 1, 2, 0, 1, 0, 1, 2, 0, 1, 2, 0, 2, 1};
        sort(data);
        System.out.println(Arrays.toString(data));
    }
}
