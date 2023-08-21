package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tianbo
 * @date 2019-08-22
 */
public class DuplicationInArray {

    /**
     * 时间复杂度O(nlogn) 空间复杂度O(1)
     */
    public static int findDuplication1(int[] array) {
        Arrays.sort(array);

//        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return array[i];
            }
        }

        return -1;
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(n)
     */
    public static int findDuplication2(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                return array[i];
            }
            map.put(array[i], 1);
//            System.out.println(map);
        }

        return -1;
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(1)
     */
    public static int findDuplication3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                // 如果第i个位置的值不等于i
                int tmp = array[i];
                if (tmp == array[tmp]) {
                    return tmp;
                }
                array[i] = array[tmp];
                array[tmp] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array1 = {2, 3, 1, 0, 2, 5, 3};
        int[] array2 = {2, 3, 1, 0, 2, 5, 3};
        int[] array3 = {2, 3, 1, 0, 2, 5, 3};

        System.out.println(findDuplication1(array1));
        System.out.println(findDuplication2(array2));
        System.out.println(findDuplication3(array3));

    }
}
