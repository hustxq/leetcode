package leetcode.top100;

import java.util.Arrays;

/**
 * Created by qxiong on 2018/2/1 0001.
 */
public class FlattenBinaryTreetoLinkedList114 {
    public static void main(String[] args) {
        TreeNode root = BinaryTree.build(Arrays.asList(1, 2, 5, 3, 4, null, 6));
        inOrder(root);
        System.out.println();

        flatten(root);

        inOrder(root);
    }

    static private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + "\t");
            inOrder(root.right);
        }
    }

    static public void flatten(TreeNode root) {
        flattern(root, null);
    }

    static private TreeNode flattern(TreeNode root, TreeNode pre) {
        if (root == null) return pre;
        pre = flattern(root.right, pre);
        pre = flattern(root.left, pre);
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }

    static private TreeNode dfs(TreeNode root) {
        if (root != null) {

            TreeNode r = dfs(root.right);

//            System.out.println(root.val);

            TreeNode l = dfs(root.left);

            /*if (l == null && r == null) {
                return root;
            }*/
            if (l != null) {
                TreeNode t = l;
                TreeNode n = t.right;
                while (n != null) {
                    t = t.right;
                    n = t.right;
                }
                t.right = root.right;
                root.right = l;
            }
            return root;
        }
        return null;
    }
}
