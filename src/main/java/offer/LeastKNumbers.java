package offer;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-06-17
 */
public class LeastKNumbers {

    public static void main(String[] args) {
        int[] data1 = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(getLeastNumbers(data1, 4));
        System.out.println(getLeastNumbers2(data1, 4));
    }

    public static List<Integer> getLeastNumbers(int[] numbers, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.<Integer>reverseOrder());
        // 遍历数组
        for (int i = 0; i < numbers.length; i++) {

            // 队列容量未满时直接加入队列
            if (queue.size() < k) {
                queue.add(numbers[i]);
            } else {
                // 队列容量满时,如果当前元素比最大值小,删除最大,假如当前
                Integer max = queue.peek();
                if (numbers[i] < max) {
                    queue.poll();
                    queue.add(numbers[i]);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public static List<Integer> getLeastNumbers2(int[] numbers, int k) {
        int start = 0, end = numbers.length - 1;
        int index = partition(numbers, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(numbers, start, end);
            } else {
                start = index + 1;
                index = partition(numbers, start, end);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(numbers[i]);
        }
        return result;
    }

    private static int partition(int[] array, int start, int end) {
        int low = start, high = end;
        // 选择第一个元素作为基准元素
        int base = array[low];

        while (low < high) {
            // 从右往左找到第一个比基准元素小的元素
            while (low < high && array[high] >= base) {
                high--;
            }
            // 将比基准元素小的元素交换到基准元素的左边
            swap(array, low, high);

            while (low < high && array[low] <= base) {
                low++;
            }

            swap(array, low, high);
        }
        return low;
    }

    private static void swap(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }
}
