package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qxiong on 2018/3/16 0016.
 */
public class PathSumIII437 {

    static int c = 0;

    static public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return find(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        /*preOrder(root, sum);
        return c;*/
    }

    static private int find(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) + find(node.left, sum - node.val) + find(node.right, sum - node.val);
    }

    //  preOrder
    static private void preOrder(TreeNode root, int sum) {
        if (root != null) {
//            vis(root, sum);
            visLeaf(root);
            preOrder(root.left, sum);
            preOrder(root.right, sum);
        }
    }

    static List<Integer> res = new ArrayList<>();

    static private void vis(TreeNode root, int sum) {
        if (root == null) return;
        res.add(root.val);
        if (sum == root.val) {
            c++;
            for (int i : res)
                System.out.print(i + " ");
            System.out.println();
        } else {
            vis(root.left, sum - root.val);
            vis(root.right, sum - root.val);
        }
        res.remove(res.size() - 1);
    }

    public static void main(String[] args) {

        TreeNode root = BinaryTree.build(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1));
//        10,5,-3,3,2,null,11,3,-2,null,1
//        5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1
        /*List<Integer> v = BinaryTreeTraversal94.inorderTraversal(root);
        for (int i:v){
            System.out.println(i);
        }*/
        int sum = 22;
//        22 8
//        System.out.println(pathSum(root, sum));
        /*preOrder(root, sum);
        System.out.println(c);*/
        preOrder(root, sum);
//        visLeaf(root);
    }

    //    static List<Integer> res = new ArrayList<>();
    static private void visLeaf(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        if (root.left == null && root.right == null) {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(res.size() - 1 - i) + " ");
            }
            System.out.println();
        } else {
            visLeaf(root.left);
            visLeaf(root.right);
        }
        res.remove(res.size() - 1);
    }

}
