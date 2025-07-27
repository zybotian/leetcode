package D0725;

import java.util.ArrayList;
import java.util.List;

class findAnagrams {

    public static void main(String[] args) {
        findAnagrams findAnagrams = new findAnagrams();
        System.out.println(findAnagrams.findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams.findAnagrams("abab", "ab"));
        System.out.println(findAnagrams.findAnagrams("acdcaeccde", "c"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return new ArrayList<>();
        }

        int lenStr = s.length();
        int lenPtr = p.length();

        if (lenPtr > lenStr) {
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0, dif = lenStr - lenPtr; i <= dif; i++) {
            int j = i + lenPtr - 1;
            if (isMatch(s, i, j, p)) {
                resultList.add(i);
            }
        }

        return resultList;
    }

    private boolean isMatch(String s, int i, int j, String p) {
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int k = i; k <= j; k++) {
            sCount[s.charAt(k) - 'a']++;
        }

        for (int k = 0, len = p.length(); k < len; k++) {
            pCount[p.charAt(k) - 'a']++;
        }

        for (int k = 0; k < 26; k++) {
            if (sCount[k] != pCount[k]) {
                return false;
            }
        }

        return true;
    }

}