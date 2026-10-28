package y2006;

import common.ListNode;
import util.ListNodeUtils;

import java.util.HashSet;
import java.util.Set;

public class detectCycle {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.create(new int[]{3, 2, 0, -4});
        listNode.next.next.next.next = listNode.next;
        detectCycle detectCycle = new detectCycle();
        ListNode listNode1 = detectCycle.detectCycle(listNode);
        System.out.println(listNode1.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        // 快慢指针法，快慢指针相遇时，新一个指针从head开始，slow从相遇节点开始，二者每次都一步，相遇节点即为环的入口节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }
}
