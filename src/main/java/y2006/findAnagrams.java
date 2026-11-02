package y2006;

import java.util.ArrayList;
import java.util.List;

public class findAnagrams {
    public static void main(String[] args) {
        findAnagrams findAnagrams = new findAnagrams();
        List<Integer> result = findAnagrams.findAnagrams("cbaebabacdabc", "abc");
        System.out.println(result);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        if (lenS < lenP) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int left = 0, right = left + lenP - 1;
        String pEncoded = encodeString(p);
        while (right < lenS) {
            if (encodeString(s.substring(left, right + 1)).equals(pEncoded)) {
                result.add(left);
            }
            left++;
            right++;
        }
        return result;
    }

    private String encodeString(String str) {
        char[] charArray = new char[26];
        for (int i = 0, size = str.length(); i < size; i++) {
            charArray[str.charAt(i) - 'a']++;
        }
        return String.valueOf(charArray);
    }
}
