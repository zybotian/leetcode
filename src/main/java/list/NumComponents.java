package list;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tianbo
 * @date 2019-02-26
 */
public class NumComponents {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        int[] g = {0, 1, 3};
        int[] g2 = {0, 1, 2, 3};
        int[] g3 = {0, 2};
        int[] g4 = {0, 2, 3};
        int[] g5 = {0, 1, 3};

        System.out.println(solution.numComponents(node0, g));
        System.out.println(solution.numComponents(node0, g2));
        System.out.println(solution.numComponents(node0, g3));
        System.out.println(solution.numComponents(node0, g4));
        System.out.println(solution.numComponents(node0, g5));
    }

    static class Solution {
        public int numComponents(ListNode head, int[] G) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < G.length; i++) {
                set.add(G[i]);
            }

            int count = 0;
            ListNode current = head;
            while (current != null) {
                if (!set.contains(current.val)) {
                    current = current.next;
                    continue;
                }
                Set<Integer> tmp = new HashSet<>();
                tmp.add(current.val);

                ListNode next = current.next;
                while (next != null && set.contains(next.val)) {
                    tmp.add(next.val);
                    next = next.next;
                }
                count++;
                set.removeAll(tmp);
                current = next;
            }
            return count;
        }
    }
}
