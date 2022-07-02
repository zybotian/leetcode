package offer;

import common.ListNode;
import util.ListNodeUtils;

public class MergeSortedList {

    public static void main(String[] args) {
        ListNode listNode1 = ListNodeUtils.create(new int[]{1, 2, 3, 5, 6, 7});
        ListNode listNode2 = ListNodeUtils.create(new int[]{1, 2, 4, 6, 7, 8});
        ListNode listNode = mergeTwoListsV3(listNode1, listNode2);
        ListNodeUtils.display(listNode1);
        ListNodeUtils.display(listNode2);
        ListNodeUtils.display(listNode);
    }

    public static ListNode mergeTwoListsV3(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode newHead = new ListNode(0);

        if (l1.val <= l2.val) {
            newHead.val = l1.val;
            newHead.next = mergeTwoListsV3(l1.next, l2);
        } else {
            newHead.val = l2.val;
            newHead.next = mergeTwoListsV3(l1, l2.next);
        }

        return newHead;
    }

    /**
     * 不改变原来的链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        while (l1 != null) {
            curr.next = new ListNode(l1.val);
            l1 = l1.next;
            curr = curr.next;
        }
        while (l2 != null) {
            curr.next = new ListNode(l2.val);
            l2 = l2.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    /**
     * 需要创建新元素，但不会改变原来的链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }
}
