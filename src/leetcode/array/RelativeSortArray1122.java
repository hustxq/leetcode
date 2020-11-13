package leetcode.array;

public class RelativeSortArray1122 {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] result = relativeSortArray(arr1, arr2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null) {
            return null;
        }

        int[] bucket = new int[1001];

        for (int i : arr1) {
            bucket[i] += 1;
        }

        //int[] result = new int[arr1.length];
        int p = 0;

        for (int i : arr2) {
            for (int j = 0; j < bucket[i]; j++) {
                arr1[p++] = i;
            }
            bucket[i] = 0;
        }

        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr1[p++] = i;
            }
        }

        return arr1;
    }

}
