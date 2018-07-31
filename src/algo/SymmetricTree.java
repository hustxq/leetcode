package algo;

/**
 * Created by sse on 2017/9/19.
 *
 * 对称二叉树
 * 方法一：递归 遍历
 * 方法二：中序遍历，判断是否回文
 * 方法三：层序遍历 双队列
 */
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root){
        if (null == root){
            return true;
        }
        return helper(root.left,root.right);
    }
    public static boolean helper(TreeNode left, TreeNode right){
        if (left==null&&null==right){
            return true;
        }else if (left==null || null==right){
            return false;
        }
        boolean c1 = left.value == right.value;
        boolean c2 = helper(left.left,right.right);
        boolean c3 = helper(left.right,right.left);
        return c1 && c2 && c3;
    }

    public static void main(String[] args) {
        ConstructBinaryTree con = new ConstructBinaryTree();
        int[] in={1,2,2,3,4,4,3};
        TreeNode root = con.buildTreeByBfs(in);
        con.preOrder(root);
        System.out.println(isSymmetric(root));
    }
}
