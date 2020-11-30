package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue406 {

    static public int[][] reconstructQueue2(int[][] people) {
        //高度 h 逆序; 位置 k 顺序
        Arrays.sort(people, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e2[0] - e1[0]);

        List<int[]> list = new ArrayList<>(people.length);
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[people.length][2]);
    }

    static public int[][] reconstructQueue(int[][] people) {
        List<People> list = new ArrayList<>();
        People tmp;

        for (int i = 0; i < people.length; i++) {
            tmp = new People();
            tmp.h = people[i][0];
            tmp.k = people[i][1];
            sortWithInsert(list, tmp);
        }
        return people;
    }

    static private void sortWithInsert(List<People> list, People people) {
        int size = list.size();

        if (size == 0) {
            list.add(people);
        } else {
            int c = people.k;
            int i = 0;

            for (; i < size; i++) {
                People tmp = list.get(i);
                if (tmp.h >= people.h) {
                    c--;
                    if (c < 0) {
                        break;
                    }
                }
            }

            list.add(i, people);
        }
    }

    private static class People {
        public int h;
        public int k;
    }
}
