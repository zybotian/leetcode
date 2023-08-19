package list;

import common.ListNode;
import util.ListNodeUtils;

public class IntersectionNode {

    public static void main(String[] args) {
        IntersectionNode intersectionNode = new IntersectionNode();
        ListNode listNode1 = ListNodeUtils.create(new int[]{4, 1, 8, 4, 5});
        ListNode listNode2 = ListNodeUtils.create(new int[]{5, 6, 1, 8, 4, 5});
        ListNode intersectionNode1 = intersectionNode.getIntersectionNote(listNode1, listNode2);
        System.out.println(intersectionNode1);

        ListNode intersectionNode2 = intersectionNode.getIntersectionNode(listNode1, listNode2);
        System.out.println(intersectionNode2);
    }

    public ListNode getIntersectionNote(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode p = headA;
        while (p != null) {
            lengthA++;
            p = p.next;
        }
        p = headB;
        while (p != null) {
            lengthB++;
            p = p.next;
        }
        int diff = Math.abs(lengthA - lengthB);
        ListNode h1, h2;
        if (lengthA > lengthB) {
            h1 = headA;
            h2 = headB;
        } else {
            h1 = headB;
            h2 = headA;
        }
        while (diff != 0 && h1 != null) {
            diff--;
            h1 = h1.next;
        }

        while (h1 != null && h2 != null && h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
    }
}
