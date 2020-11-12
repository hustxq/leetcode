package offer;

public class T21 {
    static public void reOrderArray(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }
        int start = 0, end = array.length - 1;
        int tmp;
        while (start < end) {
            if (array[start] % 2 != 0) {
                start++;
            }
            if (array[end] % 2 == 0) {
                end--;
            }
            if (start < end && array[start] % 2 == 0 && array[end] % 2 != 0) {
                tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;

            }
        }
    }

    static public void reOrderArray1(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }
        int len = array.length;
        int tmp;
        for (int i = 0; i < len - 1; i++) {
            if (isEven(array[i])) {
                for (int j = i + 1; j < len; j++) {
                    if (!isEven(array[j])) {
                        //swap
                        tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                        break;
                    }
                }
            }
        }
    }

    static public void reOrderArray2(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }
        int len = array.length;
        int[] iarr = new int[len];
        int p = 0;
        for (int i = 0; i < len; i++) {
            if (!isEven(array[i])) {
                iarr[p++] = array[i];
            }
        }
        for (int i = 0; i < len; i++) {
            if (isEven(array[i])) {
                iarr[p++] = array[i];
            }
        }
        System.arraycopy(iarr,0,array,0,len);
    }

    static private boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        int[] iarr = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray2(iarr);
        for (int e : iarr) {
            System.out.print(e + "\t");
        }
    }
}
