package leetcode.top100;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qxiong on 2018/1/26 0026.
 */
public class SymmetricTree101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(2);
        root.left = l1;
        l1.left = l2;
        root.right = r1;
        r1.left = r2;
        System.out.println(isSymmetric2(root));
    }

    /**
     * 改进
     *
     * @param root
     * @return
     */
    static public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return is(root.left, root.right);
    }

    static private boolean is(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;

        if (l != null && r != null) {
            return l.val == r.val && is(l.left, r.right) && is(l.right, r.left);
        }

        return false;
    }

    /**
     * @param root
     * @return
     */
    static public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        List<Integer> res = inorderTraversal(root);
        for (int i : res) {
            System.out.print(i + "\t");
        }
        int len = res.size();
        for (int i = 0; i < len / 2; i++) {
            if (res.get(i) != res.get(len - 1 - i)) {
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
            res.add(-1);
            return;
        }
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }
}
