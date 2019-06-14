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
}
