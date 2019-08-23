package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianbo
 * @date 2019-08-23
 */
public class FirstNotRepeatingChar {

    // 时间复杂度O(n) 空间复杂度O(1)
    public static char firstChar(char[] chars) {
        // hash表统计每个字符出现次数
        Map<Character, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer count = hashTable.getOrDefault(chars[i], 0);
            hashTable.put(chars[i], count + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (hashTable.get(chars[i]) == 1) {
                return chars[i];
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o', 'h', 'e', 'y'};
        System.out.println(firstChar(chars));
    }
}
