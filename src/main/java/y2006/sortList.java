package y2006;

import common.ListNode;
import util.ListNodeUtils;

public class sortList {
    public static void main(String[] args) {
        sortList sortList = new sortList();
        ListNode listNode = ListNodeUtils.create(new int[]{9, 1, 4, 3, 7, 2, 8, 10, 5, 6});
//        ListNodeUtils.display(listNode);
        ListNode listNode1 = sortList.sortList(listNode);
        ListNodeUtils.display(listNode1);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 获取中间节点
        ListNode middle = getMiddle(head);
        ListNode middleNext = middle.next;
        // 中间节点断开
        middle.next = null;
        // 左半部分排序
        ListNode listNode1 = sortList(head);
        // 右半部分排序
        ListNode listNode2 = sortList(middleNext);
        return mergeTwoLists(listNode1, listNode2);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
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

        if (p != null) {
            curr.next = p;
        }

        if (q != null) {
            curr.next = q;
        }
        return dummy.next;
    }
}
