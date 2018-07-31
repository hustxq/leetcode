package algo2;

import algo.ConstructBinaryTree;
import algo.TreeNode;

/**
 * 二叉树中根到叶子节点的和为目标值
 *
 * @Author hustxq.
 * @Date 2017/9/20 9:52
 */
public class PathSum {
    public static void main(String[] args) {
        ConstructBinaryTree con = new ConstructBinaryTree();

        /*int[] pre = {5,4,11,7,2,8,13,4,1};
        int[] in = {7,11,2,4,5,13,8,4,1};
        int[] post = {7,2,11,4,13,1,4,8,5};*/
        int[] level = {5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 1};
        TreeNode root = con.buildTreeByBfs(level);//con.buildTree(in,post);
        System.out.println(isPathSum(root, 22));
    }

    public static boolean isPathSum(TreeNode root, int target) {
        if (root == null) return false;
        return findPathSum(root, target);
    }

    public static boolean findPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && root.value == target) {
            return true;
        }
        boolean c1 = findPathSum(root.left, target - root.value);
        boolean c2 = findPathSum(root.right, target - root.value);
        return c1 || c2;
    }
}
