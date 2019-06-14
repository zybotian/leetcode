package offer;

import common.ListNode;

/**
 * @author tianbo
 * @date 2019-06-14
 */
public class LinkListCircle {

    public static ListNode getCircleEntry(ListNode head) {
        // 链表头为null,直接返回null
        if (head == null) {
            return null;
        }

        // 慢指针指向头结点
        ListNode slow = head;
        // 快指针指向慢指针的next节点
        ListNode fast = slow.next;

        // 快指针指向的节点为null, 说明链表只有头结点
        if (fast == null) {
            // 如果头结点的next是头结点,说明有环,否则,无环
            return head.next == head ? head : null;
        }

        // 快指针和慢指针都没有指向null的时候循环
        while (fast != null && slow != null) {
            // 快指针和慢指针指向的节点相同,说明链表有环,且两个指针指向的节点就是环的入口
            if (fast == slow) {
                return fast;
            }
            // 慢指针每次走一步
            slow = slow.next;

            // 快指针每次走两步
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        // 快指针和慢指针任何一个走到了链表结尾,则链表无环
        return null;
    }


    public static int getCountNodeOfCircle(ListNode head) {
        // 先找到环的入口节点
        ListNode circleEntry = getCircleEntry(head);
        // 无环, 返回0
        if (circleEntry == null) {
            return 0;
        }
        // 有环
        int count = 1;
        ListNode p = circleEntry.next;
        // 遍历环,计数
        while (p != null && p != circleEntry) {
            count++;
            p = p.next;
        }

        return count;
    }

    public static void main(String[] args) {
        ListNode head1 = createListNode1();
        ListNode head2 = createListNode2();
        ListNode head3 = createListNode3();
        ListNode head4 = createListNode4();

        System.out.println(getCircleEntry(head1));
        System.out.println(getCircleEntry(head2));
        System.out.println(getCircleEntry(head3));
        System.out.println(getCircleEntry(head4));

        System.out.println(getCountNodeOfCircle(head1));
        System.out.println(getCountNodeOfCircle(head2));
        System.out.println(getCountNodeOfCircle(head3));
        System.out.println(getCountNodeOfCircle(head4));
    }

    private static ListNode createListNode1() {
        // 只有一个节点,无环
        ListNode head = new ListNode(1);
        return head;
    }


    private static ListNode createListNode2() {
        // 只有一个节点, 有环
        ListNode head = new ListNode(1);
        head.next = head;
        return head;
    }

    private static ListNode createListNode3() {
        // 多个节点, 无环
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }

    private static ListNode createListNode4() {
        // 多个节点, 有环
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        return node1;
    }

}
