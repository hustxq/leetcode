package leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

public class MaxNumber321 {
    public static void main(String[] args) {
//        String s = removeKdigits("1234321", 7);
//        System.out.println(s);
        int[] num1 = {5, 1, 0};
        int[] num2 = {5, 2, 1};
        int[] ints = maxNumber(num1, num2, 3);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    static public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        StringBuilder s1 = new StringBuilder();
        for (int i : nums1) {
            s1.append(i + "");
        }
        StringBuilder s2 = new StringBuilder();
        for (int i : nums2) {
            s2.append(i + "");
        }
        String maxString = "";
        for (int i = 0; i <= k; i++) {
            String res1 = removeKdigits(s1.toString(), nums1.length - i);
            String res2 = removeKdigits(s2.toString(), nums2.length - k + i);
            String tmp = mergeString(res1, res2);
            System.out.println("tmp:" + tmp);
            if (maxString.length() < tmp.length()) {
                maxString = tmp;
            } else if (maxString.length() == tmp.length() && maxString.compareTo(tmp) < 0) {
                maxString = tmp;
            }
        }
        System.out.println(maxString);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxString.charAt(i) - '0';
        }
        return res;
    }

    static private String mergeString(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 == 0 && length2 == 0) {
            return "";
        }
        if (length1 == 0) {
            return (s2);
        }
        if (length2 == 0) {
            return (s1);
        }
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();

        while (i < length1 || j < length2) {
            if (i == length1) {
                sb.append(s2.charAt(j++));
            } else if (j == length2) {
                sb.append(s1.charAt(i++));
            } else {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (s1.substring(i + 1).length() == 0 && s2.substring(j + 1).length() == 0) {
                        sb.append(s1.charAt(i++));
                    } else if (s1.substring(i + 1).length() > 0) {
                        if (s1.charAt(i + 1) > s1.charAt(i)) {
                            sb.append(s1.charAt(i++));
                        }
                    } else if (s2.substring(j + 1).length() > 0) {
                        if (s2.charAt(j + 1) > s2.charAt(j)) {
                            sb.append(s2.charAt(j++));
                        }
                    } else {
                        sb.append(s1.charAt(i++));
                    }
                } else if (s1.charAt(i) < s2.charAt(j)) {
                    sb.append(s2.charAt(j++));
                } else {
                    sb.append(s1.charAt(i++));
                }
            }
        }
        return sb.toString();
    }

    static public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || num.length() <= k) {
            return "";
        }

        if (k == 0) {
            return num;
        }

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && !deque.isEmpty() && deque.peekLast() < c) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }

        while (k-- > 0) {
            deque.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            Character c = deque.pollFirst();
            sb.append(c);
        }

        return sb.toString();
    }
}
