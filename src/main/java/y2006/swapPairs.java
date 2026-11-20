package y2006;

import common.ListNode;
import util.ListNodeUtils;

public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1->2->3->4->5
        ListNode newHead = head.next;//2
        ListNode headNextNext = newHead.next;//3
        ListNode partList = swapPairs(headNextNext);// 4-3-5
        newHead.next = head;// 2-1
        head.next = partList;// 2-1-4-3-5
        return newHead;
    }

    public static void main(String[] args) {
        swapPairs swapPairs = new swapPairs();
        ListNode list1 = swapPairs.swapPairs(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5}));
        ListNodeUtils.display(list1);


        ListNode list2 = swapPairs.swapPairs(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6}));
        ListNodeUtils.display(list2);

        ListNode list3 = swapPairs.swapPairs(ListNodeUtils.create(new int[]{1, 2}));
        ListNodeUtils.display(list3);

        ListNode list4 = swapPairs.swapPairs(ListNodeUtils.create(new int[]{1}));
        ListNodeUtils.display(list4);

        ListNode list5 = swapPairs.swapPairs(ListNodeUtils.create(new int[]{1, 2, 3}));
        ListNodeUtils.display(list5);
    }
}
