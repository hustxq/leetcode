package leetcode.linked;


import leetcode.top100.TreeNode;

public class CountNodes222 {

    static public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
