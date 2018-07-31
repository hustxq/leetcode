package leetcode.top100;

/**
 * Created by qxiong on 2018/1/11.
 */
public class RemoveNthNodeFromEndofList19 {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        h.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        System.out.println(lenOfList(h));
        RemoveNthNodeFromEndofList19 test = new RemoveNthNodeFromEndofList19();
        ListNode t = test.removeNthFromEnd(n3, 2);
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        int len = lenOfList(head);
        if (len < n) return null;
        if (n == 0) return head;
        if (len == 1) return null;
        if (len == 2){
            if (n==1){
                head.next = null;
            }else {
                head = head.next;
            }
            return head;
        }
        if (len == n){
            head = head.next;
            return head;
        }
        for (int i = 0, e = len - n - 1; i < e; i++) {
            res = res.next;
        }
        res.next = res.next.next;
        return head;
    }

    static private int lenOfList(ListNode head) {
        if (head == null) return 0;
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }
}
