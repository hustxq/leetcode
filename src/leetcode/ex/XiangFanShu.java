package leetcode.ex;

import java.util.Scanner;

/**
 * 相反数
 * Created by qxiong on 2018/1/26 0026.
 */
public class XiangFanShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String s = scanner.nextLine();
        int n = scanner.nextInt();
        int m = Integer.parseInt(format(n + ""));
//        System.out.println(n+"\n"+m);
        System.out.println(m + n);
    }

    private static String format(String s) {
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();

        int i = 0;
        for (int len = s.length(); i < len; i++) {
            char ch = s.charAt(i);
            if (ch != '0') {
                return s.substring(i);
            }
        }
        return s;
    }
}
