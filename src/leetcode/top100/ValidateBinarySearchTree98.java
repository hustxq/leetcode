package leetcode.top100;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qxiong on 2018/1/15.
 */
public class ValidateBinarySearchTree98 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode t1 = new TreeNode(3);
        root.right = t1;
        TreeNode t2 = new TreeNode(1);
        root.left = t2;
        t1.right = new TreeNode(5);
        System.out.println(isValidBST(root));
    }

    /**
     * 二叉搜索树 不含重复元素
     * @param root
     * @return
     */
    static public boolean isValidBST(TreeNode root) {
        List<Integer> res = inorderTraversal(root);
        for (int i = 0, len = res.size() - 1; i < len; i++) {
            if (res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    static public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorder(res, root);
        return res;
    }

    static private void inorder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }
}
