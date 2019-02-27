package twopointers;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-02-27
 */
public class IntervalIntersection {

    class Solution {
        // 双向指针, 击败100%
        public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
            // 有一个数组为空数组, 则返回空
            if (A == null || A.length == 0 || B == null || B.length == 0) {
                return new Interval[0];
            }

            int pa = 0;
            int pb = 0;
            List<Interval> result = new ArrayList<>();

            while (pa < A.length && pb < B.length) {
                if (A[pa].start > B[pb].end) {
                    // A的最小比B的最大大, 说明当前的B太小了, B需要变大点
                    pb++;
                } else if (A[pa].end < B[pb].start) {
                    // A的最大比B的最小小, 说明当前的A太小了, A需要变大点
                    pa++;
                } else {
                    // A[pa].start<=B[pb].end||A[pa].end>=B[pb].start, 此时,有交集
                    Interval tmp = new Interval(Math.max(A[pa].start, B[pb].start), Math.min(A[pa].end, B[pb].end));
                    result.add(tmp);
                    if (pa < A.length - 1 && A[pa + 1].start <= B[pb].end) {
                        // A数组的下一个元素与B数组的当前元素有交集
                        pa++;
                    } else if (pb < B.length - 1 && B[pb + 1].start <= A[pa].end) {
                        // B数组的下一个元素与A数组的当前元素有交集
                        pb++;
                    } else {
                        // A数组的下一个元素与B数组的当前元素没有交集,且B数组的下一个元素与A数组的当前元素没有交集,两个指针都指向下一个元素
                        pa++;
                        pb++;
                    }
                }
            }

            return result.toArray(new Interval[0]);
        }
    }

    class Solution1 {
        // 时间复杂度是平方级别, 击败15.52%
        public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
            // 有一个数组是空数组, 就返回空数组
            if (A.length == 0 || B.length == 0) {
                return new Interval[0];
            }

            // 两个数组长度都不是0
            List<Interval> result = new ArrayList<>();
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if (A[i].end < B[j].start) {
                        break;
                    }

                    // [start1,end1] [start2, end2], 只要start1<=end2并且end1>=start2就有交集
                    if (A[i].start <= B[j].end && A[i].end >= B[j].start) {
                        int start = Math.max(A[i].start, B[j].start);
                        int end = Math.min(A[i].end, B[j].end);
                        Interval tmp = new Interval(start, end);
                        result.add(tmp);
                    }
                }
            }

            return result.toArray(new Interval[0]);
        }
    }

    public static void main(String[] args) {
        IntervalIntersection test = new IntervalIntersection();
        Solution solution = test.new Solution();
        List<Interval> list1 = new ArrayList<>();
        list1.add(test.new Interval(0, 2));
        list1.add(test.new Interval(5, 10));
        list1.add(test.new Interval(13, 23));
        list1.add(test.new Interval(24, 25));

        List<Interval> list2 = new ArrayList<>();
        list2.add(test.new Interval(1, 5));
        list2.add(test.new Interval(8, 12));
        list2.add(test.new Interval(15, 24));
        list2.add(test.new Interval(25, 26));


        System.out.println(Arrays.toString(solution.intervalIntersection(list1.toArray(new Interval[0]),
                list2.toArray(new Interval[0]))));
        System.out.println(Arrays.toString(solution.intervalIntersection(list2.toArray(new Interval[0]),
                list1.toArray(new Interval[0]))));
    }

    // Definition for an interval.
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
