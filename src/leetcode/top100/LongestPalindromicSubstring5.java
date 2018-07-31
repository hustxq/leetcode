package leetcode.top100;

/**
 * Created by qxiong on 2018/1/25 0025.
 */
public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        String s = "esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq";
//                "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(s));
    }

    static public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        String word1 = s;
        String word2 = new StringBuilder(s).reverse().toString();
        int m = s.length(), n = s.length();
        int[][] vals = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            vals[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            vals[0][i] = 0;
        }
        int max = 0;
        int p = 0;
        String res = "";
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = word1.charAt(i - 1);
                if (ch == word2.charAt(j - 1)) {
                    vals[i][j] = vals[i - 1][j - 1] + 1;
                    if (max < vals[i][j]) {
                        max = vals[i][j];
                        res = s.substring(i - vals[i][j], i);
                    }
                } else {
                    vals[i][j] = 0;
                }
            }
        }
        return res;
    }

    static private boolean is(String s) {
        for (int i = 0, len = s.length(); i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }
        return true;
    }

    static private String get(String s) {
        if (s == null || s.length() < 2) return s;
        String word1 = s;
        String word2 = new StringBuilder(s).reverse().toString();
        int m = s.length(), n = s.length();
        int[][] vals = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            vals[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            vals[0][i] = 0;
        }
        int max = 0;
        int p = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = word1.charAt(i - 1);
                if (ch == word2.charAt(j - 1)) {
                    vals[i][j] = vals[i - 1][j - 1] + 1;
                } else {
                    vals[i][j] = 0;
                }
            }
        }
        String res = "";
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (vals[i][j] != 0) {
                    if (is(s.substring(i - vals[i][j], i))) {
                        if (max < vals[i][j]) {
                            max = vals[i][j];
                            res = s.substring(i - vals[i][j], i);
                        }
                    }
                }
            }
        }
        return res;
//        System.out.println(max + "," + p);
        /*StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            sb.append(s.charAt(p - max + i) + "");
        }
        s = sb.toString();
//        System.out.println(sb.reverse().toString());
        return s;*/
    }
}
