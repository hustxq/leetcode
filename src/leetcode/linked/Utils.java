package leetcode.linked;

import java.util.List;

public class Utils {

    /**
     * 遍历链表
     *
     * @param head
     */
    public static void visit(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    /**
     * 根据list 创建链表
     *
     * @param list
     * @return
     */
    public static ListNode list2Link(List<Integer> list) {
        ListNode head = null;
        if (list == null || list.size() == 0) {
            return head;
        }

        head = new ListNode(list.get(0));
        ListNode first = head;
        int size = list.size();

        for (int i = 1; i < size; i++) {
            ListNode tmp = new ListNode(list.get(i));
            first.next = tmp;
            first = tmp;
        }

        return head;
    }
}
