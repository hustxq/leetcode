package leetcode.string;

public class ReverseWordsInAString151 {
    public static void main(String[] args) {
        String s = "the ";
        System.out.println(reverseWords(s));
    }

    static public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        s = s.trim();
        if (!s.contains(" ")) return s;

        int p = s.indexOf(" ");
        System.out.println(p);
        if (p <= 0) return s;
        String pre = s.substring(0, p);
        String suf = s.substring(p, s.length());
//        System.out.println(suf + " " + pre);
        return reverseWords(suf) + " " + pre;
    }
}
