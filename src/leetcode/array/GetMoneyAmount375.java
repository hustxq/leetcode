package leetcode.array;

public class GetMoneyAmount375 {
    public static void main(String[] args) {
        //System.out.println(getMoneyAmount(10));
        System.out.println(calc(1, 10));
    }

    static public int calc(int s, int e) {
        if (s >= e) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = (s + e) / 2; i <= e; i++) {
            int res = i + Math.max(calc(s, i - 1), calc(i + 1, e));
            min = Math.min(min, res);
        }
        return min;
    }

    static public int getMoneyAmount(int n) {
        int[] arr = new int[n + 1];
        binarySearch(arr, 0, 1, n);
        int max = arr[1];
        for (int i = 1; i < arr.length; i++) {
            System.out.println(i + ":" + arr[i]);
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    static private void binarySearch(int[] arr, int cost, int s, int n) {
        if (s == n) {
            if (arr[s] == 0) {
                arr[s] = cost + s;
            }
            return;
        }

        while (s < n) {
            int mid = s + (n - s) / 2;
            System.out.println("mid:" + mid);
            if (arr[mid] == 0) {
                arr[mid] = cost + mid;
            }
            binarySearch(arr, mid, s, mid - 1);
            binarySearch(arr, mid, mid + 1, n);
        }
    }
}
