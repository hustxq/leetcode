package leetcode.array;

public class PeakIndexInMountainArray852 {

    public static void main(String[] args) {
        int[] iarr = {3, 4, 5, 6, 0};
        System.out.println(peakIndexInMountainArray(iarr));
    }

    static public int peakIndexInMountainArray2(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] < arr[mid + 1]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    static public int peakIndexInMountainArray(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid < 1) {
                mid++;
            }
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid - 1] > arr[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}
