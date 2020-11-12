package leetcode.string;

public class ReachANumber754 {
    public static void main(String[] args) {
        ReachANumber754 test = new ReachANumber754();
        System.out.println(test.reachNumber(-5));
    }
    public int reachNumber(int target) {
        if (target == 0) return 0;
        int pos = 0;
        int step = 1;
        target = Math.abs(target);
        while (pos + step < target) {
            pos = pos + step;
            step++;
        }
        if (pos + step == target) return step++;

        boolean r = false;
        while (pos + step != target) {
            if (r) {
                pos += step;
            } else {
                pos -= step;
            }
            step++;
            r = !r;
        }
        return step++;
    }
}
