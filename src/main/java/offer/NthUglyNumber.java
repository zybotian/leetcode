package offer;

public class NthUglyNumber {
    public static void main(String[] args) {
        for (int i = 1; i < 1690; i++) {
            System.out.println(nthUglyNumber(i) + "=" + nthUglyNumber2(i));
        }
    }

    public static int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }


    // {2,4,6,8,10}
    public static int nthUglyNumber2(int n) {
        if (n == 1) {
            return 1;
        }

        int d2 = 0, d3 = 0, d5 = 0;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            int tmp2 = result[d2] * 2;
            int tmp3 = result[d3] * 3;
            int tmp5 = result[d5] * 5;
            result[i] = Math.min(tmp2, Math.min(tmp3, tmp5));

            if (result[i] == tmp2) {
                d2++;
            }

            if (result[i] == tmp3) {
                d3++;
            }

            if (result[i] == tmp5) {
                d5++;
            }

        }
        return result[n - 1];
    }
}
