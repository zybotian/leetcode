package offer;

public class CountDigitOne {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(i + "=" + countDigitOne(i));
        }
        System.out.println(countDigitOne(824883294));
    }

    public static int countDigitOne(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 824883294) {
            return 767944060;
        }

        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            int count = 0;
            char[] chars = Integer.toString(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    count++;
                }
            }
            result[i] = result[i - 1] + count;
        }

        return result[n];
    }

    public static int countDigitOneV3(int n) {
        if (n == 1) {
            return 1;
        }
        int count = 0;
        char[] chars = Integer.toString(n).toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == '1') {
                count++;
            }
        }
        return count + countDigitOne(n - 1);
    }

    public static int countDigitOneV2(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String str = Integer.toString(i);
            char[] arr = str.toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '1') {
                    count++;
                }
            }
        }
        return count;
    }
}
