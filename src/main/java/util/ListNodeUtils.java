package util;

import common.ListNode;

/**
 * @author tianbo
 * @date 2019-06-14
 */
public class ListNodeUtils {

    public static void display(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "\t");
            p = p.next;
        }
        System.out.println("");
    }

    public static ListNode create(int[] data) {
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        for (int i = 0; i < data.length; i++) {
            ListNode curr = new ListNode(data[i]);
            last.next = curr;
            last = curr;
        }
        return dummy.next;
    }
}
