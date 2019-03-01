package binarysearch;

import java.util.Arrays;

/**
 * @author tianbo
 * @date 2019-03-01
 */
public class FindRadius {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        System.out.println(solution.findRadius(houses, heaters));

        int[] houses2 = {1, 2, 3};
        int[] heaters2 = {2};
        System.out.println(solution.findRadius(houses2, heaters2));

        int[] houses3 = {1};
        int[] heaters3 = {1, 2, 3, 4};
        System.out.println(solution.findRadius(houses3, heaters3));

        int[] houses4 = {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
        int[] heaters4 = {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840,
                143542612};
        System.out.println(solution.findRadius(houses4, heaters4));
    }

    // 74.29%
    static class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            // 有测试用例并未将heaters排序,这里排序时间复杂度O(n*log(n))
            Arrays.sort(heaters);

            // 默认半径为最小值0
            int radius = 0;
            // 遍历每一个house, 计算它和它左边\右边最近的火炉的距离
            for (int i = 0; i < houses.length; i++) {
                int index = Arrays.binarySearch(heaters, houses[i]);
                if (index < 0) {
                    index = -(index + 1);
                }
                int distanceLeft = index >= 1 ? houses[i] - heaters[index - 1] : Integer.MAX_VALUE;
                int distanceRight = index < heaters.length ? heaters[index] - houses[i] : Integer.MAX_VALUE;

                radius = Math.max(radius, Math.min(distanceLeft, distanceRight));
            }

            return radius;
        }
    }
}
