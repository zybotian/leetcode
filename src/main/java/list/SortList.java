package list;

import common.ListNode;
import util.ListNodeUtils;

public class SortList {

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.create(new int[]{4, 2, 1, 7, 5, 6, 9, 12, 10, 3});
        SortList sortList = new SortList();
        ListNode listNode = sortList.sortList(head);
        ListNodeUtils.display(listNode);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddleNode(head);
        ListNode next = middle.next;
        middle.next = null;
        ListNode firstPart = sortList(head);
        ListNode secondPart = sortList(next);

        return mergeTwoSortedList(firstPart, secondPart);
    }

    // 1->2->3->4->5
    // 1,2 2,3 3,5
    private ListNode getMiddleNode(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 != null ? list1 : list2;

        return dummy.next;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list1 = head;
        ListNode list2 = slow.next;
        // 断开链表
        slow.next = null;

        ListNode sortedList1 = sortList(list1);
        ListNode sortedList2 = sortList(list2);
        return mergeTwoSortedList(sortedList1, sortedList2);
    }
}
