package leetcode.string;

public class LengthofLastWord58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("World"));
    }

    static public int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) return 0;

        int count = 0;
        s = s.trim();
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return count;
            }
            count++;
        }
        return count;
    }
}
