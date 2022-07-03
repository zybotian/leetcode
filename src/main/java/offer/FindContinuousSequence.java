package offer;

import util.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        PrintUtils.printBeauty(findContinuousSequence.findContinuousSequence(9));
        PrintUtils.printBeauty(findContinuousSequence.findContinuousSequence(15));
    }

    public int[][] findContinuousSequence(int target) {
        if (target <= 2) {
            return new int[0][0];
        }

        List<int[]> result = new ArrayList<>();

        int limit = target / 2;
        int start = 1, end = 2, sum = start + end;

        while (start <= limit) {
            if (sum == target) {
                int[] tmp = new int[end - start + 1];
                for (int i = start; i <= end; i++) {
                    tmp[i - start] = i;
                }
                result.add(tmp);
                sum -= start;
                start++;
            } else if (sum < target) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        return result.toArray(new int[0][0]);
    }
}
