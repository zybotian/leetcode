package offer;

/**
 * @author tianbo
 * @date 2019-06-13
 */
public class MaxProductOfLines {
    // 长度为n的绳子,剪成m段,要求每段绳子长度的乘积最大

    // 动态规划
    public static int maxProductAfterCuting(int length) {
        if (length <= 1) {
            // 长度为1,直接返回0
            return 0;
        }
        if (length == 2) {
            // 长度为2,直接返回1(1*1)
            return 1;
        }
        if (length == 3) {
            // 长度为3,直接返回2(1*2)
            return 2;
        }

        // 计算length=4: max{2*2}
        // 计算length=5: max{2*3}
        // 计算length=6: max{3*3}
        // 计算length=7: max{3*4}
        // 计算length=8: max{2*3*3}
        // 计算length=9: max{3*3*3}
        // 计算length=10: max{3*3*4}
        int[] results = new int[length + 1];
        results[1] = 1;
        results[2] = 2;
        results[3] = 3;

        for (int i = 4; i <= length; i++) {
            int mid = i >> 1;
            int max = 0;
            for (int j = 1; j <= mid; j++) {
                int pro = results[j] * results[i - j];
                if (max < pro) {
                    max = pro;
                }
            }
            results[i] = max;
        }

        return results[length];
    }

    // 贪婪算法
    public static int maxProductAfterCuting2(int length) {
        if (length <= 1) {
            // 长度为1,直接返回0
            return 0;
        }
        if (length == 2) {
            // 长度为2,直接返回1(1*1)
            return 1;
        }
        if (length == 3) {
            // 长度为3,直接返回2(1*2)
            return 2;
        }
        // 尽可能多地剪长度为3的绳子段
        int timeOf3 = length / 3;

        // 当绳子剩下的长度为4时,不能剪去3因为1*3<2*2
        if (length - timeOf3 * 3 == 1) {
            timeOf3--;
        }
        int timeOf2 = (length - timeOf3 * 3) / 2;
        // 注意这里是*不是+
        return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + " = " + maxProductAfterCuting(i) + "|" + maxProductAfterCuting2(i));
        }
    }
}
