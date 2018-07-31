package leetcode.top100;

import java.util.Stack;

/**
 * Created by qxiong on 2018/3/12 0012.
 */
public class PalindromeLinkedList234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        printListNode(head);

        ListNode nHead = copy(head);
//        head.next = null;
        printListNode(nHead);
//        printListNode(head);

        System.out.println(isPalindrome2(head));

    }

    private static void printListNode(ListNode head) {
        ListNode tmp = head;
        while (null != tmp) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    static public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;

        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp!=null){
            stack.push(tmp);
            tmp = tmp.next;
        }
        ListNode h = head;
        while (!stack.isEmpty()){
            tmp = stack.pop();
            if (tmp.val!=h.val){
                return false;
            }
            h = h.next;
        }

        return true;
    }
    /**
     *
     * @param head
     * @return
     */
    static public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode reHead = reverse(copy(head));
//        printListNode(reHead);
        while (head != null && reHead != null) {
            if (head.val != reHead.val){
                return false;
            }
            head = head.next;
            reHead = reHead.next;
        }
        return true;
    }

    static private ListNode copy(ListNode head) {
        ListNode nHead = new ListNode(head.val);
        ListNode nNext = nHead;
        ListNode next = head.next;

        while (next != null) {
            ListNode tmp = new ListNode(next.val);
            next = next.next;

            nNext.next = tmp;
            nNext = nNext.next;
        }

        return nHead;
    }

    static private ListNode reverse(ListNode head) {
        if (head == null) return head;

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
        head.next = null;
        return pre;
    }
}
