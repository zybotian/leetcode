package offer;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcab"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        Set<Character> set = new HashSet<>();
        for (int left = 0, right = 0, size = s.length(); right < size; right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
