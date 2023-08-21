package list;

import common.ListNode;
import util.ListNodeUtils;

public class SwapPairs {
    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode head = ListNodeUtils.create(new int[]{1, 2, 3, 4});
        ListNodeUtils.display(swapPairs.swapPairs(head));

        ListNode head2 = ListNodeUtils.create(new int[]{1});
        ListNodeUtils.display(swapPairs.swapPairs(head2));

        ListNode head3 = ListNodeUtils.create(new int[]{});
        ListNodeUtils.display(swapPairs.swapPairs(head3));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head, curr = head.next;
        while (curr != null) {
            int tmp = pre.val;
            pre.val = curr.val;
            curr.val = tmp;
            pre = curr.next;
            if (pre == null) {
                return head;
            }
            curr = pre.next;
        }
        return head;
    }
}