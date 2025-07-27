package D0725;

import common.ListNode;
import util.ListNodeUtils;

class mergeTwoLists {

    public static void main(String[] args) {
        mergeTwoLists mergeTwoLists = new mergeTwoLists();
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        ListNode head2 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(7);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;

        head2.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node = mergeTwoLists.mergeTwoLists(head1, head2);
        ListNodeUtils.display(node);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        ListNode p = list1, q = list2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                pre.next = p;
                pre = p;
                p = p.next;
            } else {
                pre.next = q;
                pre = q;
                q = q.next;
            }
        }

        if (p != null) {
            pre.next = p;
        }
        if (q != null) {
            pre.next = q;
        }

        return dummy.next;
    }

}