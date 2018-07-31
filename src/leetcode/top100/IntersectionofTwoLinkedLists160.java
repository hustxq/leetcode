package leetcode.top100;

/**
 * Created by qxiong on 2018/2/28 0028.
 */
public class IntersectionofTwoLinkedLists160 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode thead = new ListNode(4);
        ListNode thead2 = new ListNode(5);
        ListNode tnode1 = new ListNode(1);
        ListNode tnode2 = new ListNode(2);
        ListNode tnode3 = new ListNode(3);
        thead.next = thead2;
        thead2.next = tnode1;
        tnode1.next = tnode2;
        tnode2.next = tnode3;

        ListNode res = getIntersectionNode(head, null);
        printListNode(res);

        /*// 打印反转前的链表
        ListNode h = head;
        printListNode(h);
        // 调用反转方法  
        head = reverse(head);

        System.out.println("\n**************************");
        // 打印反转后的结果  
        printListNode(head);*/
    }

    private static void printListNode(ListNode head) {
        ListNode tmp = head;
        while (null != tmp) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
//        System.out.println(lengthA);
        int lengthB = getLength(headB);
//        System.out.println(lengthB);

        ListNode ta = headA;
        ListNode tb = headB;
//        int min = Math.min(lengthA,lengthB);
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                ta = ta.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                tb = tb.next;
            }
        }

        while (ta != null && tb != null) {
            if (ta.val == tb.val) {
                return ta;
            }
            ta = ta.next;
            tb = tb.next;
        }

        return ta;
    }

    static private int getLength(ListNode head) {
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 改变链表结构
     *
     * @param headA
     * @param headB
     * @return
     */

    static public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode ha = reverse(headA);
        ListNode hb = reverse(headB);
        ListNode ta = ha;
        ListNode tb = hb;
        printListNode(ta);
        printListNode(tb);
        ListNode tmp = null;

        while ((ta != null && tb != null) && ta.val == tb.val) {
            tmp = ta;
            ta = ta.next;
            tb = tb.next;
        }
        if (tmp != null) {
            tmp.next = null;
            return reverse(ha);
        }

        return null;

    }

    static public ListNode reverse2(ListNode head) {
        if (head == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
//        ListNode tmp;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
        head.next = null;
        return pre;
    }

    /**
     * 递归方式反转链表
     *
     * @param head
     * @return
     */
    static public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sec = head.next;
        head.next = null;
        ListNode reHead = reverse(sec);
        sec.next = head;
        return reHead;
    }
}
