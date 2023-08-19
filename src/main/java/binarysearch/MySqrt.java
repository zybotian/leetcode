package binarysearch;

public class MySqrt {

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(2147395599));
        for (int i = 0; i < 1000; i++) {
            System.out.println("sqrt(" + i + ")=" + mySqrt.mySqrt(i));
        }
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long left = 1, right = x / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long tmp = mid * mid;
            if (tmp > x) {
                right = mid - 1;
            } else if (tmp < x) {
                left = mid + 1;
            } else {
                return (int) mid;
            }
        }

        return (int) (left - 1);
    }
}
