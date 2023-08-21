package offer;

import common.ListNode;
import util.ListNodeUtils;

public class FindKthFromTail {

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6
    // k=6
    public static ListNode findKthFromTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                // 总长度都没有k，返回null
                return null;
            }
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(findKthFromTail(head, 1));
        System.out.println(findKthFromTail(head, 2));
        System.out.println(findKthFromTail(head, 3));
        System.out.println(findKthFromTail(head, 4));
        System.out.println(findKthFromTail(head, 5));
        System.out.println(findKthFromTail(head, 6));
        System.out.println(findKthFromTail(head, 7));
        System.out.println(findKthFromTail(head, 8));
        System.out.println(findKthFromTail(head, 10));

    }

}
