package offer;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-06-19
 */
public class SortArrayForMinNumber {

    public static String printMinNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        List<String> numStrList = new ArrayList<>();
        for (int num : nums) {
            numStrList.add(String.valueOf(num));
        }

        Collections.sort(numStrList, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        StringBuilder result = new StringBuilder();
        for (String str : numStrList) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 32, 321};
        System.out.println(printMinNumber(nums1));

        int[] nums2 = {3, 33, 333};
        System.out.println(printMinNumber(nums2));
    }
}
