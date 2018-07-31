package leetcode.top100;

/**
 * Created by qxiong on 2018/3/8 0008.
 */
public class InvertBinaryTree226 {

    static public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode nl = invertTree(root.right);
        TreeNode nr = invertTree(root.left);
        root.left = nl;
        root.right = nr;
        return root;
    }
}
