package leetcode.ex;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> list = new ArrayList();
        while (s.hasNext()) {
            String str = s.nextLine();
            System.out.println(Integer.valueOf(str.substring(2), 16));
        }
    }

    static private int calc(String s) {
        int sum = 0;
        for (int i = 2, len = s.length(); i < len; i++) {
            sum = sum * 16 + h2(s.charAt(i));
        }
        //System.out.println(sum);
        return sum;
    }

    static private int h2(char c) {
        if ('A' <= c && c <= 'F') {
            return c - 'A' + 10;
        }
        return c - '0';
    }
}
