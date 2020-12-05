package leetcode.array;

import java.util.*;

public class LeastInterval621 {

    public static void main(String[] args) {
        LeastInterval621 test = new LeastInterval621();

        char[] carr = new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'};
        System.out.println(test.leastInterval(carr, 2));
    }

    public int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

    public int leastInterval(char[] tasks, int n) {
        int taskLength = tasks.length;

        if (n == 0) {
            return taskLength;
        }
        //gap
        n += 1;

        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        List<KV> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(new KV(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list, (e1, e2) -> e2.c - e1.c);
//        for (KV kv : list) {
//            System.out.println(kv.k + "," + kv.c);
//        }
//        KV kv1 = list.get(0);
        int len = (list.size() + 1) * n + 1;
        char[] carr = new char[len];
        for (int i = 0; i < len; i++) {
            carr[i] = '0';
        }

        for (int i = 0; i < list.size(); i++) {
            int p = 0;
            while (p < len) {
                if (carr[p] == '0') {
                    break;
                }
                p++;
            }
            KV kv = list.get(i);
            for (int j = 0; j < kv.c; j++) {
                carr[p] = kv.k;
                System.out.println("index:" + p);
                p += n;
            }
        }

        for (int i = 0; i < carr.length; i++) {
            if (carr[len - 1 - i] != '0') {
                return len - i;
            }
        }

        return 0;
    }

    class KV {
        public char k;
        public int c;

        public KV(char k, int c) {
            this.k = k;
            this.c = c;
        }
    }

}
