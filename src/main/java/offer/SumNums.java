package offer;

public class SumNums {

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(sumNums(i) + "=" + sumNumsV2(i));
        }
    }

    public static int sumNums(int n) {
        // 1+2+3+..+n=n*(n+1)/2=(n^2+n)/2
        return ((int) Math.pow(n, 2) + n) >> 1;
    }

    public static int sumNumsV2(int n) {
        int ans = n;
        boolean flag = ans > 0 && (ans += sumNums(n - 1)) > 0;
        return ans;
    }
}
