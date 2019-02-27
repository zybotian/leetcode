package twopointers;

import java.util.*;

/**
 * @author tianbo
 * @date 2019-02-27
 */
public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels test = new PartitionLabels();
        Solution solution = test.new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(solution.partitionLabels("caedbdedda"));
        System.out.println(solution.partitionLabels("qiejxqfnqceocmy"));
    }

    class Solution {
        public List<Integer> partitionLabels(String S) {
            char[] chars = S.toCharArray();
            Map<Character, Pair> map = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                char charAt = chars[i];
                Pair pair = map.get(charAt);
                if (pair == null) {
                    pair = new Pair(i, i);
                    map.put(charAt, pair);
                } else {
                    pair.last = i;
                }
            }

            List<Integer> result = new LinkedList<>();

            int i = 0;
            while (i < chars.length) {
                // 第一个字符
                char first = chars[i];
                Pair pair = map.get(first);
                // 第一个字符的起始下标区间
                int start = pair.first, end = pair.last;
                // 初始化的最小最大下标区间
                int min = start, max = end;
                for (int s = start; s <= end; s++) {
                    Pair tmpPair = map.get(chars[s]);
                    min = Math.min(min, tmpPair.first);
                    if (max < tmpPair.last) {
                        // end可能扩大
                        end = tmpPair.last;
                    }
                    max = Math.max(max, tmpPair.last);
                }
                result.add(max + 1 - min);
                i = max + 1;
            }

            return result;
        }

        class Pair {
            int first;
            int last;

            public Pair(int first, int last) {
                this.first = first;
                this.last = last;
            }

        }
    }
}
