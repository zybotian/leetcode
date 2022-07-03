package offer;

import common.ListNode;
import util.ListNodeUtils;

import java.util.HashSet;
import java.util.Set;

public class IntersectionNode {

    public static void main(String[] args) {
        IntersectionNode intersectionNode = new IntersectionNode();
        System.out.println(intersectionNode.length(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5})));
        System.out.println(intersectionNode.length(ListNodeUtils.create(new int[]{1, 2, 3, 4})));
        System.out.println(intersectionNode.length(ListNodeUtils.create(new int[]{1, 2, 3})));
        System.out.println(intersectionNode.length(ListNodeUtils.create(new int[]{1})));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        /**
         * 两个链表相交的情况：
         * 链表A在AB交点前有a个元素，在交点后有c个元素，A的总长度=a+c+1
         * 链表B在AB交点前有b个元素，在交点后有c个元素，B的总长度=b+c+1
         * P先走链表A，走完A之后，再走B，一直走到AB交点出，则P走过的路径=a+c+1+b+1=a+b+c+2
         * Q先走链表B，走完B之后，再走A，一直走到AB交点出，则Q走过的路径=b+c+1+a+1=a+b+c+2
         *
         * 两个链表不相交的情况：
         * 链表A有a个元素，A的总长度=a
         * 链表B有b个元素，B的总长度=b
         * P先走链表A，走完A之后，再走B，一直走完B，则P走过的路径=a+b
         * Q先走链表B，走完B之后，再走A，一直走完A，则Q走过的路径=b+a
         */
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    public ListNode getIntersectionNodeV3(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode p = headA;
        while (p != null) {
            visited.add(p);
            p = p.next;
        }

        p = headB;
        while (p != null) {
            if (visited.contains(p)) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        int sizeA = length(headA);
        int sizeB = length(headB);

        ListNode p = headA, q = headB;

        if (sizeA > sizeB) {
            int diff = sizeA - sizeB;
            for (int i = 0; i < diff; i++) {
                p = p.next;
            }
        } else if (sizeB > sizeA) {
            int diff = sizeB - sizeA;
            for (int i = 0; i < diff; i++) {
                q = q.next;
            }
        }

        while (p != null && q != null && p != q) {
            p = p.next;
            q = q.next;
        }

        return p != null && q != null ? p : null;
    }

    private int length(ListNode headA) {
        int length = 0;
        ListNode p = headA;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

}
