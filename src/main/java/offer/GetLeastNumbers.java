package offer;

import util.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {

    public static void main(String[] args) {
        GetLeastNumbers instance = new GetLeastNumbers();
        for (int i = 1; i <= 15; i++) {
            int[] array = {1, 4, 3, 2, 5, 8, 7, 9, 6, 12, 10, 11, 13, 15, 14};
            PrintUtils.printBeauty(instance.getLeastNumbers(array, i));
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }

        return quickSort(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSort(int[] arr, int start, int end, int index) {
        int partition = partition(arr, start, end);
        if (partition == index) {
            return Arrays.copyOf(arr, partition + 1);
        }
        if (partition > index) {
            return quickSort(arr, start, partition - 1, index);
        }
        return quickSort(arr, partition + 1, end, index);
    }

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

    public static int[] getLeastNumbersV3(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static int[] getLeastNumbersV2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            Integer max = queue.peek();
            if (arr[i] < max) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        int[] result = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            result[index++] = queue.poll();
        }
        return result;
    }
}
