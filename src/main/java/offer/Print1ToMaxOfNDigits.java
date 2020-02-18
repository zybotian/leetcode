package offer;

import java.util.Arrays;

/**
 * @author tianbo
 * @date 2019-07-17
 */
public class Print1ToMaxOfNDigits {

    // 输入3, 则输出1~999(最大的3位数是999)
    public static void print1ToMaxOfNDigits(int n) {
        // 创建长度为n的数组
        char[] digits = new char[n];
        Arrays.fill(digits, '0');

        // 将第0位依次设置为0~9,递归处理后面的n-1位
        for (int i = 0; i < 10; i++) {
            digits[0] = (char) (i + '0');
            print1ToMaxOfNDigits(digits, n, 0);
        }
    }

    private static void print1ToMaxOfNDigits(char[] digits, int n, int cur) {
        if (cur == n - 1) {
            // 当前处理到了最后一位,输出
            print(digits);
        } else {
            // 当前还没到最后一位
            for (int i = 0; i < 10; i++) {
                digits[cur + 1] = (char) (i + '0');
                print1ToMaxOfNDigits(digits, n, cur + 1);
            }
        }
    }

    private static void print(char[] digits) {
        System.out.println(Integer.parseInt(new String(digits)));
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }

}
