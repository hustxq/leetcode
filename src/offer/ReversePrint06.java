package offer;

import leetcode.top100.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReversePrint06 {

    static public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        int size = list.size();
        int[] iarr = new int[size];
        for (int i = 0; i < size; i++) {
            iarr[size - 1 - i] = list.get(i);
        }
        return iarr;
    }
}
