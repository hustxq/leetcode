package leetcode.top100;

import java.util.*;

/**
 * Created by qxiong on 2018/3/13 0013.
 */
public class LowestCommonAncestorBinaryTree236 {

    static private Map<Integer, List<Integer>> map = new HashMap<>();

    static public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    /**
     * 非递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        dfs(root);

        List<Integer> list1 = null;
        List<Integer> list2 = null;
        /*if (map.containsKey(p.val)) {
            list1 = map.get(p.val);
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) == q.val) {
                    return q;
                }
            }
        }
        if (map.containsKey(q.val)) {
            list2 = map.get(q.val);
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i) == p.val) {
                    return p;
                }
            }
        } else */
        {
            Iterator<Integer> it = map.keySet().iterator();
            while (it.hasNext()) {
                int i = it.next();
                List<Integer> t = map.get(i);
                for (int e : t) {
                    if (e == p.val) {
                        list1 = t;
//                        System.out.println("leaf:" + i);
                    }
                    if (e == q.val) {
                        list2 = t;
//                        System.out.println("leaf:" + i);
                    }
                }
            }
        }

        visList(list1);
        visList(list2);
//        System.out.println(list1.size() + "," + list2.size());
        int pos1 = 0, pos2 = 0;
        if (list1 == list2) {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) == p.val) {
                    pos1 = i;
                }
                if (list1.get(i) == q.val) {
                    pos2 = i;
                }
            }
            return pos1 > pos2 ? q : p;
        } else {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) == p.val) {
                    pos1 = i;
                }
            }
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i) == q.val) {
                    pos2 = i;
                }
            }
            System.out.println(pos1+","+pos2);
            if (pos1 > pos2) {
                for (int i = 0; i <= pos2; i++) {
                    if (list1.get(i) != list2.get(i)) {
//                        System.out.println(i);
                        return new TreeNode(list2.get(i - 1));
                    }
                }
            } else {
                for (int i = 0; i <= pos1; i++) {
                    if (list1.get(i) != list2.get(i)) {
//                        System.out.println(i);
                        return new TreeNode(list1.get(i - 1));
                    }
                }
            }
        }
        return null;
    }

    static private void visList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static List<Integer> list = new ArrayList<>();

    static private void dfs(TreeNode root) {
        if (root == null) return;

        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (list.size() > 0) {
                List<Integer> t = new ArrayList<>();
                for (int i : list) {
                    System.out.print(i + " ");
                    t.add(i);
                }
                System.out.println("\t leaf:" + root.val);
                map.put(root.val, t);
                list.remove(list.size() - 1);
            }
            return;
        }
        dfs(root.left);
        dfs(root.right);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 9, 20, 1, 2, 4);
//        3, 9, 20, 1, null, 15, 7, 2
        TreeNode root = BinaryTree.build(list);
//        dfs(root);
        /*List<Integer> l = BinaryTreeTraversal94.inorderTraversal(root);
        for (int i : l) {
            System.out.println(i);
        }*/

        System.out.println(lowestCommonAncestor2(root, new TreeNode(3), new TreeNode(9)));
    }
}
