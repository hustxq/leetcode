package algo2;

import algo.*;
import algo.TreeNode;

import java.util.Vector;

/**
 * Created by sse on 2017/9/18.
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
        int[] postOrder = {4, 5, 2, 6, 7, 3, 1};
        algo.ConstructBinaryTree con = new algo.ConstructBinaryTree();
        algo.TreeNode root = con.buildTree(inOrder,postOrder);
        int depth = getDepth(root);
        System.out.println("depth:"+depth);
        Vector<Vector<Integer>> ret=new Vector<>();
        for (int i = 0; i < depth; i++) {
            Vector<Integer> v = new Vector<>();
            ret.add(v);
        }
        getSolution(ret,root,0);
        for (Vector<Integer> v:ret){
            for (Integer i:v){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void getSolution(Vector<Vector<Integer>> ret, algo.TreeNode root, int level){
        if (root == null) return;
        Vector<Integer> v = ret.get(level);
        v.add(root.value);
        getSolution(ret,root.left,level+1);
        getSolution(ret,root.right,level+1);
    }

    public static int getDepth(TreeNode root){
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return (left>right?left:right)+1;
    }
}
