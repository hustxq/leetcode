package leetcode.linked;

import java.util.Arrays;
import java.util.List;

public class OddEvenList328 {

    static public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = first.next;
        ListNode tmp;

        while (second != null) {
            tmp = second.next;
            if (tmp != null) {
                second.next = tmp.next;
                tmp.next = first.next;
                first.next = tmp;
            }

            first = first.next;
            second = second.next;

        }

        return head;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        ListNode head = Utils.list2Link(list);
        oddEvenList(head);
        Utils.visit(head);
    }

}
