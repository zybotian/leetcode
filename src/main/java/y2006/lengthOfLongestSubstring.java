package y2006;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        lengthOfLongestSubstring lengthOfLongestSubstring = new lengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkews"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("S"));

    }

    // 输入: s = "abcabcbb"
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int result = 0, len = s.length();
        Set<Character> window = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int j = i;
            while (j < len) {
                if (window.contains(s.charAt(j))) {
                    result = Math.max(result, window.size());
                    window.clear();
                    break;
                } else {
                    window.add(s.charAt(j));
                    j++;
                }
            }
        }

        return result;
    }
}
