package algo;

import java.util.Stack;

/**
 * Created by sse on 2017/9/15.
 */
public class MaxCircle {
    static int num;
    static int[] ids;
    public static void main(String[] args) {
//        input
        num = 6;
        ids = new int[] {0,2,3,2,};
//        每个编号为起点
        for (int i = 1; i < num; i++) {
            findMax(i);
        }

        System.out.println("max:"+max);
    }

    static int max = 0;

    public static void findMax(int s){
        boolean[] vis = new boolean[num];
//        int p = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.empty() && num!=stack.size()){
            int lover = ids[stack.peek()];
//            首尾成环后 比较人数
            if (lover == s){
                max = Math.max(max , stack.size());
                return;
            }else if (vis[lover]){ // 不是首尾的环，剔除
//                stack.pop();
                return;
            }else { //没有遍历过
                stack.push(lover);
                vis[lover] = true;
            }
        }
    }
}
