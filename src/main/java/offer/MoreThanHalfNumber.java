package offer;

import java.util.Arrays;

/**
 * @author tianbo
 * @date 2019-08-22
 */
public class MoreThanHalfNumber {

    public static int find(int[] array) {
        int start = 0, end = array.length - 1;
        int mid = array.length >> 1;
        int index = partition(array, start, end);
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(array, start, end);
        }
        return array[index];
    }

    private static int partition(int[] array, int start, int end) {
        int base = array[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && array[i] <= base) {
                i++;
            }

            while (i < j && array[j] >= base) {
                j--;
            }

            swap(array, i, j);
        }

        swap(array, i, start);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(find(array));
        System.out.println(Arrays.toString(array));
    }
}
