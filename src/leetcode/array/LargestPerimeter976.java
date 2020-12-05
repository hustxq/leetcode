package leetcode.array;

import java.util.Arrays;

public class LargestPerimeter976 {

    public static void main(String[] args) {
        int[] arr = {3,6,2,3};
        System.out.println(largestPerimeter(arr));
    }

    static public int largestPerimeter(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        Arrays.sort(A);

        for (int i = A.length - 1; i > 1; i--) {
            if (isTriangel(A[i - 2], A[i - 1], A[i])) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }

    static private boolean isTriangel(int a, int b, int c) {
        if (a + b > c && b - a < c) {
            return true;
        }
        return false;
    }
}
