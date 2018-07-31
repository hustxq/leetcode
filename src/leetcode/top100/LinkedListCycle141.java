package leetcode.top100;

/**
 * Created by qxiong on 2018/2/26 0026.
 */
public class LinkedListCycle141 {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode l1= new ListNode(2);
        h.next = l1;
        ListNode l2= new ListNode(3);
        l1.next = l2;
        l1.next = h;
        System.out.println(hasCycle(h));
    }

    static public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode f = head.next;
        ListNode s = f.next;

        while (f != null && s != null && s.next != null) {
            if (f == s) {
                return true;
            }
            f = f.next;
            s = s.next.next;
        }
        return false;
    }

}
