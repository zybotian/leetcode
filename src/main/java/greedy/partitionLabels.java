package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class partitionLabels {

    public static void main(String[] args) {
        partitionLabels solution = new partitionLabels();
        List<Integer> res1 = solution.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(res1);
    }

    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        // 记录每个字符的第一次和最后一次出现的index
        int[][] chars = new int[26][2];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 2; j++) {
                chars[i][j] = -1;
            }
        }
        for (int i = 0, size = s.length(); i < size; i++) {
            char currentChar = s.charAt(i);
            int index = currentChar - 'a';
            if (chars[index][0] == -1) {
                chars[index][0] = i;
            }
            chars[index][1] = Math.max(chars[index][1], i);
        }
        int[][] mergeResult = merge(chars);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < mergeResult.length; i++) {
            if (mergeResult[i][0] < 0 || mergeResult[i][1] < 0) {
                continue;
            }
            result.add(mergeResult[i][1] - mergeResult[i][0] + 1);
        }
        return result;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return null;
        }

        List<int[]> resultList = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int lastStart = intervals[0][0];
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (lastEnd >= intervals[i][0] && lastEnd <= intervals[i][1]) {
                lastEnd = intervals[i][1];
            }
            if (lastEnd < intervals[i][0]) {
                resultList.add(new int[]{lastStart, lastEnd});
                lastStart = intervals[i][0];
                lastEnd = intervals[i][1];
            }
        }
        resultList.add(new int[]{lastStart, lastEnd});


        int[][] resultArray = new int[resultList.size()][2];
        for (int index = 0; index < resultList.size(); index++) {
            resultArray[index][0] = resultList.get(index)[0];
            resultArray[index][1] = resultList.get(index)[1];
        }
        return resultArray;
    }
}