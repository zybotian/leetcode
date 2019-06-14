package offer;

import java.util.Arrays;

/**
 * @author tianbo
 * @date 2019-06-14
 */
public class Print1toNDigits {

    public static void print(int length) {
        char[] data = new char[length];
        Arrays.fill(data, '0');

        for (int i = 0; i <= 9; i++) {
            data[0] = (char) ('0' + i);
            printRecursive(data, length, 0);
        }
    }

    private static void printRecursive(char[] data, int length, int index) {
        if (index == length - 1) {
            printStr(data);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            data[index + 1] = (char) ('0' + i);
            printRecursive(data, length, index + 1);
        }
    }

    private static void printStr(char[] data) {
        int i = 0;
        while (i < data.length && data[i] == '0') {
            i++;
        }
        System.out.println(new String(Arrays.copyOfRange(data, i, data.length)));
    }

    public static void main(String[] args) {
        print(3);
    }
}
