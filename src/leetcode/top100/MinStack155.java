package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qxiong on 2018/2/27 0027.
 */
public class MinStack155 {
    public static void main(String[] args) {
//          Your MinStack object will be instantiated and called as such:
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(-2);
//        obj.push(3);
//        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }
}

class MinStack {

    /**
     * initialize your data structure here.
     */
    private List<Integer> stack = null;
    private int min;

    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        if (stack.size() == 1) {
            min = x;
        } else {
            if (min > x) {
                min = x;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int t = stack.remove(stack.size() - 1);
        min = getMin(t);
    }

    public int top() {
//        if (stack.isEmpty()) return;
        int t = stack.get(stack.size() - 1);
//        min = getMin(t);
        return t;
    }

    public int getMin() {
//        if (stack.isEmpty()) return null;
        return min;
    }

    private int getMin(int t) {
        if (min == t && !stack.isEmpty()) {
            min = stack.get(0);
            for (int i = 1; i < stack.size(); i++) {
                if (min > stack.get(i)) {
                    min = stack.get(i);
                }
            }
        }
        return min;
    }
}