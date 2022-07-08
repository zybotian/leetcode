package offer;

public class TranslateNum {

    public static void main(String[] args) {
        System.out.println(translateNum(12345));
        System.out.println(translateNum(12258));

    }

    public static int translateNum(int num) {
        if (num < 10) {
            return 1;
        }

        char[] chars = String.valueOf(num).toCharArray();
        int[] result = new int[chars.length + 1];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i < chars.length + 1; i++) {
            if (chars[i - 2] == '1' || (chars[i - 2] == '2' && chars[i - 1] >= '2' && chars[i - 1] <= '5')) {
                result[i] = result[i - 2] + result[i - 1];
            } else {
                result[i] = result[i - 1];
            }
        }

        return result[result.length - 1];
    }
}
