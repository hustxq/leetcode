package lcp;

public class Calculate17 {
    public static void main(String[] args) {
        Calculate17 test = new Calculate17();
        System.out.println(test.calculate("AB"));
    }

    public int calculate(String s) {
        XY xy = new XY();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('A' == c) {
                a(xy);
            } else {
                b(xy);
            }
        }
        return xy.x + xy.y;
    }

    public static void a(XY xy) {
        xy.x = 2 * xy.x + xy.y;
    }

    public static void b(XY xy) {
        xy.y = 2 * xy.y + xy.x;
    }

    private class XY {
        public int x = 1;
        public int y = 0;
    }
}
