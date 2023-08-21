package list;

import common.ListNode;
import util.ListNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome instance = new Palindrome();

        ListNode listNode = ListNodeUtils.create(new int[]{1, 2, 2, 1});
        System.out.println(instance.isPalindrome(listNode));
        ListNodeUtils.display(listNode);

        ListNode listNode2 = ListNodeUtils.create(new int[]{1, 2, 2});
        System.out.println(instance.isPalindrome(listNode2));
        ListNodeUtils.display(listNode2);

        ListNode listNode3 = ListNodeUtils.create(new int[]{1, 2});
        System.out.println(instance.isPalindrome(listNode3));
        ListNodeUtils.display(listNode3);


        ListNode listNode4 = ListNodeUtils.create(new int[]{1});
        System.out.println(instance.isPalindrome(listNode4));
        ListNodeUtils.display(listNode4);


        ListNode listNode5 = ListNodeUtils.create(new int[]{});
        System.out.println(instance.isPalindrome(listNode5));
        ListNodeUtils.display(listNode5);

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        // 先找到前一半的结束节点
        ListNode firstPartEnd = endOfFirstPart(head);
        // 把链表后半部分逆序
        ListNode secondPartStart = reverseList(firstPartEnd.next);

        // 检查变更后的链表是否是回文表
        ListNode p = head, q = secondPartStart;
        while (q != null) {
            if (p.val != q.val) {
                firstPartEnd.next = reverseList(secondPartStart);
                return false;
            }
            p = p.next;
            q = q.next;
        }
        firstPartEnd.next = reverseList(secondPartStart);
        return true;
    }

    // 1->2->2->1
    // step 1: s=0,f=0;
    // step 2: s=1,f=2;
    // 1 -> 2 -> 3 -> 2 -> 1
    // step 1: s=0,f=0;
    // step 2: s=1,f=2;
    // step 3: s=2,f=4;
    // 1->2
    // 1: s=0,f=0;
    private ListNode endOfFirstPart(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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

    public boolean isPalindrome4(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> stack = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            stack.add(p.val);
            p = p.next;
        }

        p = head;
        int q = stack.size() - 1;
        while (p != null) {
            Integer top = stack.get(q);
            if (top != p.val) {
                return false;
            }
            p = p.next;
            q--;
        }
        return q == -1;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        ListNode p = head;
        while (p != null) {
            sb.append(p.val);
            p = p.next;
        }
        return isPalindrome(sb.toString());
    }

    private boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        p = head;
        while (p != null) {
            Integer top = stack.pop();
            if (top != p.val) {
                return false;
            }
            p = p.next;
        }
        return stack.isEmpty();
    }
}
