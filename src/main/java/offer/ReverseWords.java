package offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();

        System.out.println(reverseWords.reverseWords("we are family"));
        System.out.println(reverseWords.reverseWords("  we     are  family! "));
        System.out.println(reverseWords.reverseWords(" we  are  family,  hehe "));
        System.out.println(reverseWords.reverseWords("the sky is blue"));
        System.out.println(reverseWords.reverseWords("  hello world!  "));
        System.out.println(reverseWords.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return "";
        }

        // split
        String[] strings = s.trim().split("\\s+");
        // reverse
        List<String> words = Arrays.asList(strings);
        Collections.reverse(words);
        // join
        return String.join(" ", words);
    }

    public String reverseWordsV2(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return "";
        }

        char[] chars1 = s.trim().toCharArray();

        // 先整体逆序一次
        String reversed = reverse(chars1, 0, chars1.length - 1);

        // 再每个单词逆序一次
        char[] chars2 = reversed.trim().toCharArray();
        int i = 0, j = 0, size = chars2.length;
        StringBuilder sb = new StringBuilder();
        while (i < size && j < size) {
            while (i < size && chars2[i] == ' ') {
                i++;
            }
            // i指向第一个非空格字符
            j = i;
            while (j < size && chars2[j] != ' ') {
                j++;
            }
            // j指向第一个空格
            String word = reverse(chars2, i, j - 1);
            if (!"".equals(word)) {
                sb.append(word + " ");
            }
            i = j;
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private String reverse(char[] chars, int start, int end) {
        int left = start, right = end;

        while (left < right && start < chars.length && end < chars.length) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(Arrays.copyOfRange(chars, start, end + 1));
    }
}
