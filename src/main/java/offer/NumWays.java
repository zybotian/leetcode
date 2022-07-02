package offer;

public class NumWays {
    public static int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
            result[i] %= 1000000007;
        }
        return result[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i <100; i++) {
            System.out.println(numWays(i));
        }

    }
}
