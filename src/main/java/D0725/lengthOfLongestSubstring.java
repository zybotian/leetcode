package D0725;

import java.util.HashSet;
import java.util.Set;

class lengthOfLongestSubstring {

    public static void main(String[] args) {
        lengthOfLongestSubstring lengthOfLongestSubstring = new lengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("p"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("ab"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcdefg"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("acaca"));

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();

        int result = 0;
        for (int i = 0; i < len; i++) {
            Set<Character> window = new HashSet<>();
            int j = i;
            while (j < len && !window.contains(s.charAt(j))) {
                window.add(s.charAt(j));
                j++;
            }
            result = Math.max(result, window.size());
        }
        return result;
    }

}