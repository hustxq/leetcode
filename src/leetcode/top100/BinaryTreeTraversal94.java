package leetcode.top100;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qxiong on 2018/1/15.
 */
public class BinaryTreeTraversal94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        root.right = t1;
        TreeNode t2 = new TreeNode(3);
        t1.left = t2;
        List<Integer> res = inorderTraversal(root);
        for (int i:res){
            System.out.println(i);
        }
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    static public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorder(res,root);
        return res;
    }

    static private void inorder(List<Integer> res,TreeNode root){
        if (root==null){
            return;
        }
        inorder(res,root.left);
        res.add(root.val);
        inorder(res,root.right);
    }
}
