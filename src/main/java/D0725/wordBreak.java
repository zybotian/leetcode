package D0725;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class wordBreak {
    public static void main(String[] args) {
        wordBreak wordBreak = new wordBreak();
        List<String> dic1 = Arrays.asList("leet", "code");
        List<String> dic2 = Arrays.asList("apple", "pen");
        List<String> dic3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak.wordBreak("leetcode", dic1));
        System.out.println(wordBreak.wordBreak("applepenapple", dic2));
        System.out.println(wordBreak.wordBreak("catsandog", dic3));
        System.out.println(wordBreak.wordBreak("catsanddog", dic3));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        // result[i]表示字符串s前i个字符是否能被字典拆分
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
}