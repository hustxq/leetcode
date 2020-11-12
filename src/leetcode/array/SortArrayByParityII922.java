package leetcode.array;

public class SortArrayByParityII922 {
    static public int[] sortArrayByParityII2(int[] A) {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                if (A[i] % 2 != 0) {
                    for (int j = i + 1; j < length; j += 2) {
                        if (A[j] % 2 == 0) {
                            swap(A, i, j);
                        }
                    }
                }
            } else {
                if (A[i] % 2 == 0) {
                    for (int j = i + 1; j < length; j += 2) {
                        if (A[j] % 2 != 0) {
                            swap(A, i, j);
                        }
                    }
                }
            }
        }

        return A;
    }

    private static void swap(int[] iarr, int x, int y) {
        int tmp = iarr[x];
        iarr[x] = iarr[y];
        iarr[y] = tmp;
    }

    static public int[] sortArrayByParityII(int[] A) {
        int needEvenPos = -1;
        int needOddPos = -1;
        boolean needEven = false;
        boolean needOdd = false;

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                if (A[i] % 2 != 0 && !needEven) {
                    needEven = true;
                    needEvenPos = i;
//                    System.out.println("needEven: " + needEvenPos);
                }
            } else {
                if (A[i] % 2 == 0 && !needOdd) {
                    needOdd = true;
                    needOddPos = i;
//                    System.out.println("needOdd: " + needOddPos);
                }
            }

            if (needEven && needOdd) {
                int tmp = A[needEvenPos];
                A[needEvenPos] = A[needOddPos];
                A[needOddPos] = tmp;
//                System.out.println(needEvenPos + "," + needOddPos);

                needEven = false;
                needOdd = false;
                i = needEvenPos > needOddPos ? needOddPos : needEvenPos;
            }
        }

        return A;
    }


    public static void main(String[] args) {
        int[] A = new int[]{648, 831, 560, 986, 192, 424, 997, 829, 897, 843};
        sortArrayByParityII2(A);
        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
