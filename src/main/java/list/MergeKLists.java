package list;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {


    public ListNode mergeKListsV2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(list -> list.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }

        ListNode result = new ListNode(0);
        ListNode curr = result;

        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            curr.next = min;
            curr = min;
            if (min.next != null) {
                queue.add(min.next);
            }
        }

        return result.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        // length>=2
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (end == start) {
            return lists[start];
        }
        if (end - start == 1) {
            return mergeTwoLists(lists[start], lists[end]);
        }
        int mid = (end - start) / 2 + start;
        return mergeTwoLists(mergeKLists(lists, start, mid), mergeKLists(lists, mid + 1, end));
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        if (list1 == list2) {
            return list1;
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
