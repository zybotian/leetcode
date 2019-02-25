package array;

/**
 * @author tianbo
 * @date 2019-02-25
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(0));
        System.out.println(solution.fib(1));
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));
    }

    static class Solution {
        public int fib(int N) {
            if (N == 0) {
                return 0;
            }
            if (N == 1) {
                return 1;
            }
            int f0 = 0;
            int f1 = 1;
            int sum = 0;
            for (int i = 2; i <= N; i++) {
                sum = f0 + f1;
                f0 = f1;
                f1 = sum;
            }
            return sum;
        }
    }
}
