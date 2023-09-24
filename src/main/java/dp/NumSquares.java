package dp;


public class NumSquares {

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        Long start = System.currentTimeMillis();
        for (int i = 1; i <= 10000; i++) {
            System.out.println(i + "==" + numSquares.numSquares(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("time spend:" + (end - start));
    }

    public int numSquares(int n) {
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                // 是完全平方数，则结果为1
                result[i] = 1;
            } else {
                result[i] = i;
                for (int j = 1; j <= sqrt; j++) {
                    result[i] = Math.min(result[i], result[i - j * j] + 1);
                }
            }
        }
        return result[n];
    }

    public int numSquares2(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return 1;
        }
        int result = n;
        for (int i = 1; i <= sqrt; i++) {
            result = Math.min(result, numSquares(n - i * i) + 1);
        }

        return result;
    }
}
