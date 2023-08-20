package list;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKListsV3(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeKListsV2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        // 定义一个优先级队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(listNode -> listNode.val));

        // 遍历数组，将数组中每个链表的表头元素添加到队列中
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!queue.isEmpty()) {
            ListNode currentMin = queue.poll();
            curr.next = currentMin;
            curr = currentMin;
            if (currentMin.next != null) {
                queue.add(currentMin.next);
            }
        }

        return dummy.next;
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
        curr.next = list1 == null ? list2 : list1;

        return dummy.next;
    }

}
