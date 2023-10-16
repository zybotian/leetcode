package string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
    }

    // 2,0,2,1,1,0
    // 0,0,2,1,1,2
    //
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (window.containsKey(s.charAt(i))) {
                left = Math.max(left, window.get(s.charAt(i)) + 1);
                window.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            } else {
                window.put(s.charAt(i), i);
            }
            // abba
        }

        return max;
    }
}
