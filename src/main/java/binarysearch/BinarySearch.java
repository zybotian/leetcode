package binarysearch;

public class BinarySearch {
    public int search(int[] sortedArray, int target) {
        if (sortedArray == null || sortedArray.length == 0) {
            return -1;
        }
        if (target == sortedArray[0]) {
            return 0;
        }

        int start = 0, end = sortedArray.length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            if (sortedArray[mid] == target) {
                return mid;
            }
            if (sortedArray[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 20; i++) {
            System.out.println(i + "==" + binarySearch.search(array, i));
        }
    }
}
