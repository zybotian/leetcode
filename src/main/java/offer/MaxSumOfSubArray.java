package offer;

/**
 * @author tianbo
 * @date 2019-06-17
 */
public class MaxSumOfSubArray {
    public static void main(String[] args) {
        int[] data = {1, -2, 3, 10, 4, -7, 12, -5};
        MaxSumOfSubArray test = new MaxSumOfSubArray();
        System.out.println(test.maxSumOfSubArray(data));
    }

    public int maxSumOfSubArray(int[] data) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            if (sum < 0) {
                sum = 0;
            } else {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
