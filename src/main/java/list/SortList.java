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
        while (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }
        while (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
