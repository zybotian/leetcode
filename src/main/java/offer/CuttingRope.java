package offer;

public class CuttingRope {

    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            System.out.println(i + "=" + "=" + cuttingRope4(i) + "=" + cuttingRope5(i));
        }
    }

    public static int cuttingRope5(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int b = n % 3, p = 1000000007;

        long rem = 1, x = 3, a = n / 3;
        // b == 1代表余数为1的时候，需要单独取出一个3出来凑成2*2达到最大值效果
        for (int i = 0; i < ((b == 1) ? a - 1 : a); i++) {
            rem = (rem * x) % p;
        }
        if (b == 0) {
            return (int) (rem % p);
        }
        if (b == 1) {
            return (int) (rem * 4 % p);
        }
        return (int) (rem * 2 % p);
    }

    public static long cuttingRope4(int n) {
        if (n < 4) {
            return n - 1;
        }
        int numOf3 = n / 3;
        int modOf3 = n % 3;
        if (modOf3 == 0) {
            // 是3的倍数
            return (long) (Math.pow(3, numOf3) % 1000000007L);
        } else if (modOf3 == 1) {
            // 余数是1，将最后一个3和最后的1组合成2*2
            return (long) ((Math.pow(3, numOf3 - 1) * 4) % 1000000007L);
        } else {
            // 余数是2
            return (long) ((Math.pow(3, numOf3) * 2) % 1000000007);
        }
    }

    public static int cuttingRope3(int n) {
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = (res * 3) % 1000000007;
            n -= 3;
        }
        return (int) (res * n) % 1000000007;
    }

    public static int cuttingRope2(int n) {
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = (res * 3);
            n -= 3;
        }
        return (int) (res * n);
    }

    // n=1 res=0;
    // n=2 res=1
    // n=3 res=2
    // n=4 res=4
    public static int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        int numOf3 = n / 3;
        int modOf3 = n % 3;
        if (modOf3 == 0) {
            // 是3的倍数
            return (int) Math.pow(3, numOf3);
        } else if (modOf3 == 1) {
            // 余数是1，将最后一个3和最后的1组合成2*2
            return (int) (Math.pow(3, numOf3 - 1)) * 4;
        } else {
            // 余数是2
            return (int) (Math.pow(3, numOf3) * 2);
        }
    }
}
