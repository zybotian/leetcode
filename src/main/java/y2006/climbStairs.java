package y2006;


public class climbStairs {
    // f(n) = f(n-1) +f(n-2)
    // f3=f2+f1
    // f4=f3+f2
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int f1 = 1, f2 = 2;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {
        climbStairs climbStairs = new climbStairs();
        for (int i = 1; i <= 45; i++) {
            System.out.println(climbStairs.climbStairs(i));
        }
    }
}
