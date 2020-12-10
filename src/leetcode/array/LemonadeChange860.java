package leetcode.array;

public class LemonadeChange860 {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5}));
    }

    static public boolean lemonadeChange(int[] bills) {
        int b5 = 0, b10 = 0;

        for (int bill : bills) {
            if (bill == 5) {
                b5++;
            } else if (bill == 10) {
                if (b5 == 0) {
                    return false;
                } else {
                    b5--;
                    b10++;
                }
            } else if (bill == 20) {
                if (b10 == 0 && b5 < 3) {
                    return false;
                } else if (b10 > 0 && b5 == 0) {
                    return false;
                } else {
                    if (b10 == 0) {
                        b5 -= 3;
                    } else {
                        b5--;
                        b10--;
                    }
                }
            }
        }
        return true;
    }
}
