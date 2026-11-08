package y2006;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        // dp[i] 表示 s 的前 i 个字符是否能被字典拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        wordBreak wordBreak = new wordBreak();
        System.out.println(wordBreak.wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(wordBreak.wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(wordBreak.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
