package offer;

public class FindNthDight {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(findNthDigit(i));
        }
    }

    public static int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
