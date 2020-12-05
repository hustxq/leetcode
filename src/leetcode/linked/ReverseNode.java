package leetcode.linked;

import java.util.Arrays;
import java.util.List;

public class ReverseNode {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        ListNode head = Utils.list2Link(list);
        head = reverse(head);
        Utils.visit(head);
    }

    static public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = null;
        ListNode reverseNode = reverse(next);
        next.next = head;
        return reverseNode;
    }


}
