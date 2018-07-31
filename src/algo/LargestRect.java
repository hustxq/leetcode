package algo;

import java.util.Stack;
import java.util.Vector;

/**
 * Created by sse on 2017/9/8.
 */
public class LargestRect {

    public static void calc(int[] iarr){
        Stack<Integer> stack = new Stack();
        stack.push(0);
        int sum = 0;
        int i = 0;
        while (i < stack.size()) {
            if (stack.empty() || iarr[i] > iarr[stack.peek()]) {
                stack.push(iarr[i]);
                i++;
            } else {
                int t = stack.pop();
                t = (iarr[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                sum = sum > t ? sum : t;
            }
        }
        System.out.println(sum);
    }

    public static int calcLargest(int[] iarr){
        Stack<Integer> stack = new Stack();
        int area = 0;
        int len=iarr.length;
        for (int i = 0; i < len; i++) {
            if (stack.empty() || iarr[i]>iarr[stack.peek()]){
                stack.push(i);
            }else {
                int start = stack.pop();
                int width = stack.empty()==true?i:(i-stack.peek()-1);
                area = Math.max(area,iarr[start]*width);
                i--;
            }
        }
        while (!stack.empty()){
            int start = stack.pop();
            int width = stack.empty()==true?len:(len-stack.peek()-1);
            area = Math.max(area,iarr[start]*width);
        }
//        System.out.println(area);
        return area;
    }

    public static void main(String[] args) {
        int[] iarr = {2, 1, 5, 6, 3, 4};
//        System.out.println(largestRectangleArea(iarr));
        calcLargest(iarr);
    }

    // O(n) using one stack
    public static int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int area = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || height[stack.peek()] < height[i]) {
                stack.push(i);
            } else {
                int start = stack.pop();
                int width = stack.empty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height[start] * width);
                i--;
            }
        }
        while (!stack.empty()) {
            int start = stack.pop();
            int width = stack.empty() ? height.length : height.length - stack.peek() - 1;
            area = Math.max(area, height[start] * width);
        }
        return area;
    }
}
