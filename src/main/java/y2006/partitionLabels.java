package y2006;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class partitionLabels {
    public static void main(String[] args) {
        partitionLabels partitionLabels = new partitionLabels();
        System.out.println(partitionLabels.partitionLabels("abacbc"));
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels.partitionLabels("caedbdedda"));
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            lastIndex.put(s.charAt(i), i);
        }

        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            end = Math.max(end, lastIndex.get(s.charAt(i)));
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
