package twopointers;

import java.util.Arrays;

/**
 * @author tianbo
 * @date 2019-02-28
 */
public class NumRescueBoats {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1, 2};
        int[] arr2 = {1, 2, 2, 3};
        int[] arr3 = {3, 3, 4, 5};
        int[] arr4 = {1, 1, 2, 4};
        int[] arr5 = {1, 2, 4, 5};
        int[] arr6 = {1, 3, 4, 7, 8};


        System.out.println(solution.numRescueBoats(arr1, 3));
        System.out.println(solution.numRescueBoats(arr2, 3));
        System.out.println(solution.numRescueBoats(arr3, 5));
        System.out.println(solution.numRescueBoats(arr4, 4));
        System.out.println(solution.numRescueBoats(arr5, 6));
        System.out.println(solution.numRescueBoats(arr6, 9));
    }

    // 击败96.68%
    static class Solution {
        // 正常应该是一个较轻的的一个较重的同坐一艘船, 或者较重的单独一人坐一艘船
        public int numRescueBoats(int[] people, int limit) {
            // 排序, 时间复杂度为o(n*log(n))
            Arrays.sort(people);

            int pa = 0, pb = people.length - 1;
            int count = 0;

            while (pa <= pb) {
                // 要么是pa和pb同坐一艘船, 要么pb自己坐一艘船
                count++;
                // 如果是两个加起来没有超重, 那就是同坐一艘船, pa指向的人必然坐上船了,指针直接指向下一个即可
                if (pa <= pb && people[pa] + people[pb] <= limit) {
                    pa++;
                }
                // pb指向的人必然已经坐上船了,指针直接指向下一个
                pb--;
            }
            return count;
        }
    }
}
