package intv;

public class GetKthMagicNumber1709 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(getKthMagicNumber(i));
        }
    }

    static public int getKthMagicNumber(int k) {
        int[] arr = new int[k];
        arr[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;

        for (int i = 1; i < k; i++) {
            arr[i] = Math.min(arr[p3] * 3, Math.min(arr[p5] * 5, arr[p7] * 7));
            if (arr[i] == arr[p3] * 3) p3++;
            if (arr[i] == arr[p5] * 5) p5++;
            if (arr[i] == arr[p7] * 7) p7++;
        }
        return arr[k - 1];
    }
}
