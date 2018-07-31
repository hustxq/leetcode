package leetcode.top100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by qxiong on 2018/1/12.
 */
public class ValidParentheses20 {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    static public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');map.put('}','{');map.put(']','[');
        for (int i = 0, len = s.length(); i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                else {
                    if(stack.pop()!=map.get(ch))return false;
                }
            }
        }
        if (stack.isEmpty())return true;
        return false;
    }
}
