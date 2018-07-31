package leetcode.top100;

/**
 * Created by qxiong on 2018/1/12.
 */
public class MergeTwoSortedLists21 {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        h.next = n2;
        n2.next = n3;
        ListNode res = mergeTwoLists(h, new ListNode(0));
//        System.out.println(res.val);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            ListNode t;
            if (l1.val < l2.val) {
                t = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                t = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur.next = t;
            cur = cur.next;
        }
        while (l1 != null) {
            ListNode t = new ListNode(l1.val);
            cur.next = t;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = new ListNode(l2.val);
            cur = cur.next;
            l2 = l2.next;
        }
        /*cur = res.next;
        while (cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }*/
        return res.next;
    }
}
