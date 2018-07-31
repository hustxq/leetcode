package leetcode.top100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qxiong on 2018/1/30 0030.
 */
public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {
//        int[] vals = new int[]{};
//        buildBinaryTree();
        List<Integer> list = Arrays.asList(3, 9, 20, null, null, 15, 7);

        TreeNode root = BinaryTree.build(list);
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);*/
        List<List<Integer>> res = levelOrder(root);
        for (List<Integer> l : res) {
            for (int i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    private static void buildBinaryTree() {
        List<Integer> list = Arrays.asList(3, 9, 20, null, null, 15, 7);
//        get level
        int level = 1;
        int len = list.size();
        while (level <= len) {
            if (Math.pow(2, level) <= len + 1 && len + 1 < Math.pow(2, level + 1)) {
                break;
            }
            level++;
        }
        System.out.println(level);
        TreeNode root = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
//        TreeNode tmp = root;
        int s = 0;
        while (s < level) {

        }

    }

    static public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tlist = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode t = queue.remove();
                tlist.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(tlist);
        }
        return res;
    }
}
