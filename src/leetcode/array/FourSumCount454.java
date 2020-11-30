package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSumCount454 {

    static public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        int count = 0;
        for (int i : C) {
            for (int j : D) {
                count += map.getOrDefault(-i - j, 0);
            }
        }
        return count;
    }

    static public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int[] arr1 = new int[A.length * B.length];
        int[] arr2 = new int[C.length * D.length];

        int p = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                arr1[p++] = A[i] + B[j];
            }
        }

        p = 0;

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                arr2[p++] = C[i] + D[j];
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int count = 0;

        int i = 0;
        int j = arr2.length - 1;
        while (i < arr1.length && j >= 0) {
            int sum = arr1[i] + arr2[j];
            if (sum == 0) {

            }
        }

        return count;
    }
}
