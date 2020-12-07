package intv;

public class Add1701 {
    public static void main(String[] args) {
        System.out.println(substract(100, 1));
//        System.out.println(add(-111, 111));
    }

    static public int add(int a, int b) {
        int m = a ^ b;
        int n = a & b;
        while (n != 0) {
            n = n << 1;
            int t = m ^ n;
            n = m & n;
            m = t;
        }
        return m;
    }

    static public int substract(int a, int b) {
        return add(a, -b);
    }
}
