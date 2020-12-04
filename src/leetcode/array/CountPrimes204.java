package leetcode.array;

public class CountPrimes204 {
    public static void main(String[] args) {
        System.out.println(countPrimes2(5000000));
    }

    static public int countPrimes2(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }

        int[] arr = new int[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (arr[i] == 0) {
                count++;
                for (int j = 2 * i; j < n; j += i) {
                    if (arr[j] == 0) {
                        arr[j] = 1;
                    }
                }
            }
        }

        return count;
    }

    static public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
