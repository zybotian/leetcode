package D0825;

class climbStairs {
    public static void main(String[] args) {
        climbStairs climbStairs = new climbStairs();
        for (int i = 1; i <= 45; i++) {
            System.out.println(i + "=" + climbStairs.climbStairs(i));
        }
    }

    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        for (int i = 4; i <= n; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }
        return result[n];
    }
}