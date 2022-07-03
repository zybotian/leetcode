package sort;

import util.PrintUtils;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] data = {8, 6, 7, 9, 5, 12, 10};
        sort.quickSort(data);
        PrintUtils.printBeauty(data);

        int[] data2 = {8, 6, 4, 6, 7, 3, 9, 2, 1, 5, 12, 10};
        sort.quickSort(data2);
        PrintUtils.printBeauty(data2);

        int[] data3 = {1, 4, 6, 7, 9, 12, 20};
        sort.quickSort(data3);
        PrintUtils.printBeauty(data3);

        int[] data4 = {18, 13, 12, 8, 7, 5, 4, 3};
        sort.quickSort(data4);
        PrintUtils.printBeauty(data4);
    }

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(array, start, end);
        quickSort(array, start, index - 1);
        quickSort(array, index + 1, end);
    }

    // 8,6,7,9,5,12,10
    // 0,1,2,3,4,05,06
    // base=8, low=0, high=6
    // low=3 high=4
    // 8,6,7,5,9,12,10
    // 0,1,2,3,4,05,06
    // low=3 high=3
    private int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int low = start, high = end;

        while (low < high) {
            // 快排的partition函数先操作right 再操作left
            while (low < high && array[high] > pivot) {
                high--;
            }

            while (low < high && array[low] <= pivot) {
                low++;
            }

            if (low < high) {
                int tmp = array[low];
                array[low] = array[high];
                array[high] = tmp;
            }
        }

        int tmp = array[start];
        array[start] = array[low];
        array[low] = tmp;
        return low;
    }
}
