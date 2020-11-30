package leetcode.linked;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class MaxQueue {
    private Queue<Integer> queue;
    private int max = Integer.MIN_VALUE;
    private TreeMap<Integer, Integer> map;

    public MaxQueue() {
        queue = new LinkedList<>();
        map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return max;
    }

    public void push_back(int value) {
        queue.add(value);
        if (max < value) {
            max = value;
        }
        if (map.containsKey(value)) {
            map.put(value, map.get(value) + 1);
        } else {
            map.put(value, 1);
        }
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer poll = queue.poll();
        Integer value = map.get(poll);
        if (value > 1) {
            map.put(poll, value - 1);
        } else {
            map.remove(poll);

            if (poll == max) {
                max = map.firstKey();
            }
        }
        return poll;
    }
}
