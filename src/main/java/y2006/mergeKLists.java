package y2006;

import common.ListNode;
import util.ListNodeUtils;

public class mergeKLists {
    public static void main(String[] args) {
        ListNode listNode1 = ListNodeUtils.create(new int[]{1, 4, 7, 10, 13});
        ListNode listNode2 = ListNodeUtils.create(new int[]{2, 5, 8, 11, 14, 15});
        ListNode listNode3 = ListNodeUtils.create(new int[]{3, 6, 9, 12});
        ListNode[] lists = new ListNode[]{listNode1, listNode2, listNode3};
        mergeKLists mergeKLists = new mergeKLists();
        ListNode listNode = mergeKLists.mergeKLists(lists);
        ListNodeUtils.display(listNode);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (end - start == 0) {
            return lists[start];
        }
        if (end - start == 1) {
            return mergeTwoLists(lists[start], lists[end]);
        }
        int mid = (start + end) / 2;
        ListNode listNode1 = mergeKLists(lists, start, mid);
        ListNode listNode2 = mergeKLists(lists, mid + 1, end);
        return mergeTwoLists(listNode1, listNode2);
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
