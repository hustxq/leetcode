package leetcode.array;

import java.util.*;

public class AllCellsDistOrder1030 {
    public static void main(String[] args) {
        int[][] ints = allCellsDistOrder(2, 3, 1, 2);
        for (int[] anInt : ints) {
            System.out.println(anInt[0] + "," + anInt[1]);
        }
    }

    static public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[] dis = new int[R + C + 1];
        TreeMap<Integer, List<HashMap<Integer, Integer>>> map = new TreeMap<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int pos = Math.abs(i - r0) + Math.abs(j - c0);
                HashMap<Integer, Integer> tMap = new HashMap<>();
                tMap.put(i, j);

                if (!map.containsKey(pos)) {
                    List<HashMap<Integer, Integer>> list = new ArrayList<>();
                    list.add(tMap);
                    map.put(pos, list);
                } else {
                    List<HashMap<Integer, Integer>> list = map.get(pos);
                    list.add(tMap);
                }
            }
        }

        int[][] result = new int[R * C][2];
        int p = 0;
        for (List<HashMap<Integer, Integer>> list : map.values()) {
            for (HashMap<Integer, Integer> hashMap : list) {
                for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                    result[p][0] = entry.getKey();
                    result[p][1] = entry.getValue();
                    //System.out.println(p + ":" + entry.getKey() + "," + entry.getValue());
                }
                p++;
            }
        }

        return result;
    }

}
