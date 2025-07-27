package D0725;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class groupAnagrams {

    public static void main(String[] args) {
        String[] strings1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strings2 = {""};
        String[] strings3 = {"a"};
        groupAnagrams groupAnagrams = new groupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(strings1));
        System.out.println(groupAnagrams.groupAnagrams(strings2));
        System.out.println(groupAnagrams.groupAnagrams(strings3));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String encodedStr = encode(str);
            List<String> list = map.get(encodedStr);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(encodedStr, list);
        }
        return new ArrayList<>(map.values());
    }

    private String encode(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        int[] charsCount = new int[26];
        for (int i = 0, len = str.length(); i < len; i++) {
            charsCount[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charsCount.length; i++) {
            if (charsCount[i] > 0) {
                sb.append((char) ('a' + i)).append(charsCount[i]);
            }
        }
        return sb.toString();
    }
}