package leetcode.array;

import java.util.*;

public class TopKFrequent347 {

    public static void main(String[] args) {
        TopKFrequent347 test = new TopKFrequent347();
        int[] ints = test.topKFrequent2(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < value) {
                    queue.poll();
                    queue.offer(new int[]{key, value});
                }
            } else {
                queue.offer(new int[]{key, value});
            }
        }
        int[] iarr = new int[k];
        int p = 0;
        Iterator<int[]> iterator = queue.iterator();
        while (iterator.hasNext()) {
            iarr[p++] = iterator.next()[0];
        }
        return iarr;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<KV> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            KV kv = new KV();
            kv.k = entry.getKey();
            kv.v = entry.getValue();
            list.add(kv);
        }
        Collections.sort(list, (e1, e2) -> e2.v - e1.v);
        int[] arr = new int[k];
        int p = 0;
        for (KV kv : list) {
            if (p < k) {
                arr[p++] = kv.k;
            } else {
                break;
            }
        }
        return arr;
    }

    class KV {
        public int k;
        public int v;
    }
}
