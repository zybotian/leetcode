package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams=new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> codeGroupMap = new HashMap<>();
        for (String str : strs) {
            String code = encode(str);
            List<String> resultList = codeGroupMap.computeIfAbsent(code, l -> new ArrayList<>());
            resultList.add(str);
        }
        return new ArrayList<>(codeGroupMap.values());
    }

    private String encode(String str) {
        char[] charCount = new char[26];
        for (int i = 0, size = str.length(); i < size; i++) {
            int delta = str.charAt(i) - 'a';
            charCount[delta]++;
        }
        return new String(charCount);
    }
}
