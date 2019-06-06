package string;

/**
 * @author tianbo
 * @date 2019-06-06
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString test = new ReverseWordsInString();
        String words = "the sky is blue";
        // the sky->yks eht->sky the
        System.out.println(test.reverseWords(words));

        System.out.println(test.reverseWords("  hello world!  "));
        System.out.println(test.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        reverseChars(chars, 0, chars.length - 1);
        int start = 0, end = 0;
        StringBuilder sb = new StringBuilder();
        while (end < chars.length) {
            while (end < chars.length && chars[end] != ' ') {
                end++;
            }
            reverseChars(chars, start, end - 1);
            sb.append(String.copyValueOf(chars, start, end - start) + " ");
            while (end < chars.length && chars[end] == ' ') {
                end++;
            }
            start = end;
            end++;
        }
        if (start < chars.length) {
            sb.append(String.copyValueOf(chars, start, end - start));
        }
        return sb.toString().trim();
    }

    private void reverseChars(char[] chars, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }
}
