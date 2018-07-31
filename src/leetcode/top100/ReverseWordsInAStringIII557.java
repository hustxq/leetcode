package leetcode.top100;

/**
 * Created by qxiong on 2018/1/12.
 */
public class ReverseWordsInAStringIII557 {
    public static void main(String[] args) {
        /*String[] sarr = " Let's   take LeetCode  contest  ".trim().split("[ |]+");
        for (String s:sarr){
            System.out.println(s);
        }
        System.out.println(reverse("123"));*/
        System.out.println(reverseWords("Let's go"));
    }
    static public String reverseWords(String s) {
        if (s==null || s.length()==0) return s;
        String[] sarr = s.trim().split("[ |]+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0,len = sarr.length; i < len; i++) {
            sb.append(reverse(sarr[i]));
            if (i<len-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String reverse(String s){
        if (s==null || s.length()==0)return "";
        return reverse(s.substring(1))+""+s.charAt(0);
    }
}
