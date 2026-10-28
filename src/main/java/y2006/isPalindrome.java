package y2006;

import common.ListNode;
import util.ListNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class isPalindrome {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.create(new int[]{1, 2, 2, 4, 2, 2, 1});
        isPalindrome isPalindrome = new isPalindrome();
        System.out.println(isPalindrome.isPalindrome(listNode));
        ListNodeUtils.display(listNode);
    }

    // 53%
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode middle = getMiddleNode(head);
        middle = reverseList(middle);
        ListNode p1 = head, p2 = middle;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        reverseList(middle);
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 头插法
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 5%
    public boolean isPalindrome3(ListNode head) {
        if (head == null) {
            return false;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        p = head;
        while (!stack.isEmpty() && p != null) {
            if (stack.peek().val != p.val) {
                return false;
            }
            p = p.next;
            stack.pop();
        }
        return true;
    }

    // 30%
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> nums = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nums.add(p.val);
            p = p.next;
        }
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            if (!Objects.equals(nums.get(left), nums.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
