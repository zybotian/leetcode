package sort;

import util.PrintUtils;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr1 = {1};
        int[] arr2 = {1, 2};
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {1, 3, 2};
        int[] arr5 = {3, 2, 1};
        int[] arr6 = {1, 7, 3, 5, 4, 2, 1};
        int[] arr7 = {10, 6, 7, 3, 5, 5};

        mergeSort.mergeSort(arr1);
        PrintUtils.printBeauty(arr1);

        mergeSort.mergeSort(arr2);
        PrintUtils.printBeauty(arr2);

        mergeSort.mergeSort(arr3);
        PrintUtils.printBeauty(arr3);

        mergeSort.mergeSort(arr4);
        PrintUtils.printBeauty(arr4);

        mergeSort.mergeSort(arr5);
        PrintUtils.printBeauty(arr5);

        mergeSort.mergeSort(arr6);
        PrintUtils.printBeauty(arr6);

        mergeSort.mergeSort(arr7);
        PrintUtils.printBeauty(arr7);
    }

    public void mergeSort(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }

        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(array, start, mid);

        mergeSort(array, mid + 1, end);

        mergeSortedArray(array, start, mid, end);
    }

    private void mergeSortedArray(int[] array, int start, int mid, int end) {
        int[] result = new int[end - start + 1];
        int index = 0;
        int p1 = start, p2 = mid + 1;

        while (p1 <= mid && p2 <= end) {
            if (array[p1] <= array[p2]) {
                result[index++] = array[p1++];
            } else {
                result[index++] = array[p2++];
            }
        }

        while (p1 <= mid) {
            result[index++] = array[p1++];
        }

        while (p2 <= end) {
            result[index++] = array[p2++];
        }

        for (int i = 0; i < index; i++) {
            array[start + i] = result[i];
        }
    }
}
