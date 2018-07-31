package leetcode.ex;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by qxiong on 2018/1/26 0026.
 */
public class MagicCoin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        if (s == null || s.length() == 0) return;
        int n = Integer.parseInt(s);
//        int[] vals = new int[n + 1];

        int m = n;
        List<String> res = new LinkedList<>();
        while (m > 0) {
            if (m % 2 == 0) {
                m = (m - 2) / 2;
                res.add("2");
            } else {
                m = (m - 1) / 2;
                res.add("1");
            }
        }
        for (int i = 0, len = res.size(); i < len; i++) {
            System.out.print(res.get(len - 1 - i));
        }
    }
}
