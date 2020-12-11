package leetcode.array;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PredictPartyVictory649 {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDDRDRDRDDDRRRDDDDDDRRRRRRRRRRRRRR"));
    }

    static public String predictPartyVictory2(String senate) {
        Queue<Integer> dq = new LinkedList<>();
        Queue<Integer> rq = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                rq.offer(i);
            } else {
                dq.offer(i);
            }
        }
        while (!dq.isEmpty() && !rq.isEmpty()) {
            int d = dq.poll();
            int r = rq.poll();
            if (r > d) {
                dq.offer(d + n);
            } else {
                rq.offer(r + n);
            }
        }
        return dq.isEmpty() ? "Radiant" : "Dire";
    }

    static public String predictPartyVictory(String senate) {
        if (senate.length() == 1) {
            return getName(senate);
        } else {
            boolean same = true;
            for (int i = 0; i < senate.length() - 1; i++) {
                if (senate.charAt(i) != senate.charAt(i + 1)) {
                    same = false;
                    break;
                }
            }
            if (same) {
                return getName(senate.charAt(0) + "");
            }
        }

        int rp = 0, dp = 0;
        List<String> list = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                if (dp == 0) {
                    if (list.contains("D")) {
                        list.remove("D");
                    } else {
                        rp++;
                    }
                    list.add("R");
                } else {
                    dp--;
                }
            } else {
                if (rp == 0) {
                    if (list.contains("R")) {
                        list.remove("R");
                    } else {
                        dp++;
                    }
                    list.add("D");
                } else {
                    rp--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
//        System.out.println(sb.toString());
        return predictPartyVictory(sb.toString());
    }

    private static String getName(String senate) {
        if ("R".equals(senate)) {
            return "Radiant";
        }
        return "Dire";
    }
}
