package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII119 {
    public static void main(String[] args) {
        List<Integer> row = getRow(0);
        for (Integer i : row) {
            System.out.print(i + "\t");
        }
    }

    static public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> list = new ArrayList<>(rowIndex);
        for (int i = 0; i < rowIndex; i++) {
            list.add(1);
        }

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i) {
                    list.set(j, 1);
                } else {
                    list.set(j, list.get(j - 1) + list.get(j));
                }
            }
        }

        return list;
    }
}
