package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tianbo
 * @date 2019-07-17
 */
public class Print1ToMaxOfNDigits {

    static List<String> result = new ArrayList<>();

    public static int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] result = new int[max - 1];
        for (int i = 1; i < max; i++) {
            result[i - 1] = i;
        }
        return result;
    }


    public static int[] printNumbersV2(int n) {
        List<String> list = new ArrayList<>();
        String number = "1";
        list.add(number);
        while (true) {
            boolean all9 = true;
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) != '9') {
                    all9 = false;
                    break;
                }
            }
            if (all9 && number.length() == n) {
                break;
            }
            number = addTwo(number, "1");
            list.add(number);
        }
        int[] data = new int[list.size()];
        for (int i = 0, size = list.size(); i < size; i++) {
            data[i] = Integer.parseInt(list.get(i));
        }
        return data;
    }

    private static String addTwo(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return str1 == null ? str2 : str1;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = chars1.length - 1, j = chars2.length - 1; i >= 0 || j >= 0; i--, j--) {
            int data1 = i >= 0 ? chars1[i] - '0' : 0;
            int data2 = j >= 0 ? chars2[j] - '0' : 0;
            int sum = data1 + data2 + carry;
            carry = sum / 10;
            sum %= 10;
            sb.append(sum);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

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
            String tmp = print(digits);
            if (!"".equals(tmp)) {
                result.add(tmp);
            }
        } else {
            // 当前还没到最后一位
            for (int i = 0; i < 10; i++) {
                digits[cur + 1] = (char) (i + '0');
                print1ToMaxOfNDigits(digits, n, cur + 1);
            }
        }
    }

    private static String print(char[] digits) {
        int index = 0;

        while (index < digits.length && digits[index] == '0') {
            index++;
        }

        if (index >= digits.length) {
            return "";
        }

        return new String(digits, index, digits.length - index);
    }

    public static void main(String[] args) {
        // 12345-> 12346
        print1ToMaxOfNDigits(3);
        result.stream().forEach(System.out::println);
    }
}
