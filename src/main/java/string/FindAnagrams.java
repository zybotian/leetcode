package string;

import java.util.*;

public class FindAnagrams {

    public static void main(String[] args) {

        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams.findAnagrams("abab", "ab"));

    }

    public List<Integer> findAnagrams(String s, String p) {
        int lenStr = s.length();
        int lenPtr = p.length();

        if (lenPtr > lenStr) {
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        String encodeP = encodeString(p);
        for (int start = 0, tail = lenStr - lenPtr; start <= tail; start++) {
            int end = start + lenPtr;
            String tmp = s.substring(start, end);
            String encode = encodeString(tmp);
            if (encodeP.equals(encode)) {
                resultList.add(start);
            }
        }
        return resultList;
    }

    private String encodeString(String str) {
        int[] charArray = new int[26];
        for (int i = 0, size = str.length(); i < size; i++) {
            charArray[str.charAt(i) - 'a']++;
        }
        return Arrays.toString(charArray);
    }
}
