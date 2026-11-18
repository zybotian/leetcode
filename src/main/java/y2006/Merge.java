package y2006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        // step 1: 排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // step 2: 计算
        List<List<Integer>> resultList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                resultList.add(new ArrayList<>(Arrays.asList(start, end)));
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        resultList.add(new ArrayList<>(Arrays.asList(start, end)));

        // step 3: 结果转换
        int[][] result = new int[resultList.size()][2];
        for (int i = 0, size = resultList.size(); i < size; i++) {
            result[i][0] = resultList.get(i).get(0);
            result[i][1] = resultList.get(i).get(1);
        }
        return result;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {10, 12}, {15, 18}, {16, 17}, {18, 19}, {20, 30}, {25, 27}};
        int[][] result = merge.merge(intervals);
        displayArrays(result);
    }

    private static void displayArrays(int[][] result) {
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
