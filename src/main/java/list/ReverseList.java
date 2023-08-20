package list;

import common.ListNode;
import util.ListNodeUtils;

public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode1 = ListNodeUtils.create(new int[]{1, 2, 3, 4, 5});
        ListNode listNode2 = ListNodeUtils.create(new int[]{1, 2});
        ReverseList reverseList = new ReverseList();
        ListNode listNode11 = reverseList.reverseList(listNode1);
        ListNodeUtils.display(listNode11);

        ListNode listNode22 = reverseList.reverseList(listNode2);
        ListNodeUtils.display(listNode22);
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
