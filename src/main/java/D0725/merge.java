package D0725;

import java.util.*;

class merge {

    public static void main(String[] args) {
        merge merge = new merge();
        int[][] arr1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        sortArray(arr1);
//        display(arr1);
        display(merge.merge(arr1));

        int[][] arr2 = {{1, 4}, {4, 5}};
//        sortArray(arr2);
//        display(arr2);
        display(merge.merge(arr2));

        int[][] arr3 = {{1, 3}, {4, 6}};
//        sortArray(arr3);
//        display(arr3);
        display(merge.merge(arr3));

        int[][] arr4 = {{15, 18}, {1, 16}};
//        sortArray(arr4);
//        display(arr4);
        display(merge.merge(arr4));

        int[][] arr5 = {{1, 4}, {2, 3}};
        display(merge.merge(arr5));

        int[][] arr6 = {{2, 6}, {3, 6}};
        display(merge.merge(arr6));

        int[][] arr7 = {{1, 4}, {1, 3}};
        display(merge.merge(arr7));

        int[][] arr8 = {{1, 4}, {1, 4}};
        display(merge.merge(arr8));
    }

    public int[][] merge(int[][] intervals) {
        sortArray(intervals);

        int lastStart = intervals[0][0];
        int lastEnd = intervals[0][1];

        List<int[]> resultList = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (lastEnd >= intervals[i][0] && lastEnd <= intervals[i][1]) {
                lastEnd = intervals[i][1];
            } else {
                if (lastEnd < intervals[i][0]) {
                    int[] tmpRes = {lastStart, lastEnd};
                    resultList.add(tmpRes);
                    lastStart = intervals[i][0];
                    lastEnd = intervals[i][1];
                }
            }
        }
        resultList.add(new int[]{lastStart, lastEnd});

        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private static void sortArray(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }

    private static void display(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.print(Arrays.toString(ints[i]) + "\t");
        }
        System.out.println();
    }
}