package D0825;

class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        for (int i = 0; i < 100; i++) {
            System.out.println(fib.fib(i));
        }
    }

    // f(0)=0 f(1)=1 f(n) = f(n-1) + f(n-2)
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            result[i] = (result[i - 2] + result[i - 1]) % 1000000007;
        }

        return result[n];
    }
}