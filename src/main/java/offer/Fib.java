package offer;

import java.util.Arrays;

public class Fib {

    static int[] cache = new int[101];

    static {
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
    }

    // 递归
    public int fibV3(int n) {
        if (cache[n] > 0) {
            return cache[n];
        }
        for (int i = 3; i <= n; i++) {
            final int res = (fibV3(i - 1) + fibV3(i - 2)) % 1000000007;
            cache[i] = res;
        }
        return cache[n];
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int f0 = 0 % 1000000007, f1 = 1 % 1000000007, result = 0;
        for (int i = 0; i < n - 1; i++) {
            result = (f1 + f0) % 1000000007;
            f0 = f1;
            f1 = result;
        }

        return result;
    }

    public int fibV2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        for (int i = 0; i < 100; i++) {
            System.out.println(fib.fib(i));
        }
    }
}
