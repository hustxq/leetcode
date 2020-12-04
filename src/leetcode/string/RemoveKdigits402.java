package leetcode.string;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKdigits402 {

    public static void main(String[] args) {
        String num = "1432219";
        int k = 6;
        System.out.println(removeKdigits(num, k));
    }

    static public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || num.length() <= k) {
            return "0";
        }

        if (k == 0) {
            return num;
        }

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && !deque.isEmpty() && deque.peekLast() > c) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }

        while (k-- > 0) {
            deque.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            Character c = deque.pollFirst();
            if (leadingZero && c == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    static private String removePreZero(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return s.substring(i);
            }
        }
        return "0";
    }
}
