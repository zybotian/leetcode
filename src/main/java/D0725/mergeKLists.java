package D0725;

import common.ListNode;
import util.ListNodeUtils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class mergeKLists {

    public static void main(String[] args) {
        mergeKLists mergeKLists = new mergeKLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNodeUtils.create(new int[]{1, 2, 3, 4, 7});
        lists[1] = ListNodeUtils.create(new int[]{3, 4, 4, 5, 8});
        lists[2] = ListNodeUtils.create(new int[]{2, 3, 4, 5, 6});

        ListNode node = mergeKLists.mergeKLists(lists);
        ListNodeUtils.display(node);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode sortedList1 = mergeKLists(lists, start, mid);
        ListNode sortedList2 = mergeKLists(lists, mid + 1, end);
        return mergeTwoLists(sortedList1, sortedList2);
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