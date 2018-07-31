package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qxiong on 2018/3/21 0021.
 */
public class Triangle120 {

    static public int minimumTotal2(List<List<Integer>> triangle) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                list.add(0);
            }
            res.add(list);
        }

        res.get(0).set(0, triangle.get(0).get(0));
        System.out.println(triangle.get(0).get(0));

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int e = list.size() - 2;
            int size = list.size();
            for (int j = 0; j < size - 1; j++) {
                int q = j - 1, z = j, h = j + 1;
                int min = res.get(i - 1).get(z);
                if (q >= 0) {
                    min = Math.min(res.get(i - 1).get(q), min);
                }
                /*if (h <= e) {
                    min = Math.min(res.get(i - 1).get(h), min);
                }*/
                res.get(i).set(z, min + list.get(j));
            }
            res.get(i).set(size - 1, res.get(i - 1).get(size - 2) + list.get(size - 1));
            for (int k : res.get(i)) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        int min = res.get(res.size() - 1).get(0);
        for (int i : res.get(res.size() - 1)) {
//            System.out.print(i + " ");
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    static public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            res.add(0);
        }
//        1
        res.add(triangle.get(0).get(0));
//        2
        if (triangle.size() >= 2) {
            res.set(0, res.get(0) + triangle.get(1).get(0));
            res.set(1, res.get(0) + triangle.get(1).get(1));
        }
        for (int i = 2; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int size = list.size();
            for (int j = 0; j < size; j++) {
//                res.set(j, res.get(j) + list.get(j));
                if (j == 0) {
                    res.set(j, Math.min(res.get(j), res.get(j + 1)) + list.get(j));
                } else if (j == size - 2) {
                    res.set(j, Math.min(res.get(j), res.get(j - 1)) + list.get(j));
                } else if (j == size - 1) {
                    res.set(j, res.get(j - 1) + list.get(j));
                }
            }
//            res.set(size - 1, res.get(size - 1) + list.get(size - 1));
        }
        int min = res.get(0);
        for (int i : res) {
            System.out.print(i + " ");
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] vals =
                {{-1}, {3, 2}, {-3, 1, -1}};
                /*{
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };*/
        List<List<Integer>> triangle = new ArrayList<>();
        for (int[] i : vals) {
            List<Integer> list = new ArrayList<>();
            for (int j : i) {
                list.add(j);
            }
            triangle.add(list);
        }
        System.out.println(minimumTotal2(triangle));
    }
}
