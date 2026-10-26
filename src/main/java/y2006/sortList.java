package y2006;

import common.ListNode;
import util.ListNodeUtils;

public class sortList {
    public static void main(String[] args) {
        sortList sortList = new sortList();
        ListNode listNode = ListNodeUtils.create(new int[]{1, 4, 3, 7, 8, 5});
        ListNode listNode1 = sortList.sortList(listNode);
        ListNodeUtils.display(listNode1);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode listNode1 = sortList(head);
        ListNode listNode2 = sortList(middleNext);
        return mergeTwoLists(listNode1, listNode2);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode dummy = new ListNode(0), curr = dummy;
        ListNode p = list1, q = list2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                curr.next = p;
                curr = p;
                p = p.next;
            } else {
                curr.next = q;
                curr = q;
                q = q.next;
            }
        }

        while (p != null) {
            curr.next = p;
            curr = p;
            p = p.next;
        }

        while (q != null) {
            curr.next = q;
            curr = q;
            q = q.next;
        }
        return dummy.next;
    }
}
