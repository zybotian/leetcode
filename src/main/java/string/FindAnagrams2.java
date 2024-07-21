package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams2 {

    public static void main(String[] args) {

        FindAnagrams2 findAnagrams = new FindAnagrams2();
        System.out.println(findAnagrams.findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams.findAnagrams("abab", "ab"));
        System.out.println(findAnagrams.findAnagrams("abababa", "ab"));
        System.out.println(findAnagrams.findAnagrams("cabc", "ab"));
        System.out.println(findAnagrams.findAnagrams("ccvbab", "ab"));

    }

    public List<Integer> findAnagrams(String s, String p) {
        int lenStr = s.length();
        int lenPtr = p.length();

        if (lenPtr > lenStr) {
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        String encodeP = encodeString(p, 0, lenPtr - 1);
        for (int start = 0, tail = lenStr - lenPtr; start <= tail; start++) {
            int end = start + lenPtr - 1;
            String encode = encodeString(s, start, end);
            if (encodeP.equals(encode)) {
                resultList.add(start);
            }
        }
        return resultList;
    }

    private String encodeString(String str, int start, int end) {
        int[] charArray = new int[26];
        for (int i = start; i <= end; i++) {
            charArray[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (charArray[i] > 0) {
                sb.append(i + 'a');
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }
}
