package offer;

public class ReverseLeftChars {

    // a b c d e f g    2
    // g f e d c b a    [0, 6]
    // c d e f g b a    [0, 4]
    // c d e f g a b    [5, 6]
    public String reverseLeftWordsV2(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0) {
            return null;
        }

        char[] chars = s.toCharArray();
        // 整体reverse一次
        reverse(chars, 0, chars.length - 1);
        // 左边部分reverse
        reverse(chars, 0, chars.length - 1 - n);
        // 右边部分reverse
        reverse(chars, chars.length - n, chars.length - 1);

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseLeftChars reverseLeftChars = new ReverseLeftChars();
        System.out.println(reverseLeftChars.reverseLeftWordsV2("abcdefg", 2));
        System.out.println(reverseLeftChars.reverseLeftWordsV2("lrloseumgh", 6));
    }
}
