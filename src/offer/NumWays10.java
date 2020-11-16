package offer;

public class NumWays10 {

    public static void main(String[] args) {
        System.out.println(numWays2(7));
    }

    static public int numWays2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int res = 3;
        int a = 1, b = 2;
        while (n-- > 2) {
            res = (a + b) % 1000000007;
            a = b % 1000000007;
            b = res % 1000000007;
        }

        return res;
    }

    static public int numWays(int n) {
        if (n == 0) {
            return 1;
        }

        int[] result = new int[100];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        int p = 2;

        while (n > p) {
            int tmp = ((result[p] % 1000000007) + (result[p - 1] % 1000000007)) % 1000000007;
            result[++p] = tmp;
        }

        return result[n];
    }
}
