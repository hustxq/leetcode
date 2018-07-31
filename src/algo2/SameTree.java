package algo2;

import algo.TreeNode;

/**
 * Created by sse on 2017/9/19.
 */
public class SameTree {

    public static boolean isSame(TreeNode r1, TreeNode r2){
        if (r1 == null && null == r2) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.value == r2.value){
            boolean c1 = isSame(r1.left,r2.left);
            boolean c2 = isSame(r1.right,r2.right);
            return c1 && c2;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
