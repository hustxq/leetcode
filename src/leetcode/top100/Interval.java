package leetcode.top100;

/**
 * Created by qxiong on 2018/1/22 0022.
 */

//  Definition for an interval.
public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[" +
                "start=" + start +
                ", end=" + end +
                ']';
    }
}
