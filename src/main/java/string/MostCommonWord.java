package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tianbo
 * @date 2019-03-08
 */
public class MostCommonWord {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(solution.mostCommonWord(paragraph, banned));
        // "Bob. hIt, baLl"
        // ["bob", "hit"]
        String paragraph2 = "Bob. hIt, baLl";
        String[] banned2 = {"bob", "hit"};
        System.out.println(solution.mostCommonWord(paragraph2, banned2));
    }

    // 击败91.88%
    static class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < banned.length; i++) {
                set.add(banned[i]);
            }

            Map<String, Integer> map = new HashMap<>();

            int max = Integer.MIN_VALUE;
            String tmp = null;
            // 加个特殊符号,保证最后一个单词能被正确处理
            paragraph += ".";
            StringBuilder sb = new StringBuilder();
            int length = paragraph.length();
            for (int i = 0; i < length; i++) {
                char ch = paragraph.charAt(i);
                if (Character.isLetter(ch)) {
                    sb.append(ch);
                } else if (sb.length() > 0) {
                    String cur = sb.toString().trim().toLowerCase();
                    sb.setLength(0);
                    if (cur.isEmpty() || set.contains(cur)) {
                        continue;
                    }
                    Integer integer = map.get(cur);
                    if (integer == null) {
                        map.put(cur, 1);
                    } else {
                        map.put(cur, 1 + map.get(cur));
                    }
                    Integer count = map.get(cur);
                    if (count > max) {
                        max = count;
                        tmp = cur;
                    }
                }
            }
            return tmp;
        }
    }

    // 击败38.54%, 效率一般
    static class Solution1 {
        // !?',;.
        public String mostCommonWord(String paragraph, String[] banned) {
            String[] words = paragraph.split("\\!|\\?|\\'|\\,|\\;|\\.|\\ ");

            Set<String> set = new HashSet<>();
            for (int i = 0; i < banned.length; i++) {
                set.add(banned[i]);
            }
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i].toLowerCase().trim();
                if (word.isEmpty()) {
                    continue;
                }
                if (set.contains(word)) {
                    continue;
                }
                Integer integer = map.get(word);
                if (integer == null) {
                    map.put(word, 1);
                } else {
                    map.put(word, map.get(word) + 1);
                }
            }
            int max = Integer.MIN_VALUE;
            String tmp = null;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                Integer count = entry.getValue();
                if (count > max) {
                    max = count;
                    tmp = entry.getKey();
                }
            }
            return tmp;
        }
    }
}
