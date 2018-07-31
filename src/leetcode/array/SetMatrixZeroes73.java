package leetcode.array;

import java.util.*;

/**
 * Created by qxiong on 2018/5/21 0021.
 */
public class SetMatrixZeroes73 {

    public static void main(String[] args) {
        int[][] matrix = {
        {0,1,2,0},
        {3,4,5,2},
        {1,3,1,5}
        };
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static public void setZeroes(int[][] matrix) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (map.containsKey(i)) {
                        List<Integer> list = map.get(i);
                        list.add(j);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        map.put(i, list);
                    }
                }
            }
        }
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int i = it.next();
            List<Integer> list = map.get(i);
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
            for (int j = 0; j < list.size(); j++) {
                int c = list.get(j);
                for (int k = 0; k < matrix.length; k++) {
                    matrix[k][c] = 0;
                }
            }
        }
    }

    static public void setZeroes2(int[][] matrix) {
        /*for (int i = 0; i < matrix.length; i++) {

        }*/
        int rn = 0;
        for (int i = 0; i < matrix.length; i++) {
            int res = 1;
            for (int j = 0; j < matrix[0].length; j++) {
                res *= matrix[i][j];
            }
            if (res == 0) {
                rn++;
            }
        }
        int cn = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            int res = 1;
            for (int j = 0; j < matrix.length; j++) {
                res *= matrix[j][i];
            }
            if (res == 0) {
                cn++;
            }
        }
    }
}
