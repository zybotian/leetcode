package offer;

import common.ListNode;

import util.ListNodeUtils;

/**
 * @author tianbo
 * @date 2019-06-14
 */
public class ReverseLinklist {

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 多于1个节点
        ListNode newHead = reverse(head.next);
        ListNode p = newHead;
        while (p != null && p.next != null) {
            p = p.next;
        }
        p.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode list = createListNode();
        ListNodeUtils.display(list);
        ListNode node = reverse(list);
        ListNodeUtils.display(node);
    }

    private static ListNode createListNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }
}
