package leetcode.ex;

import java.util.*;

/**
 * 字符串碎片
 * Created by qxiong on 2018/1/26 0026.
 */
public class CharSuiPian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
            StringBuilder sb = new StringBuilder();
            sb.append(ch + "");
            int j;
            for (j = i + 1; j < s.length(); j++) {
                if (ch == s.charAt(j)) {
                    sb.append(ch + "");
                } else {
//                    System.out.println(sb.toString());
                    if (map.containsKey(ch - 'a')) {
                        List<Integer> l = map.get(ch - 'a');
                        l.add(sb.toString().length());
                    } else {
                        List<Integer> l = new ArrayList<>();
                        l.add(sb.toString().length());
                        map.put(ch - 'a', l);
                    }
                    break;
                }
            }
            i = j;
            System.out.println(sb.toString());
            if (j == s.length()){
                if (map.containsKey(ch - 'a')) {
                    List<Integer> l = map.get(ch - 'a');
                    l.add(sb.toString().length());
                } else {
                    List<Integer> l = new ArrayList<>();
                    l.add(sb.toString().length());
                    map.put(ch - 'a', l);
                }
            }
        }

        int slice = 0;
        for (int i = 0; i < 26; i++) {
            if (map.containsKey(i)) {
                int ti = calc(map.get(i));
                System.out.println(ti);
                slice += ti;
            }
        }
        System.out.printf("%.2f",(s.length() * 1.0) / slice);
    }

    static private int calc(List<Integer> list) {
        return list.size();
        /*if (list.size() == 1) return 1;
        int m = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            m = gc(m, list.get(i));
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i) / m;
        }
        return sum;*/
    }

    static private int gc(int m, int n) {
        if (n == 0) return m;
        return gc(n, m % n);
    }
}
