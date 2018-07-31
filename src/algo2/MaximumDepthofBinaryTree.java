package algo2;

import algo.*;

import java.util.*;

/**
 * Created by sse on 2017/9/15.
 */
public class MaximumDepthofBinaryTree {
    public static int d;

    public static void main(String[] args) {
        algo.TreeNode root = new algo.TreeNode(1);
        algo.TreeNode l1 = new algo.TreeNode(2);
        algo.TreeNode r1 = new algo.TreeNode(3);
        root.left = l1;
        root.right = r1;
        algo.TreeNode l12 = new algo.TreeNode(4);
        algo.TreeNode r12 = new algo.TreeNode(5);
        l1.left = l12;
        l1.right = r12;
        dfs(root);
//        bfs(root);
        /*findMaxDepth(root, 1);
        System.out.println("maxDepth:" + d);*/
        MinimumDepthofBinaryTree.minDepth(root,1);
        System.out.println("minDepth:"+MinimumDepthofBinaryTree.d);
    }

    /*
    *广度优先遍历
    * queue add remove 可能会抛出异常 不太推荐
    * offer poll 会返回true false 相对友好
    * */
    public static void bfs(algo.TreeNode root){
        Queue<algo.TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level ++;
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                algo.TreeNode node = queue.remove();
                System.out.print(node.value+" ");
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
        System.out.println("level:"+level);
    }
    /*
    * 非递归实现先序遍历二叉树
    * 利用栈 Stack
    * */
    public static void dfs(algo.TreeNode root) {
        Map<algo.TreeNode, algo.TreeNode> map = new HashMap<>();
        List<algo.TreeNode> leaf = new ArrayList<>();

        Stack<algo.TreeNode> stack = new Stack();
        boolean[] barr=new boolean[10];
        root.vis = true;
        stack.push(root);
        map.put(root,null);

        int deep = 1;
        while (!stack.empty()) {
//            System.out.println(stack.peek());
            algo.TreeNode node = stack.peek();
            if ((node.left == null && node.right==null)  ){
                System.out.println(node.value);
//                为叶子节点时，添加到leaf
                leaf.add(node);
                deep = Math.max(deep,stack.size());
                node.vis = true;
                stack.pop();
            }else if (node.left!=null && !node.left.vis){
                stack.push(node.left);
                map.put(node.left,node);
            }else if (node.right!=null && !node.right.vis){
                stack.push(node.right);
                map.put(node.right,node);
            }else if ((node.left.vis && node.right.vis)){
                node.vis = true;
                System.out.println(node.value);
                stack.pop();
            }
        }
        System.out.println("maxDepth:"+deep);
        for (int i = 0; i < leaf.size(); i++) {
            algo.TreeNode l = leaf.get(i);
//            System.out.println(l.value+"->");
            while (true){
                algo.TreeNode t = map.get(l);
                if (t!=null){
                    System.out.print(l.value+"->");
                    l = t;
                }else {
                    System.out.println(l.value);
                    break;
                }
            }
        }
    }

    /*
    * 递归实现深度遍历
    * 根左右 先序遍历
    * */
    public static void findMaxDepth(algo.TreeNode root, int level) {
        System.out.println(root.value);
        if (null == root.left && null == root.right) {
            d = Math.max(level, d);
            return;
        }
        if (root.left != null) {
            findMaxDepth(root.left, level + 1);
        }
        if (root.right != null) {
            findMaxDepth(root.right, level + 1);
        }
    }
}
class MinimumDepthofBinaryTree{

    static int d = Integer.MAX_VALUE;

    public static void minDepth(algo.TreeNode root, int p){
        if (root.left==null && root.right==null){
            d = Math.min(d,p);
        }
        if (root.left!=null){
            minDepth(root.left,p+1);
        }
        if (root.right != null){
            minDepth(root.right,p+1);
        }
    }
}