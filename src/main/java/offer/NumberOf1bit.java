package offer;

/**
 * @author tianbo
 * @date 2019-06-14
 */
public class NumberOf1bit {

    // 对负数不适用, 死循环
    public static int countOfBit1_1(int number) {
        int count = 0;
        while (number != 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number >>= 1;
        }
        return count;
    }

    // 对负数也适用
    public static int countOfBit1_2(int number) {
        int count = 0;
        long exp = 1, data = number;
        for (int i = 1; i <= 32; i++) {
            if ((data & exp) != 0) {
                count++;
            }
            exp <<= 1;
        }

        return count;
    }

    // 有多少个1就循环多少次
    public static int countOfBit1_3(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = number & (number - 1);
        }
        return count;
    }

    // Integer.toBinaryString方法得到二进制字符串,遍历字符串,累计1的个数
    public static int countOfBit1_4(int number) {
        int count = 0;
        String binaryString = Integer.toBinaryString(number);
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 128; i++) {
            System.out.println(i + "=" + countOfBit1_1(i) + "," + countOfBit1_2(i) + "," + countOfBit1_3(i)
                    + "," + countOfBit1_4(i));
        }
        System.out.println(countOfBit1_2(-128));
        System.out.println(countOfBit1_2(-127));
        System.out.println(countOfBit1_3(-128));
        System.out.println(countOfBit1_3(-127));
        System.out.println(countOfBit1_4(-128));
        System.out.println(countOfBit1_4(-127));
    }
}
