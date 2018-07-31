package algo;

import java.util.*;

/**
 * Created by sse on 2017/9/18.
 */
public class ConstructBinaryTree {
    /*
    * 二叉树 前序遍历
    * */
    void preOrder(TreeNode root) {
        if (null != root) {
            System.out.println(root.value);
        }
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    /*二叉树 中序遍历*/
    void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
        /*if (root==null){
            return;
        }
        if (root.left!=null){
            inOrder(root.left);
        }
        System.out.println(root.value);
        if (root.right!=null){
            inOrder(root.right);
        }*/

    }

    /*二叉树 后序遍历*/
    void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }
    }

    /*层序遍历*/
    void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
//            vis value
            System.out.println(tmp.value);
            if (tmp.left!=null){
                queue.offer(tmp.left);
            }
            if (tmp.right!=null){
                queue.offer(tmp.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
        int[] postOrder = {4, 5, 2, 6, 7, 3, 1};
        ConstructBinaryTree con = new ConstructBinaryTree();
        /*TreeNode root = con.buildTree(inOrder, postOrder);
//        TreeNode root = con.buildTreeByPreAndInOrder(pre,inOrder);
        con.preOrder(root);
        con.inOrder(root);
        con.postOrder(root);*/

//        层序遍历
        int[] bfs={1,2,3,4,5,6,7};
        TreeNode root = con.buildTreeByBfs(bfs);
        con.bfs(root);
    }

    /*
    * 根据层序构建完全二叉树
    * */
    public TreeNode buildTreeByBfs(int[] iarr) {
        List<TreeNode> list = new ArrayList<>();
        int len = iarr.length;
        for (int i = 0; i < len; i++) {
            list.add(new TreeNode(iarr[i]));
        }
        int p = 0;
        while (p <= (len - 2) / 2) {
//            left
            if (2 * p + 1 < len) {
                list.get(p).left = list.get(2 * p + 1);
            }
            if (2 * p + 2 < len) {
                list.get(p).right = list.get(2 * p + 2);
            }
            p++;
        }
        return list.get(0);
    }

    /*
    * 根据前序和中序构建二叉树
    * */
    TreeNode buildTreeByPreAndInOrder(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }
//        中序数据与下标 进 map
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return buildByPreIn(in, 0, in.length - 1, pre, 0, pre.length - 1);
    }

    TreeNode buildByPreIn(int[] in, int s0, int e0, int[] pre, int s1, int e1) {
        if (s0 > e0 || s1 > e1) {
            return null;
        }
        TreeNode root = new TreeNode(pre[s1]);
        int mid = map.get(pre[s1]);
        int num = mid - s0;
        root.left = buildByPreIn(in, s0, mid - 1, pre, s1 + 1, s1 + num);
        root.right = buildByPreIn(in, mid + 1, e0, pre, s1 + num + 1, e1);
        return root;
    }

    /*
    *根据中序和后序，递归生成二叉树
    * */
    Map<Integer, Integer> map = new HashMap<>();

    TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (postOrder == null || postOrder.length == 0) {
            return null;
        }
        //        中序数据与下标 进 map
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return build(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1);
    }

    TreeNode build(int[] inOrder, int s0, int e0, int[] postOrder, int s1, int e1) {
        if (s0 > e0 || s1 > e1) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[e1]);
        int mid = map.get(postOrder[e1]);
        int num = mid - s0;
        root.left = build(inOrder, s0, mid - 1, postOrder, s1, s1 + num - 1);
        root.right = build(inOrder, mid + 1, e0, postOrder, s1 + num, e1 - 1);
        return root;
    }
}
