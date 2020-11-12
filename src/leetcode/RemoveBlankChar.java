package leetcode;

/**
 * Created by qxiong on 2018/5/18 0018.
 */
public class RemoveBlankChar {
    public static void main(String[] args) {
        String s = "Reach a Number";
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=' '){
                sb.append(s.charAt(i));
            }else {
                i++;
                if (i<s.length()){
                    sb.append(s.substring(i,i+1).toUpperCase());
                }
            }
        }
        System.out.println(sb);
    }
}
