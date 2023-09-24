package dp;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (result[j] && dict.contains(s.substring(j, i))) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }

        boolean res = false;
        for (int i = 0, size = wordDict.size(); i < size; i++) {
            if (s.startsWith(wordDict.get(i))) {
                res = res || wordBreak(s.substring(wordDict.get(i).length()), wordDict);
                if (res) {
                    return true;
                }
            }
        }
        return res;
    }
}
