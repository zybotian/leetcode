package offer;

import java.util.ArrayList;
import java.util.List;

public class LastRemaining {

    public static void main(String[] args) {
        LastRemaining lastRemaining = new LastRemaining();
        System.out.println(lastRemaining.lastRemaining(5, 3));
        System.out.println(lastRemaining.lastRemaining(10, 17));

        long start = System.currentTimeMillis();
        System.out.println(lastRemaining.lastRemaining(70866, 116922));
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " ms");
    }

    public int lastRemaining(int n, int m) {
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i;
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            System.arraycopy(list, idx + 1, list, idx, n - idx - 1);
            n--;
        }
        return list[0];
    }

    public int lastRemainingV4(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public int lastRemainingV3(int n, int m) {
        // 模拟环形链表
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(i);
        }

        // cursor，不断遍历数组
        int cursor = 0;

        // 循环结束条件：列表中元素个数等于1
        while (array.size() > 1) {
            // 找到第m个元素
            cursor = (cursor + (m - 1)) % array.size();
            // 删除第m个元素
            array.remove(array.get(cursor));
        }


        // 返回最终剩下的一个元素
        return array.get(0);
    }

    public int lastRemainingV2(int n, int m) {
        // 数组模拟
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        // 记录已经被删除的元素
        List<Integer> deleted = new ArrayList<>();

        // cursor，不断遍历数组
        int cursor = 0;

        // 循环结束条件：deleted的列表中元素个数等于n-1
        while (deleted.size() < n - 1) {
            int count = 0;
            while (true) {
                if (array[cursor] >= 0) {
                    count++;
                    if (count == m) {
                        deleted.add(array[cursor]);
                        array[cursor] = -1;
                        break;
                    }
                }
                cursor++;
                cursor %= n;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                return array[i];
            }
        }

        return -1;
    }

}
