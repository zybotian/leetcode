package array;

public class MinArray {

    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        System.out.println(minArray.minArray(new int[]{1, 2, 3, 3, 4, 5, 5}));
        System.out.println(minArray.minArray(new int[]{5, 1, 2, 3, 3, 4, 5}));
        System.out.println(minArray.minArray(new int[]{5, 5, 1, 2, 3, 3, 4}));

        System.out.println(minArray.minArray(new int[]{4, 5, 5, 1, 2, 3, 3}));
        System.out.println(minArray.minArray(new int[]{3, 4, 5, 5, 1, 2, 3}));
        System.out.println(minArray.minArray(new int[]{3, 3, 4, 5, 5, 1, 2}));
        System.out.println(minArray.minArray(new int[]{2, 3, 3, 4, 5, 5, 1}));

        System.out.println(minArray.minArray(new int[]{2, 3, 3, 5, 5, 5, 5}));
    }

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        return minArray(numbers, 0, numbers.length - 1);
    }

    private int minArray(int[] numbers, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return numbers[start];
        }
        int mid = start + (end - start) / 2;
        if (numbers[mid] < numbers[end]) {
            return minArray(numbers, start, mid);
        }
        if (numbers[mid] > numbers[end]) {
            return minArray(numbers, mid + 1, end);
        }
        return minArray(numbers, start, end - 1);
    }

    public int minArrayV2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }
        return numbers[high];
    }
}
