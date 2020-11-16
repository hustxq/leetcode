package offer;

import leetcode.linked.ListNode;
import leetcode.linked.Utils;

import java.util.Arrays;

public class GetKthFromEnd22 {

    public static void main(String[] args) {
        ListNode head = Utils.list2Link(Arrays.asList(1, 2, 3, 4, 5));
        ListNode kthFromEnd = getKthFromEnd(head, 6);
        Utils.visit(kthFromEnd);
    }

    static public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0){
            return null;
        }

        ListNode first = head;
        ListNode second = first.next;
        for (int i = 1; i < k; i++) {
            if (second != null) {
                second = second.next;
            }
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

}
