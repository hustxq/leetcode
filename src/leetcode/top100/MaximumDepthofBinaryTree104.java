package leetcode.top100;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qxiong on 2018/1/31 0031.
 */
public class MaximumDepthofBinaryTree104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        /*dfs3(root, 0);
        System.out.println(max);*/

//        System.out.println(maxDepth(root));
        System.out.println(dfs4(root));
    }

    static public int maxDepth2(TreeNode root) {
        dfs3(root, 0);
        return 0;
    }

    /**
     * Accepted solution.
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int m1 = maxDepth(root.left) + 1;
        int m2 = maxDepth(root.right) + 1;
        return m1 < m2 ? m2 : m1;
    }

    static private int dfs4(TreeNode root) {
        if (root == null) return 0;
        int m1 = dfs4(root.left) + 1;
        int m2 = dfs4(root.right) + 1;
        return m1 < m2 ? m2 : m1;
    }


    static int max = 0;

    static private void dfs3(TreeNode root, int p) {
        if (root == null) {
            if (max < p) {
                max = p;
            }
        } else {
            dfs3(root.left, p + 1);
            dfs3(root.right, p + 1);
        }
    }

    static private void dfs2(List<List<Integer>> res, List<Integer> tmp, TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.peek();
            tmp.add(t.val);
//            leaf
            if (t.left == null && t.right == null) {
                List<Integer> l = new LinkedList<>();
                l.addAll(tmp);
                res.add(l);
                stack.pop();
            } else if (t.left != null) {
                stack.push(t.left);
            }
        }
    }

    /**
     * @param res
     * @param tmp
     * @param root
     */
    static private void dfs(List<List<Integer>> res, List<Integer> tmp, TreeNode root) {
        if (root == null) {
            List<Integer> l = new LinkedList<>();
            l.addAll(tmp);
            res.add(l);
        } else {
            tmp.add(root.val);
            dfs(res, tmp, root.left);
            tmp.remove(tmp.size() - 1);
            dfs(res, tmp, root.right);
        }
    }
}
