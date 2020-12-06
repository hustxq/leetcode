package lcp;

public class PaintingPlan22 {
    public static void main(String[] args) {
        System.out.println(paintingPlan2(4, 12));
    }

    static public int paintingPlan2(int n, int k) {
        if (k == 0 || k == n * n) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (n * (i + j) - (i * j) == k) {
                    System.out.println(i + "," + j);
                    res += c(i, n) * c(j, n);
                }
            }
        }
        return res;
    }

    static public int paintingPlan(int n, int k) {
        if (k == 0) {
            return 1;
        }
        int row = k / n;
        //不足一行
        if (row == 0) {
            return 0;
        }
        if (k == n * n) {
            return 1;
        }
        int i = 0;
        boolean f = false;
        int sum = 0;
        for (; i <= row; i++) {
            if ((k - n * i) % (n - i) == 0) {
                int c = (k - n * i) / (n - i);
                System.out.println(i + "," + c + "," + n);
                sum += c(i, n) * c(c, n);
                f = true;
            }
        }

        if (!f) {
            return 0;
        }
        return sum;
    }

    static private int c(int p, int n) {
        if (p == 0 || p == n) {
            return 1;
        }

        int fm = 1;
        int fz = 1;
        for (int i = 1; i <= p; i++) {
            fm = fm * i;
            fz = fz * n;
            n--;
        }
        return fz / fm;
    }
}
