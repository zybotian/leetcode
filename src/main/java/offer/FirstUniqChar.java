package offer;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    public char firstUniqCharV2(String s) {
        int[] count = new int[26];

        for (int i = 0, size = s.length(); i < size; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0, size = s.length(); i < size; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        Map<Character, Integer> map = new HashMap<>();

        // 一次遍历 计数
        for (int i = 0, size = s.length(); i < size; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 二次遍历 找结果
        for (int i = 0, size = s.length(); i < size; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }
}
