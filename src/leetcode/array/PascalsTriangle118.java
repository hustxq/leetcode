package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(0);
        for (List<Integer> list : generate) {
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    static public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows < 1) {
            return list;
        }

        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        list.add(tmp);
        if (numRows == 1) {
            return list;
        }

        for (int i = 1; i < numRows; i++) {
            tmp = new ArrayList<>();
            List<Integer> preList = list.get(i - 1);

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tmp.add(1);
                } else {
                    tmp.add(preList.get(j - 1) + preList.get(j));
                }
            }
            list.add(tmp);
        }

        return list;
    }
}
