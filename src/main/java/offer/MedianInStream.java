package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tianbo
 * @date 2019-06-17
 */
public class MedianInStream {

    // 左半部分使用大根堆, 堆顶是左边的最大值
    private PriorityQueue<Integer> left;

    // 右半部分使用小根堆, 堆顶是右边的最小值
    private PriorityQueue<Integer> right;

    // 容器中总的元素的个数
    private int count;

    public MedianInStream() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
        count = 0;
    }

    public static void main(String[] args) {
        int[] stream1 = {5, 4, 7, 6, 3, 8, 1, 2};
        int[] stream2 = {5, 4, 7, 6, 3, 8, 1, 9, 2};
        MedianInStream test1 = new MedianInStream();
        double median = test1.getMedian(stream1);
        System.out.println(median);

        MedianInStream test2 = new MedianInStream();
        double median2 = test2.getMedian(stream2);
        System.out.println(median2);
    }

    public void insert(int number) {
        if (count == 0) {
            // 0也是偶数
            right.add(number);
            count++;
            return;
        }
        if (count == 1) {
            left.add(number);
            count++;
            return;
        }
        if ((count & 1) == 0) {
            // 总数是偶数时插入小根堆
            if (number >= left.peek()) {
                // 当前数字确实比左边的最大值还大,直接插入
                right.add(number);
            } else {
                // 当前数字比左边的最大值小
                // 先把左边的最大值加到右边
                if (left.peek() != null) {
                    right.add(left.poll());
                }
                // 再把当前值加到左边
                left.add(number);
            }
        } else {
            // 总数是奇数时插入大根堆
            if (number <= right.peek()) {
                // 当前数字确实比右边的最小值小,直接插入
                left.add(number);
            } else {
                // 当前数字比右边的最小值大
                if (right.peek() != null) {
                    left.add(right.poll());
                }
                right.add(number);
            }
        }
        count++;
    }

    public double getMedian(int[] stream) {
        for (int data : stream) {
            insert(data);
        }
        Collections.sort(new ArrayList<>(left));
        Collections.sort(new ArrayList<>(right));

        System.out.println(left);
        System.out.println(right);
        return (stream.length & 1) == 0 ? (left.peek() + right.peek()) / 2.0 : right.peek();
    }
}
