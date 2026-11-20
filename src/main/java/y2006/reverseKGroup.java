package y2006;

import common.ListNode;
import util.ListNodeUtils;

public class reverseKGroup {

    public static void main(String[] args) {
        reverseKGroup reverseKGroup = new reverseKGroup();
        ListNode list1 = reverseKGroup.reverseKGroup(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5}), 2);
        ListNodeUtils.display(list1);
        ListNode list2 = reverseKGroup.reverseKGroup(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6}), 2);
        ListNodeUtils.display(list2);
        ListNode list3 = reverseKGroup.reverseKGroup(ListNodeUtils.create(new int[]{1, 2}), 2);
        ListNodeUtils.display(list3);
        ListNode list4 = reverseKGroup.reverseKGroup(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 3);
        ListNodeUtils.display(list4);
        ListNode list5 = reverseKGroup.reverseKGroup(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 4);
        ListNodeUtils.display(list5);
        ListNode list6 = reverseKGroup.reverseKGroup(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 5);
        ListNodeUtils.display(list6);
        ListNode list7 = reverseKGroup.reverseKGroup(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 6);
        ListNodeUtils.display(list7);
        ListNode list8 = reverseKGroup.reverseKGroup(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 7);
        ListNodeUtils.display(list8);
        ListNode list9 = reverseKGroup.reverseKGroup(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 8);
        ListNodeUtils.display(list9);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end != null) {
            for (int i = 0; i < k; i++) {
                if (end != null) {
                    end = end.next;
                }
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            ListNode reversedList = reverseList(start);
            pre.next = reversedList;
            end = start;
            pre = end;
            end.next = next;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
