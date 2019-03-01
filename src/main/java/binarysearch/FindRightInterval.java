package binarysearch;

import common.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tianbo
 * @date 2019-03-01
 */
public class FindRightInterval {
    public static void main(String[] args) {
        Interval[] intervals1 = new Interval[1];
        intervals1[0] = new Interval(1, 2);

        Interval[] intervals2 = new Interval[3];
        intervals2[0] = new Interval(3, 4);
        intervals2[1] = new Interval(2, 3);
        intervals2[2] = new Interval(1, 2);

        Interval[] intervals3 = new Interval[3];
        intervals3[0] = new Interval(1, 4);
        intervals3[1] = new Interval(2, 3);
        intervals3[2] = new Interval(3, 4);

        Interval[] intervals4 = new Interval[4];
        intervals4[0] = new Interval(1, 2);
        intervals4[1] = new Interval(2, 3);
        intervals4[2] = new Interval(0, 1);
        intervals4[3] = new Interval(3, 4);

        FindRightInterval test = new FindRightInterval();
//        Solution1 solution = test.new Solution1();
        Solution solution = test.new Solution();

        System.out.println(Arrays.toString(solution.findRightInterval(intervals1)));
        System.out.println(Arrays.toString(solution.findRightInterval(intervals2)));
        System.out.println(Arrays.toString(solution.findRightInterval(intervals3)));
        System.out.println(Arrays.toString(solution.findRightInterval(intervals4)));
    }

    // 击败10.81%, 效率偏低
    class Solution1 {
        public int[] findRightInterval(Interval[] intervals) {
            int[] result = new int[intervals.length];

            for (int i = 0; i < intervals.length; i++) {
                result[i] = -1;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < intervals.length; j++) {
                    if (intervals[j].start >= intervals[i].end) {
                        if (intervals[j].start < min) {
                            min = intervals[j].start;
                            result[i] = j;
                        }
                    }
                }
            }
            return result;
        }
    }

    // 击败97.49%
    class Solution {
        public int[] findRightInterval(Interval[] intervals) {
            IndexedInterval[] indexedIntervals = new IndexedInterval[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                indexedIntervals[i] = new IndexedInterval(intervals[i], i);
            }

            // 題目中假设了每隔interval的end都比自己的start大, 每个interval的start都不相同
            Arrays.sort(indexedIntervals, new Comparator<IndexedInterval>() {
                @Override
                public int compare(IndexedInterval o1, IndexedInterval o2) {
                    return o1.interval.start - o2.interval.start;
                }
            });

            int[] result = new int[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                result[i] = -1;
                int low = 0, high = indexedIntervals.length - 1;
                while (low <= high) {
                    if (low == high && indexedIntervals[low].interval.start >= intervals[i].end) {
                        result[i] = indexedIntervals[low].index;
                        break;
                    }
                    int mid = (low + high) >> 1;
                    if (indexedIntervals[mid].interval.start >= intervals[i].end) {
                        high = mid;
                        result[i] = indexedIntervals[mid].index;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            return result;
        }

        class IndexedInterval {
            Interval interval;
            int index;

            public IndexedInterval(Interval interval, int index) {
                this.index = index;
                this.interval = interval;
            }
        }
    }
}
