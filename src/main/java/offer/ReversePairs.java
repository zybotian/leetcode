package offer;

public class ReversePairs {

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(new int[]{7}));
        System.out.println(reversePairs.reversePairs(new int[]{7, 5}));
        System.out.println(reversePairs.reversePairs(new int[]{7, 5, 6}));
        System.out.println(reversePairs.reversePairs(new int[]{7, 5, 6, 4}));
        System.out.println(reversePairs.reversePairs(new int[]{4, 5, 6, 7}));
        System.out.println(reversePairs.reversePairs(new int[]{7, 6, 5, 4}));
    }

    private int count;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
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
                count += (mid - p1 + 1);
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


    public static int reversePairsV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
