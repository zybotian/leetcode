package string;

import java.util.HashSet;
import java.util.Set;

class LongestSubStringBySetSize {

    public static void main(String[] args) {
        LongestSubStringBySetSize longestSubstring = new LongestSubStringBySetSize();
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

        int right = 0;
        int result = 0;


        while (right < s.length()) {
            Set<Character> set = new HashSet<>();

            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
            }
            result = Math.max(result, set.size());
        }
        return result;
    }

}