package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringByLoop {
    public static void main(String[] args) {
        LongestSubstringByLoop longestSubstring = new LongestSubstringByLoop();
        System.out.println(longestSubstring.lengthOfLongestSubstring("abba"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("qwertyuiop"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("asdfasdf"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int result = 0;

        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (right = 0; right < s.length(); right++) {
            if (charIndexMap.containsKey(s.charAt(right))) {
                Integer index = charIndexMap.get(s.charAt(right));
                left = Math.max(index + 1, left);
            }

            charIndexMap.put(s.charAt(right), right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
