package algo;

/**
 * Created by sse on 2017/9/19.
 */
public class BalancedBinaryTree {
    public static int height(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1;
        int diff = leftHeight > rightHeight? leftHeight-rightHeight:rightHeight-leftHeight;
        if (diff > 1) return -1;
        return diff;
    }

    public static boolean isBalance(TreeNode root){
        if (root == null) return true;
        if (height(root) != -1) return true;
        return false;
    }

}
