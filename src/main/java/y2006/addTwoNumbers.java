package y2006;

import common.ListNode;
import util.ListNodeUtils;

public class addTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode1 = ListNodeUtils.create(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode listNode2 = ListNodeUtils.create(new int[]{9, 9, 9, 9});
        addTwoNumbers addTwoNumbers = new addTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        ListNodeUtils.display(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0), curr = dummy;
        ListNode p = l1, q = l2;

        while (p != null && q != null) {
            int tmpSum = p.val + q.val + carry;
            int tmpRes = tmpSum % 10;
            carry = tmpSum / 10;
            ListNode currentNode = new ListNode(tmpRes);
            curr.next = currentNode;
            curr = currentNode;
            p = p.next;
            q = q.next;
        }

        while (p != null) {
            int tmpSum = p.val + carry;
            int tmpRes = tmpSum % 10;
            carry = tmpSum / 10;
            ListNode currentNode = new ListNode(tmpRes);
            curr.next = currentNode;
            curr = currentNode;
            p = p.next;
        }

        while (q != null) {
            int tmpSum = q.val + carry;
            int tmpRes = tmpSum % 10;
            carry = tmpSum / 10;
            ListNode currentNode = new ListNode(tmpRes);
            curr.next = currentNode;
            curr = currentNode;
            q = q.next;
        }

        if (carry > 0) {
            ListNode currentNode = new ListNode(carry);
            curr.next = currentNode;
            curr = currentNode;
        }
        return dummy.next;
    }
}
