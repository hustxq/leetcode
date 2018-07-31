package leetcode.top100;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qxiong on 2018/1/22 0022.
 */
public class MergeIntervals56 {

    public static void main(String[] args) {
        List<Interval> ints = new LinkedList<>();
        ints.add(new Interval(1, 3));
        ints.add(new Interval(1, 2));
        ints.add(new Interval(1, 3));
        ints.add(new Interval(2, 6));
        ints.add(new Interval(8, 10));
        ints.add(new Interval(1, 18));
        List<Interval> res = merge2(ints);
        for (Interval i : res) {
            System.out.println(i);
        }
    }

    /**
     * 改进
     *
     * @param intervals
     * @return
     */
    static public List<Interval> merge2(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
//        sort by s and end
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start) return 1;
                else if (o1.start == o2.start) {
                    if (o1.end > o2.end) return 1;
                    else if (o1.end == o2.end) return 0;
                    else return -1;
                }else return -1;
//                return o1.start - o2.start;
            }
        });
        /*for (Interval i : intervals) {
            System.out.println(i);
        }*/
        List<Interval> res = new LinkedList<>();
        int size = intervals.size();
        boolean[] removed = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!removed[i]) {
                Interval i1 = intervals.get(i);
                int s = i1.start, e = i1.end;
                for (int j = 0; j < size; j++) {
                    if (i != j) {
                        boolean f = false;
                        if (!removed[j]) {
                            Interval i2 = intervals.get(j);
                            if (s <= i2.start) {
                                if (i2.start <= e) {
                                    if (i2.end <= e) {
                                        f = true;
                                    } else {
                                        e = i2.end;
                                        f = true;
                                    }
                                }
                            } else {
                                if (i2.end < s) {
                                } else {
                                    if (i2.end <= e) {
                                        s = i2.start;
                                        f = true;
                                    } else {
                                        s = i2.start;
                                        e = i2.end;
                                        f = true;
                                    }
                                }
                            }
                            if (f) {
                                removed[j] = true;
                            }
                        }
                    }
                    /*for (boolean b : removed) {
                        System.out.print(b + "\t");
                    }
                    System.out.println();*/
                }
//                removed[i] = true;
                res.add(new Interval(s, e));
            }
        }
        /*if (!removed[size - 1]) {
            res.add(intervals.get(size - 1));
        }*/
        return res;
    }

    /**
     * 存在问题
     *
     * @param intervals
     * @return
     */
    static public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new LinkedList<>();
        int size = intervals.size();
        int mid = size / 2;
//        mergeTo(re);
        while (size > 1) {
            int s = size / 2;
            List<Interval> tList = new LinkedList<>();

            for (int i = 0; i < s; i += 2) {
                Interval i1 = intervals.get(i);
                Interval i2 = intervals.get(i + 1);
                if (i1.start <= i2.start) {
                    if (i2.start <= i1.end) {
                        if (i2.end <= i1.end) {
                            tList.add(i1);
                        } else {
                            tList.add(new Interval(i1.start, i2.end));
                        }
                    } else {
                        tList.add(i1);
                        tList.add(i2);
                    }
                } else {
                    if (i2.end < i1.start) {
                        tList.add(i1);
                        tList.add(i2);
                    } else {
                        if (i2.end <= i1.end) {
                            tList.add(new Interval(i2.start, i1.end));
                        } else {
                            tList.add(i2);
                        }
                    }
                }
            }
            if (size % 2 != 0) {
                tList.add(intervals.get(size - 1));
            }

            intervals = tList;
            size = intervals.size();
        }
        return res;
    }


}
