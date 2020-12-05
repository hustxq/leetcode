package leetcode.array;

public class SumOddLengthSubarrays1588 {

    public static void main(String[] args) {
        int[] arr = {10, 11, 12};
        System.out.println(sumOddLengthSubarrays(arr));
    }

    static public int sumOddLengthSubarrays(int[] arr) {
        int gap = 0;
        int length = arr.length;
        int sum = 0;

        while (gap < length) {
            for (int i = 0; i < length; i++) {
                if (i + gap < length) {
                    for (int j = 0; j <= gap; j++) {
                        sum += arr[i + j];
                    }
                }
            }
            gap += 2;
        }
        return sum;
    }
}
