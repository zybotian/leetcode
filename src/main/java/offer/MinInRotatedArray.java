package offer;

/**
 * @author tianbo
 * @date 2019-08-22
 */
public class MinInRotatedArray {

    /**
     * 时间复杂度O(n) 空间复杂度O(1)
     */
    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * 时间复杂度O(logn) 空间复杂度O(1)
     */
    public static int findMin2(int[] array) {
        // 没有旋转的情况
        if (array[0] < array[array.length - 1]) {
            return array[0];
        }
        return binSearch(array, 0, array.length - 1);
    }

    private static int binSearch(int[] array, int start, int end) {
        // 递归结束条件是, 左右指针走到相邻位置
        // 右指针指向的就是旋转数组中的最小值 左指针指向的就是旋转数组的最大值
        if (end - start == 1) {
            return array[end];
        }
        int mid = (start + end) / 2;
        if (array[mid] > array[start] && array[mid] > array[end]) {
            // 如果中间值比左边大且比右边大,则左指针指向中间位置
            start = mid;
        } else if (array[mid] < array[start] && array[mid] < array[end]) {
            // 如果中简直比左边小且比右边小,则右指针只想中间位置
            end = mid;
        }
        // 修改左右指针后,递归调用
        return binSearch(array, start, end);
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        int[] array2 = {1, 2, 3, 4, 5};

        System.out.println(findMin(array));
        System.out.println(findMin2(array));
        System.out.println(findMin2(array2));

    }
}
