package leetcode.string;

public class SortString1370 {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(sortString(s));
    }

    static public String sortString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int cLength = 26;
        char[] carr = new char[cLength];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            carr[c - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();

        int count = len;
        boolean desc = false;

        while (count > 0) {
            if (desc) {
                for (int i = cLength - 1; i >= 0; i--) {
                    if (carr[i] > 0) {
                        carr[i]--;
                        count--;

                        sb.append((char) ('a' + i));
                    }
                }
                desc = false;
            } else {
                for (int i = 0; i < cLength; i++) {
                    if (carr[i] > 0) {
                        carr[i]--;
                        count--;

                        sb.append((char) ('a' + i));
                    }
                }
                desc = true;
            }
        }

        return sb.toString();
    }
}
